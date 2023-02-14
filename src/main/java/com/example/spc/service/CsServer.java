package com.example.spc.service;

import com.example.spc.entity.Wcha;
import com.example.spc.mapper.WchaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CsServer {
    @Autowired
    WchaMapper wchaMapper;

    public List<Wcha> se(){
        List<Wcha> ss=wchaMapper.selectList(null);
        return ss;
    }
}
