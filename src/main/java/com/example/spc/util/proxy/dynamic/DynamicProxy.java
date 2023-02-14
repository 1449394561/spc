package com.example.spc.util.proxy.dynamic;

import com.example.spc.util.proxy.BuyCar;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: Promsing
 * @Date: 2021/4/3 - 9:09
 * @Description: 描述 形容
 * @version： 1.0
 */
public class DynamicProxy implements InvocationHandler {
    private BuyCar object;

    public DynamicProxy( BuyCar object) {
        this.object = object;
    }

    /**
     *
     * @param proxy  代理对象的引用
     * @param method 当前执行的方法
     * @param args 当前执行方法所需的参数
     * @return 和被代理对象方法有相同的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("不贷款，全款！买车前的准备~~~");
        Object result = method.invoke(object, args);
        System.out.println("买完车了，出去浪~~~");
        return result;
    }


}
