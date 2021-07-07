package com.lagou.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EntityScan("com.lagou.edu.pojo")
//@EnableEurekaClient//Eureka独用
@EnableDiscoveryClient//通用型 Eureka Nacos
public class LagouResumeApplication28080 {
    public static void main(String[] args) {
        SpringApplication.run(LagouResumeApplication28080.class,args);
    }

}
