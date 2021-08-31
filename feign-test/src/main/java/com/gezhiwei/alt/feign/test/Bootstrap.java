package com.gezhiwei.alt.feign.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Bootstrap {


    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutdown...");
        }));
    }
}
