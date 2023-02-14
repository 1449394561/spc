package com.example.spc.service;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.SM4;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@Service
public class ApiResult {
    private static final String BASIC = "123456789qwertyuiopasdfghjklzxcvbnm";


    public String result(String re){
        String secret = "4659b744001b7a6b";
        byte[] bytes = StrUtil.bytes(secret, CharsetUtil.CHARSET_UTF_8);
        SM4 sm4 = new SM4(Mode.CBC, Padding.PKCS5Padding, bytes, bytes);
        String data = sm4.decryptStr(re, CharsetUtil.CHARSET_UTF_8);
        System.out.println("解密结果=" + data);
        return data;
    }


    public String dat() {
        String secret = "4659b744001b7a6b";

        String content = "{\"orderId\" : \"111111\"}";

        byte[] bytes = StrUtil.bytes(secret, CharsetUtil.CHARSET_UTF_8);
        SM4 sm4 = new SM4(Mode.CBC, Padding.PKCS5Padding, bytes, bytes);
        String result = sm4.encryptBase64(content);
        System.out.println("加密结果=" + result);
        //加密结果=0MC7z7GSH1QeClRrzC0OFVg6Uui4da1LucyKSTYaZTBd4jDkqcpQ6FBWTsXOieXjEHOKe0ysp3FWbMAgMQ4u6eIaE/GiOd3QWfReMshgBeJOo/7QA96NA1P2bYwMfaWij4xmaWqfAh59Ak6Ax5dNEg==
        // 解密

        String data = sm4.decryptStr("XOnIScZN1d6dJqBCOeotQaepyLnM4sJN3KXVD1RhwHQw9OdbGcBzFIIbT3N+GeZSQclgqriBKrPiSw6Y47dryKEWuFh4Uqbhru1RitkwDCCM39QDsyglv3wSBEnN9sYMpykAJ+rtjZTd/5fivRryoqipzz+pt0l7/flSt5TBFSDzBUXe+R0UfDR/pBh7tVgR", CharsetUtil.CHARSET_UTF_8);
        System.out.println("解密结果=" + data);
        return result;
        //解密结果={"mobilePhone" : "13011112222","itemCode" : "BM1234567890","itemName" : "蜂羽物流有限公司一级项目"}
    }

    public String digest() throws UnsupportedEncodingException, NoSuchAlgorithmException {

        long time1=System.currentTimeMillis();
        System.out.println(time1);
        String secret = "4659b744001b7a6b";
//        Long timestamp = 1619171007322;
//        String timestamp1 = "1675324017955";
//        long timestamp=Long.parseLong(timestamp1);
        String encryptData =dat();
        StringBuilder sb = new StringBuilder();
        sb.append(encryptData);
        sb.append(time1);
        sb.append(secret);
        String encryptStr = URLEncoder.encode(sb.toString(), "UTF-8");
        System.out.println("encryptStr = " + encryptStr);
//encryptStr = 0MC7z7GSH1QeClRrzC0OFVg6Uui4da1LucyKSTYaZTBd4jDkqcpQ6FBWTsXOieXjEHOKe0ysp3FWbMAgMQ4u6eIaE%2FGiOd3QWfReMshgBeJOo%2F7QA96NA1P2bYwMfaWij4xmaWqfAh59Ak6Ax5dNEg%3D%3D16191710073221234567887654321
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(encryptStr.getBytes("utf8"));
        byte[] md5Arr = md5.digest();
        sun.misc.BASE64Encoder base64Encode = new BASE64Encoder();
        String str = base64Encode.encode(md5Arr);
        System.out.println("签名结果=" + str);//签名结果=8hI22rrN1hAoig65Lxs3Qw==
        return str;

    }

    public String getrom(){
        char[] basicArray = BASIC.toCharArray();
        Random random = new Random();
        char[] result = new char[10];
        for (int i = 0; i < result.length; i++) {
            int index = random.nextInt(100) % (basicArray.length);
            result[i] = basicArray[index];
        }
        String re=new String(result);
        System.out.println(re+"pppp");
        return re;
    }

    public static void main(String[] args) {
        String co="Y12344123123";
        String ss = "{\"orderId\"" + " : " + "\"" + co +"\"}";
        String content = "{\"orderId\" : \"Y12344123123\"}";
        System.out.println(ss);
        System.out.println(content);
    }

}
