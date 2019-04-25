package com.tony.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tony
 * 2019/4/24-15:24
 */
@SpringBootApplication
public class SentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication.class, args);
    }

    @RestController
    public static class TestController {

        @GetMapping("/hello")
        @SentinelResource("hello")
        public String sayHello() {
            return "hello";
        }
    }
}
