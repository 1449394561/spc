package com.example.spc;



import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.spc.entity.Api;
import com.example.spc.service.ApiResult;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class resttemplate {

    @Test
    public void RestTemplateTestPost() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        RestTemplate restTemplate = new RestTemplate();
        //String url = "http://127.0.0.1:5000/register";
        String url = "http://ta.jumstc.com:11000/foa/std/v1/order/query";
//        String url = "http://localhost:9090/cs/api";
        //LinkedMultiValueMap一个键对应多个值，对应format-data的传入类型
//        LinkedMultiValueMap<String, String> request = new LinkedMultiValueMap<>();
//        //入参
//        request.set("username","baihui");

        HttpHeaders httpHeaders = new HttpHeaders();
        //传递请求体时必须设置传递参数的格式，为Content-Type ： application/json
        httpHeaders.add("Content-Type", "application/json;charset=UTF-8");
        // TODO 其他需要设置的请求头
        // 2.请求头 & 请求体

        ApiResult apiResult =new ApiResult();
        Map<String, String> params = new HashMap<>();
        long time1=System.currentTimeMillis();
        String timestamp=String.valueOf(time1);

        String digest= apiResult.digest();

        String encryptData= apiResult.dat();

        String requestID= apiResult.getrom();

        params.put("partnerID", "T1C2L7");
        params.put("orgID", "U3L2X5P2");
        params.put("requestID", requestID);
        params.put("timestamp", timestamp);
        params.put("digest", digest);
        params.put("encryptData", encryptData);
        String jsonData = JSON.toJSONString(params);



        HttpEntity<JSON> fromEntity = new HttpEntity(jsonData, httpHeaders);


        //请求
        String result = restTemplate.postForObject(url,fromEntity,String.class);

        // userJson---json类型字符串
        Api wxchatUser = JSONObject.parseObject(result, Api.class);
        String resu=wxchatUser.getApiResultData();
        System.out.println(result);
        System.out.println(resu);

        String re=apiResult.result(resu);
        System.out.println(re);
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, request, String.class);
//        System.out.println("responseEntity.getBody() = " + responseEntity.getBody());
    }

}
