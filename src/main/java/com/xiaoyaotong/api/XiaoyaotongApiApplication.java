package com.xiaoyaotong.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.xiaoyaotong.api.*.mapper")//扫描mapper
@SpringBootApplication
public class XiaoyaotongApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        return application.sources(XiaoyaotongApiApplication.class);
    }

    public static void main(String[] args) {
        //由于es和redis产生冲突，加一个属性设置
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(XiaoyaotongApiApplication.class, args);
    }
}


