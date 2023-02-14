<template>
	<div>
		<uni-section title="表单校验" type="line">
					<view class="example">
						<!-- 基础表单校验 -->
						<uni-forms ref="valiForm" :modelValue="valiFormData">
							<uni-forms-item label="姓名" required name="name">
								<uni-easyinput v-model="valiFormData.name" placeholder="请输入姓名" />
							</uni-forms-item>
							<uni-forms-item label="年龄" required name="age">
								<uni-easyinput v-model="valiFormData.age" placeholder="请输入年龄" />
							</uni-forms-item>
							<uni-forms-item label="自我介绍" name="introduction">
								<uni-easyinput type="textarea" v-model="valiFormData.introduction" placeholder="请输入自我介绍" />
							</uni-forms-item>
						</uni-forms>
						<button type="primary" @click="addw()">提交</button>
						<uni-forms-item label="年龄" required>
							<uni-data-checkbox v-model="valiFormData.id" :localdata="sexs" />
						</uni-forms-item>
						<button type="primary" @click="query()">查询</button>
					</view>
				</uni-section>
				<video controls autoplay src="http://localhost:9091/cs23/video"/>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				age1:null,
				valiFormData: {
					wcha: '',


					introduction: '',
					
								},
				title: 'Hello',
				sexs: [{
									text: '男',
									value: 0
								}, {
									text: '女',
									value: 1
								}, {
									text: '保密',
									value: 2
								}],

			}
		},
		onLoad() {

		},
		methods: {
			addw(){
				uni.request({
					url:"/apiResult/cs/add" + "?name=" + this.valiFormData.name,
					success(res) {
						console.log(res)
					}
				})
			},
			delete(){
				uni.request({
					url:"/apiResult/cs/delete" + "/" + this.valiFormData.id,
					success: (res) =>{
						console.log(res.data);
						this.valiFormData.age=res.data.age
						console.log(this.valiFormData.age)
						if(res.data.code == 200){
							
							
						}
						// console.log(res.data.age)
						
					}
					
				})
			
			},
			
			query(){
				uni.request({
					url:"/apiResult/cs/query",
					success: (res) =>{
						console.log(res.data);
						this.valiFormData.age=res.data.age
						console.log(this.valiFormData.age)
						if(res.data.code == 200){
							
							
						}
						// console.log(res.data.age)
						
					}
					
				})
			
			},
			
			update(){
				uni.request({
					url:"/apiResult/cs/update",
					method:"POST",
					data:JSON.stringify(this.valiFormData),
					success: (res) =>{
						console.log(res.data);
						this.valiFormData.age=res.data.age
						console.log(this.valiFormData.age)
						if(res.data.code == 200){
							
							
						}
						// console.log(res.data.age)
						
					}
					
				})
			
			},
			
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
