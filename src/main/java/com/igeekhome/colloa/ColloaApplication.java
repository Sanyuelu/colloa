package com.igeekhome.colloa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.igeekhome.colloa.mapper")
public class ColloaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ColloaApplication.class, args);
    }

}
