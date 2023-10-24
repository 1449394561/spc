package com.example.spc.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Async // 标记为异步方法
    public String performAsyncTask() {
        // 执行异步任务的代码
        System.out.println("qqqqqqqqqq");
        return "popoppp";
    }
}

