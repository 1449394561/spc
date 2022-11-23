package com.example.spc.util;

/**
 * 自定义异常类
 */
public class MyException extends Exception {
    //异常信息
    private String message;

    //构造函数
    public MyException(String message){
        super(message);
        this.message = message;
    }

}

