package com.example.spc.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

public class cscs {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("com.example.spc.controller.Cs23");
        //获取 Person 类的所有方法信息
        Method[] method = clazz.getDeclaredMethods();
        for (Method m : method) {
            System.out.println(m.toString());
        }
        //获取 Person 类的所有成员属性信息
        Field[] field = clazz.getDeclaredFields();
        for (Field f : field) {
            System.out.println(f.toString());
        }
        //获取 Person 类的所有构造方法信息
        Constructor[] constructor = clazz.getDeclaredConstructors();
        for (Constructor c : constructor) {
            System.out.println(c.toString());
        }
    }
}
