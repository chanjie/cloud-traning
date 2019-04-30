package com.tony.webflux.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tony
 * 2019/4/30-11:41
 */
@RestController
@RequestMapping("/gitlab")
public class GitLabController {

    @RequestMapping("/push")
    public String pushEvent(@RequestBody String body) {
        System.out.println(body);
        return body;
    }
}
