package com.lagou.edu.controller;


import com.lagou.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    ResumeService resumeService;

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/openstate/{userId}")
    public Integer findDefaultResumeState(@PathVariable Long userId) {
//        return resumeService.findDefaultResumeByUserId(userId).getIsOpenResume();
        System.out.println("============>>>>>>>28081 get a request");
        return port;
    }

}
