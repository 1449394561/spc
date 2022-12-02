package com.example.spc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@MapperScan("com.example.spc.mapper")
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class SpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpcApplication.class, args);
    }

}
