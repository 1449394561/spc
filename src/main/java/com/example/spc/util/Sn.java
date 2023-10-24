package com.example.spc.util;

import org.apache.poi.ss.formula.functions.T;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * <p>
 * 返回经纬度
 * </p>
 *
 * @author
 * @since 2021/7/20
 */
public class Sn {

    public static void main(String[] args) throws IOException {

        Sn t = new Sn();
        Object[] objects = t.getCoordinate("广州市");
        System.out.println("经度："+objects[0]);
        System.out.println("纬度："+objects[1]);
    }
    public Object[] getCoordinate(String addr) throws IOException {
        String address = null;
        String lat = null; //经度
        String lng = null;//纬度
        try {
            address= URLEncoder.encode(addr,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String key = "b823ffcfdefb488***************";//百度地图申请ak
        String url = String .format("http://api.map.baidu.com/geocoder?address=%s&output=json&key=%s", address, key);
        URL myURL=null;
        URLConnection httpsConn=null;
        try {
            myURL=new URL(url);//创建URL对象
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStreamReader instr=null;
        BufferedReader br=null;
        try {
            httpsConn=(URLConnection) myURL.openConnection(); //URL调用openConnection（）方法从它创建一个URLConnection对象，会抛出IOException异常
            if (httpsConn !=null){
                instr=new InputStreamReader(httpsConn.getInputStream(),"UTF-8");//获取输入流
                br=new BufferedReader(instr);//从字符流中读取文本并缓冲字符
                String data=null;

                int count = 1;
                while((data= br.readLine())!=null){
                    if(count==5){
                        lng = (String)data.subSequence(data.indexOf(":")+1, data.indexOf(","));//经度
                        count++;
                    }else if(count==6){
                        lat = data.substring(data.indexOf(":")+1);//纬度
                        count++;
                    }else{
                        count++;
                    }
                }
                instr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(instr!=null){
                instr.close();
            }
            if(br!=null){
                br.close();
            }
        }
        return new Object[]{lng,lat};
    }
}


