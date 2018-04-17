package com.za.wh_db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.za.wh_db.mapper")
@EnableScheduling
public class WhDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhDbApplication.class, args);
    }

}
