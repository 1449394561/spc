package com.example.spc.controller;

import com.example.spc.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cs239")
@RestController
public class Cs239 {

    @Autowired
    private MyService myService;

    @GetMapping("/sync")
    public String someMethod() {
        // 调用异步方法
        String s = myService.performAsyncTask();
        System.out.println(s);
        String ss = "dshjhsd";
        return ss;
    }
}
