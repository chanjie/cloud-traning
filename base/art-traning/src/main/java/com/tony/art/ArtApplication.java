package com.tony.art;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author tony
 * 2019/4/26-14:48
 */
@SpringBootApplication
public class ArtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
