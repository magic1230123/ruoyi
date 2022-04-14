package com.magic.ruoyiapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// Spring Boot 应用的标识
@SpringBootApplication
@ServletComponentScan
@MapperScan({"com.magic.ruoyiapi.mapper"})
public class RuoyiApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuoyiApiApplication.class, args);
    }

}
