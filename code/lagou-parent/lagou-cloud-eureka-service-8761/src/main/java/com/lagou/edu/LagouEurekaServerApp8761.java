package com.lagou.edu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// 申明当前项目为Eureka服务
@EnableEurekaServer
public class LagouEurekaServerApp8761 {
    public static void main(String[] args) {
        SpringApplication.run(LagouEurekaServerApp8761.class,args);
    }
}
