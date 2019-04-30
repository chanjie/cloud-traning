package com.tonychen.webhook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author tony
 * 2019/4/30-11:49
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    @RequestMapping("/gitlab")
    public static class GitlabController {

        @RequestMapping("/push")
        public String pushEvent(@RequestBody String body, HttpServletRequest request) {
            System.out.println(String.format("request method is: %s", request.getMethod()));
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                System.out.println(String.format("%s : %s", headerName, headerValue));
            }
            System.out.println(body);
            return body;
        }

    }
}
