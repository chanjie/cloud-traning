package com.tony.nacosdiscovery.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tony
 * 2019/2/13-13:48
 */
@RestController
@RefreshScope
public class EchoController {

    @Value("${user.name}")
    private String username;

    @Value("${user.age}")
    private int userage;

    @GetMapping("/echo/{string}")
//    @SentinelResource("echo")
    public String echo(@PathVariable("string") String string) {
        return "Hello Nacos discovery " + string;
    }

    @GetMapping("/hello")
//    @SentinelResource("hello")
    public String hello() {
        return "Hello Sentinel";
    }

    @GetMapping("/user")
    public String user() {
        return String.format("Hello %s! %s", username, userage);
    }
}
