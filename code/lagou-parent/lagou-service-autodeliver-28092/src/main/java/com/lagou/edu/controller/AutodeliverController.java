package com.lagou.edu.controller;

import com.lagou.edu.service.ResumeServiceFeignClient;
import com.netflix.appinfo.InstanceInfo;
//import com.netflix.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/autodeliver")
public class AutodeliverController {
    @Autowired
    private ResumeServiceFeignClient resumeServiceFeignClient;

    @GetMapping("/checkState/{userId}")
    public  Integer findResumeOpenState(@PathVariable Long userId){

        Integer forObject =resumeServiceFeignClient.findDefaultResumeState(userId);
//        String url="http://lagou-service-resume/resume/openstate/";
//        Integer forObject = restTemplate.getForObject(url + userId, Integer.class);
//        System.out.println("===>>>discovery from eureka .url : "+url + userId);
//        return forObject;
        return forObject;
    }



}
