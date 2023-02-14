package com.example.spc.util.proxy.dynamic;

import com.example.spc.util.proxy.BuyCar;
import com.example.spc.util.proxy.BuyCarImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Cglib {

    public static void main(String[] args) {

        //使用基于子类的动态代理
        //需要引入Jar包--cglib 本案例使用cglib3.3.0
        System.out.println("-+-+-+使用基于子类的代理-+-+-+");
        final BuyCarImpl car=new BuyCarImpl();
        BuyCar proxy=  (BuyCar) Enhancer.create(car.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("不贷款，全款！买车前的准备~~~");
                Object result = method.invoke(car, args);
                System.out.println("买完车了，出去浪~~~");
                return result;

            }
        });
        proxy.buyCar();
    }
}
