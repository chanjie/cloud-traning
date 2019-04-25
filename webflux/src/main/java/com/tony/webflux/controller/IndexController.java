package com.tony.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tony
 * 2019/2/14-10:30
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
