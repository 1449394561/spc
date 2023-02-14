package com.example.spc.util.proxy;

/**
 * @Author: Promsing
 * @Date: 2021/4/3 - 8:36
 * @Description: 客户端调用
 * @version： 1.0
 */
public abstract class ProxyTest implements BuyCar {
    public static void main(String[] args) {
        System.out.println("-+-+-+正常调用-+-+-+");
        BuyCar car=new BuyCarImpl();
        car.buyCar();

        System.out.println("-+-+-+使用静态代理-+-+-+");
        BuyCar proxy=new BuyCarProxy(car);
        proxy.buyCar();

        String lines = "[{\"addressType\":1,\"addressAttribute\":1,\"province\":\"上海市\",\"city\":\"上海市\",\"area\":\"静安区\",\"address\":null,\"concatName\":null,\"concatPhone\":null,\"sortNo\":1},{\"addressType\":2,\"addressAttribute\":1,\"province\":\"广东省\",\"city\":\"广州市\",\"area\":\"天河区\",\"address\":null,\"concatName\":null,\"concatPhone\":null,\"sortNo\":2}]";
        int index = lines.indexOf("},");
        String firstSubstring = lines.substring(0, index + 1);
        String secondSubstring = lines.substring(index + 2);
        System.out.println(firstSubstring);
        System.out.println(secondSubstring);
    }
}

