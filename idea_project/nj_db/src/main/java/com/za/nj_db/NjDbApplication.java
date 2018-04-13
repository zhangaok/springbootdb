package com.za.nj_db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.za.nj_db.mapper")
@EnableScheduling
public class NjDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(NjDbApplication.class, args);
    }
}
