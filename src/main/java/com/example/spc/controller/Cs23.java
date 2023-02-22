package com.example.spc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.spc.cs.aop.ConferenceServiceImpl;

import com.example.spc.entity.Wcha;
import com.example.spc.mapper.WchaMapper;
import com.example.spc.util.NonStaticResourceHttpRequestHandler;
import com.example.spc.util.mq.RabbitMQServiceImpl;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cs23")
public class Cs23 {

    @Autowired
    private NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;

    @Autowired
    private WchaMapper wchaMapper;


    @Autowired
    private ConferenceServiceImpl conferenceService;


    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");


    @GetMapping("/query/{id}")
    public String query(@PathVariable Integer id){
        Wcha qu=wchaMapper.selectById(id);
        if (qu != null){
            String zp_string = "";
            //存放字节流的byte数组
            byte[] zpBlob = qu.getPicture();
            if (Optional.ofNullable(zpBlob).isPresent()){
                //转Base64
                byte[] encodeBase64 = Base64.encodeBase64(zpBlob);
                //转字符串Base64
                zp_string = new String((encodeBase64));
            }
            //查询出教师信息数据 将教师图片设置到教师信息实体类的tx里面
            return zp_string;
        }else{
            return "error";
        }
    }

    //文件传输
    @PostMapping("/uploadImg")
    public String uploadImg(MultipartFile uploadFile, HttpServletRequest req){

        InputStream ins = null;
        byte[] data=new byte[1024];
        try {
            ins = uploadFile.getInputStream();
            byte[] buffer=new byte[1024];
            int len=0;
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            while((len=ins.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
            bos.flush();
            data = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String name="pic";

        Wcha user = new Wcha();
        user.setName(name);
        user.setPicture(data);
        wchaMapper.insert(user);




        //获取文件名
        String fileName = uploadFile.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;
        //添加日期目录
        String format = sd.format(new Date());
        //指定本地文件夹存储图片
        String filePath = "E:/Data/uploadFile/"+format+"/";
        File file = new File(filePath,fileName);
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            //将图片保存到static文件夹里
            file.createNewFile();
            uploadFile.transferTo(new File(filePath+fileName));
            return  "http://"+req.getRemoteHost()+":"+req.getServerPort()+"/"+format+"/"+fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }




    //视频传输
    @GetMapping("/video")
    public void videoPreview(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //sourcePath 是获取编译后 resources 文件夹的绝对地址，获得的原始 sourcePath 以/开头，所以要用 substring(1) 去掉第一个字符/
        //realPath 即视频所在的完整地址
        String sourcePath = this.getClass().getClassLoader().getResource("").getPath().substring(1);
        String realPath = sourcePath + "static/66810.mp4";
        Path filePath = Paths.get(realPath);
        if (Files.exists(filePath)) {
            // 利用 Files.probeContentType 获取文件类型
            String mimeType = Files.probeContentType(filePath);
            if (!StringUtils.isEmpty(mimeType)) {
                // 设置 response
                response.setContentType(mimeType);
            }
            request.setAttribute(nonStaticResourceHttpRequestHandler.filepath, filePath);
            // 利用 ResourceHttpRequestHandler.handlerRequest() 实现返回视频流
            nonStaticResourceHttpRequestHandler.handleRequest(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }

    //调用springaop
    @GetMapping("/aop")
    public void aop(){
        conferenceService.conference();
    }


    @GetMapping("/war")
    public Wcha warpper(){
        QueryWrapper<Wcha> wrapper = new QueryWrapper();
        wrapper.eq("name",666);
        Wcha wcha = wchaMapper.selectOne(wrapper);
        return wcha;
    }

    @GetMapping("/update")
    public void update(){
        Wcha wcha=new Wcha();
        wcha.setId(11);
        wcha.setName("666");
        wcha.setAge(6);
        wcha.setPassword("666");
        wchaMapper.wupdate(wcha);
    }


    @GetMapping("/cc")
    public String cc(){
        String cc = wchaMapper.cc("888");
        return cc;
    }

    //rabbitMQ
        @Resource
        private RabbitMQServiceImpl rabbitMQService;
        /**
         * 发送消息
         * @author java技术爱好者
         */
        @PostMapping("/sendMsg")
        public String sendMsg(@RequestParam(name = "msg") String msg) throws Exception {
            return rabbitMQService.sendMsg(msg);
        }

}
