//package com.example.spc.util;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebMvcConfigration implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(new AuthenticationInterceptor())
//                .addPathPatterns("/cs/**")
//                .excludePathPatterns("/cs23/video")
//                .excludePathPatterns("/cs/login");
//    }
//
//}
