package com.example.spc.cs.aop;



import org.springframework.stereotype.Component;

@Component
public class ConferenceServiceImpl implements ConferenceService {

    @Override
    public void conference() {
        System.out.println("开会......");
    }

}

