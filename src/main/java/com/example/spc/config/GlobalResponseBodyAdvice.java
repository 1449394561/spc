//package com.example.spc.config;
//
//import com.example.spc.util.R;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
//
////控制层响应消息返回统一控制
//@Slf4j
//@RestControllerAdvice
//public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    // 此处可以通过判断决定哪些响应需要包装
//    @Override
//    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
//        return true;
//    }
//
////    @Override
////    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
////        return null;
////    }
//
//    @SneakyThrows
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        if(body instanceof String){
//            // 当响应体是String类型时，使用ObjectMapper转换，因为Spring默认使用StringHttpMessageConverter处理字符串，不会将字符串识别为JSON
//            return objectMapper.writeValueAsString(R.ok());
//        }
//        if(body instanceof R){
//            // 已经包装过的结果无需再次包装
//            return body;
//        }
//        // 对响应体进行包装
//        return R.ok();
//    }
//}
