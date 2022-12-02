package com.example.spc.controller;

import com.example.spc.entity.Wcha;
import com.example.spc.mapper.WchaMapper;
import com.example.spc.service.WchaService;
import com.example.spc.util.MyException;
import com.example.spc.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cs")
public class Cs {

    @Autowired
    private WchaService wchaServicec;

    @Autowired
    private WchaMapper wchaMapper;


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
//        Wcha wcha1=new Wcha();
//        wcha1.setId(id);
//        wcha1.setName(wcha);
        wchaMapper.updateById(wcha);
        return "200";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        wchaMapper.deleteById(id);
        return "200";
    }

    @GetMapping("/ho")
    public int ho(){
         int f=1;
        return f;
    }
}
