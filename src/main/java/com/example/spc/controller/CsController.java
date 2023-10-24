package com.example.spc.controller;

import com.example.spc.entity.ApiDto;
import com.example.spc.entity.Cc;
import com.example.spc.entity.Wcha;
import com.example.spc.mapper.WchaMapper;
import com.example.spc.service.CsServer;
import com.example.spc.service.WchaService;
import com.example.spc.util.exception.MyException;
import com.example.spc.util.loginfliter.TokenUtil;
import com.example.spc.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cs")
public class CsController {

    @Autowired
    private WchaService wchaServicec;

    @Autowired
    private WchaMapper wchaMapper;

    @Autowired
    private CsServer csServer;


    @GetMapping("/cc")
    public String cc(){
        System.out.println(wchaMapper.cc("888"));
        return "200";
    }

    //统一异常处理
    @RequestMapping(value = "/exception")
    public R list(Integer id) {
        Integer er=444;
        id.equals(er);
        Wcha list = wchaMapper.selectById(id);
        return R.ok().data("itms", list).message("用户列表");
    }



    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Wcha sysUser) throws MyException {
        Map<String, Object> map = new HashMap<>();
        String name = sysUser.getName();
        String password = sysUser.getPassword();
        // 省略 账号密码验证
        if (name!=null&& password!=null){
            String bpassword=wchaMapper.getpassword(name);
            if (bpassword.equals(password)== false){
                throw new MyException("密码不正确!");
            }
        }
        // 验证成功后发送token
        String token = TokenUtil.sign(name,password);
        if (token != null){
            map.put("code", "200");
            map.put("message","认证成功");
            map.put("token", token);
            return map;
        }
        map.put("code", "403");
        map.put("message","认证失败");
        return map;
    }


    @GetMapping("/getp/{name}")
    public String getP(@PathVariable String name) {
        String pa = wchaMapper.getpassword(name);
        return pa;
    }

    @GetMapping("/query")
     public List queryall(){
        List qu=wchaMapper.selectList(null);
        return qu;
    }

    @GetMapping("/query/{id}")
    public Wcha query(@PathVariable Integer id){
        Wcha qu=wchaMapper.selectById(id);
        return qu;
    }

    @GetMapping("/add")
    public String add(@RequestParam String name){
        Wcha wcha1=new Wcha();
        wcha1.setName(name);
        wchaMapper.insert(wcha1);
        return "200";
    }

    @PostMapping("/update")
    public String update(@RequestBody Wcha wcha){
        wchaMapper.updateById(wcha);
        return "200";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        wchaMapper.deleteById(id);
        return "200";
    }

    @PostMapping("/api")
    public String api(@RequestBody ApiDto type){
        System.out.println(type.getType());
        return "2000";
    }

//    @PostMapping("/dy")
//    public void dy(){
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:9090/cs/api";
//
//        //LinkedMultiValueMap一个键对应多个值，对应format-data的传入类型
//        LinkedMultiValueMap<String, String> request = new LinkedMultiValueMap<>();
//        //入参
//        request.set("username","baihui");
//        request.set("password", "123456");
//        request.set("sex", "0");
//        request.set("telephone", "13172724946");
//        //请求
//        String result = restTemplate.postForObject(url,request,String.class);
//        System.out.println(result);
//
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, request, String.class);
//        System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
//    }

}
