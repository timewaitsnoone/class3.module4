package com.lagou.edu.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "lagou-service-resume",fallback = ResumeFallback.class,path = "/resume")
//@RequestMapping("/resume")
public interface ResumeServiceFeignClient {

    @RequestMapping("/openstate/{userId}")
    public Integer findDefaultResumeState(@PathVariable("userId") Long userId);

}
