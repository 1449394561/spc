package com.example.spc.util.proxy;

/**
 * @Author: Promsing
 * @Date: 2021/4/3 - 8:26
 * @Description: 代理类
 * @version： 1.0
 */
public class BuyCarProxy implements BuyCar{
    private BuyCar buyCar;
    //注意事final修饰的关键字 不可修改
    //构造函数注入，需要被代理的对象
    public  BuyCarProxy(final BuyCar buyCar) {
        this.buyCar = buyCar;
    }
    //静态代理- 的实现方式
    @Override
    public void buyCar() {
        System.out.println("不贷款，全款！买车前的准备~~~");
        buyCar.buyCar();
        System.out.println("买完车了，出去浪~~~");
    }
}
