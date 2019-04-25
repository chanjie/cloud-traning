package com.tony.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tony
 * 2019/2/12-17:38
 */
@RestController
@RefreshScope
public class EchoController {
/*
    @Value("${user.name}")
    String username;

    @Value("${user.age}")
    int userage;

    @Value("${current.env}")
    String currentEnv;

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable("string") String string) {
        return "Hello Nacos Discovery " + string;
    }

    @GetMapping("/user")
    public String user() {
        return "Hello nacos! Hello " + username + ", " + userage + "\r\n" + "current environment: " + currentEnv;
    }*/
}
