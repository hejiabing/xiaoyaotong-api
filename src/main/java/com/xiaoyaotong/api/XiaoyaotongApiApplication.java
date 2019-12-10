package com.xiaoyaotong.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xiaoyaotong.api.*.mapper")
@SpringBootApplication
public class XiaoyaotongApiApplication {
    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(XiaoyaotongApiApplication.class, args);
    }
}


