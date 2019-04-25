package com.tony.nacos.controller;

import com.tony.nacos.configuration.BookProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tony
 * 2019/2/20-17:00
 */
@RestController
@RefreshScope
@RequestMapping("/index")
public class IndexController {

    @Value("${ext.contry}")
    String contry;

    @Value("${ext.city}")
    String city;

    @Value("${ext.user.name}")
    String username;

    @Value("${ext.user.age}")
    String userage;

    @Value("${ext.data.name}")
    String dataName;

    @Value("${ext.data.group}")
    String dataGroup;

    @Value("${ext.data.manager}")
    String dataManager;

    @Autowired
    private BookProperties book;

    @GetMapping("/ext1")
    public String ext1() {
        return String.format("contry: %s and city: %s", contry, city);
    }

    @GetMapping("/ext2")
    public String ext2() {
        return String.format("username: %s, userage: %s", username, userage);
    }

    @GetMapping("/ext3")
    public String ext3() {
        return String.format("dataName: %s, dataGroup: %s, dataManager: %s", dataName, dataGroup, dataManager);
    }

    @GetMapping("/book")
    public BookProperties book() {
        return book;
    }
}
