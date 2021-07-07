package com.lagou.edu.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class ResumeFallback implements ResumeServiceFeignClient{
    @Override
    public Integer findDefaultResumeState(Long userId) {
        return -1;
    }
}
