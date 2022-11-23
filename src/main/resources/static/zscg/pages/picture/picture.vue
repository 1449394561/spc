<template>
	<view class="content">
		<view class="button">
			<button @click="choose" value="请选择文件">请选择文件</button>
		</view>
		<view class="img" v-for="imgPath in imgPaths">
			<image class="img_img" :src="imgPath"></image>
		</view>
		<view>
			{{form}}
		<image :src="'data:image/jpg;base64,' + form"></image>
		<button @click="query" value="刷新">请刷新图片</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello',
				imgPaths:[],
				form:''
			}
		},
		onLoad() {

		},
		// computed:{
		// captchaSrc(){
		// return this.form.replace(/[\r\n]/g, "");
		// }
		// },
		methods: {
			choose(e){
				var me = this;
				uni.chooseImage({
				    count: 6, //默认9
				    sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
				    sourceType: ['album'], //从相册选择
				    success: function (res) {
						me.imgPaths = res.tempFilePaths;
						console.log(me.imgPaths);
						uni.uploadFile({
						            url: 'http://localhost:9090/cs23/uploadImg', //仅为示例，非真实的接口地址
						            filePath: me.imgPaths[0],
						            name: 'uploadFile',
						            formData: {
						                'user': 'test'
						            },
						            success: (uploadFileRes) => {
						                console.log(uploadFileRes);
						            }
						        });
				    }
				});
			},
			query(){
				uni.request({
					url:"/api/cs23/query/14",
					success: (res) =>{
						this.form=res.data;
						console.log(this.form);
						if(res.data.code == 200){
							
							
						}
						// console.log(res.data.age)
						
					}
					
				})
			
			},
			
		}
	}
</script>


