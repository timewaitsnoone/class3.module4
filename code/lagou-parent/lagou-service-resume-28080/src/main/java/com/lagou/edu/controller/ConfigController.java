package com.lagou.edu.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${lagou.message}")
    private String lagouMessage;
    @Value("${mysql.url}")
    private String mysqlUrl;

    @RequestMapping("/viewconfig")
    public String viewconfig(){
        return "resume 28081 lagouMessage===>>> "+lagouMessage+ " mysqlUrl===>>> "+mysqlUrl;
    }
}
