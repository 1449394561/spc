package com.example.spc.controller;

import java.util.concurrent.Callable;

public class MyThread implements Callable {
    public MyThread(String s) {
        System.out.println(s+"ppppp");
    }

    public void run() {
        System.out.println("MyThread.run()");
    }

    @Override
    public Object call() throws Exception {
        return null;
    }


}
