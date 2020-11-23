package com.wocnz.stusys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动类
 */

@SpringBootApplication
public class StusysApplication {

    public static void main(String[] args) {
        SpringApplication.run(StusysApplication.class, args);
    }

}
