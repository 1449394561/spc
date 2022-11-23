package com.example.spc.service;

import com.example.spc.mapper.WchaMapper;
import com.example.spc.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WchaService {

//    @Autowired
//    private WchaMapper wchaMapper;


    public String getpassword(String name){
        WchaMapper wchaMapper = ContextUtil.getBean("wchaMapper", WchaMapper.class);
        String password=wchaMapper.getpassword(name);
        return password;
    }
}
