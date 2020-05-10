package com.example.templateengine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.example.templateengine.mapper")
public class TemplateengineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateengineApplication.class, args);
    }

}
