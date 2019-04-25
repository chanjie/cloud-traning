package com.tony.nacos;

import com.tony.nacos.configuration.BookProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author tony
 * 2019/2/12-15:52
 */
@SpringBootApplication
@EnableConfigurationProperties(value = BookProperties.class)
public class NacosApplication {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(NacosApplication.class, args);
    }

}
