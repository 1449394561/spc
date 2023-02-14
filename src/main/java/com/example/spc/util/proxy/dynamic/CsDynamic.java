package com.example.spc.util.proxy.dynamic;

import com.example.spc.util.proxy.BuyCar;
import com.example.spc.util.proxy.BuyCarImpl;

import java.lang.reflect.Proxy;

public class CsDynamic {
    public static void main(String[] args) {

        System.out.println("-+-+-+使用基于接口的代理-+-+-+");
        //方式一、如不写动态代理类DynamicProxy，可以在这里使用内部类
        //声明一个final修饰的对象
       /*
        final BuyCarImpl car=new BuyCarImpl();
        BuyCar proxy=(BuyCar)Proxy.newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("不贷款，全款！买车前的准备~~~");
                Object result = method.invoke(car, args);
                System.out.println("买完车了，出去浪~~~");
                return result;
            }
        });
        proxy.buyCar();
        */

        //方式二、使用DynamicProxy类
        //声明一个final修饰的对象
        final BuyCarImpl car=new BuyCarImpl();
        BuyCar proxy=(BuyCar) Proxy.newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(),new DynamicProxy(car));
        proxy.buyCar();
    }
}
