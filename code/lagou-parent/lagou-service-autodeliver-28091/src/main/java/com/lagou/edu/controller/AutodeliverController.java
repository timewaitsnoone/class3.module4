package com.lagou.edu.controller;

import com.netflix.appinfo.InstanceInfo;
//import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/checkState/{userId}")
    public  Integer findResumeOpenState(@PathVariable Long userId){

        String url="http://lagou-service-resume/resume/openstate/";
        Integer forObject = restTemplate.getForObject(url + userId, Integer.class);
        System.out.println("===>>>discovery from eureka .url : "+url + userId);
        return forObject;
    }

    @HystrixCommand(
            threadPoolKey = "findResumeOpenStateTimeOut",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize",value="1"),
                    @HystrixProperty(name="maxQueueSize",value="20")
            },
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")
            }
    )
    @GetMapping("/checkStateTimeOut/{userId}")
    public  Integer findResumeOpenStateTimeOut(@PathVariable Long userId){

        String url="http://lagou-service-resume/resume/openstate/";
        Integer forObject = restTemplate.getForObject(url + userId, Integer.class);
        System.out.println("===>>>discovery from eureka .url : "+url + userId);
        return forObject;
    }

    @HystrixCommand(
            threadPoolKey = "findResumeOpenStateFallBack",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize",value="2"),
                    @HystrixProperty(name="maxQueueSize",value="20")
            },
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000"),
                    // 统计时间窗口定义
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "8000"),
                    // 统计时间窗口内的最小请求数
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "2"),
                    // 统计时间窗口内的错误数量百分比阈值
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
                    // 自我修复时的活动窗口长度
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")

            },
            fallbackMethod = "myFallBack"
    )
    @GetMapping("/checkStateFallBack/{userId}")
    public  Integer findResumeOpenStateFallBack(@PathVariable Long userId){

        String url="http://lagou-service-resume/resume/openstate/";
        Integer forObject = restTemplate.getForObject(url + userId, Integer.class);
        System.out.println("===>>>discovery from eureka .url : "+url + userId);
        return forObject;
    }

    public Integer myFallBack(Long userId){
        return -1;
    }

//    @GetMapping("/checkState/{userId}")
//    public  Integer findResumeOpenState(@PathVariable Long userId){
//
//        List<ServiceInstance> instances = discoveryClient.getInstances("lagou-service-resume");
//        ServiceInstance serviceInstance = instances.get(0);
//        String ipAddr = serviceInstance.getHost();
//        int port =serviceInstance.getPort();
//
//        Integer forObject = restTemplate.getForObject("http://"+ipAddr+":"+port+"/resume/openstate/" + userId, Integer.class);
//        System.out.println("===>>>discovery from eureka .url : "+"http://"+ipAddr+":"+port+"/resume/openstate/" + userId);
//        return forObject;
//    }

//    @GetMapping("/checkState/{userId}")
//    public  Integer findResumeOpenState(@PathVariable Long userId){
//        Integer forObject = restTemplate.getForObject("http://localhost:28091/resume/openstate/" + userId, Integer.class);
//        return forObject;
//    }


}
