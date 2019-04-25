package com.tony.nacosconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

/**
 * @author tony
 * 2019/2/13-13:52
 */
@RestController
public class EchoController {

    @Autowired
    private LoadBalancerClient client;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/echo/app-name")
    public String echoAppName() {
        ServiceInstance instance = client.choose("nacos-producer");
        String url = String.format("http://%s:%s/echo/%s", instance.getHost(), instance.getPort(), appName);
        System.out.println("request url: " + url);
        return restTemplate.getForObject(url, String.class);
//        return restTemplate.getForObject(String.format("http://nacos-producer/echo/%s", appName), String.class);
    }

/*    @GetMapping("/echo/user")
    public String echoUser() {
        ServiceInstance instance = client.choose("nacos-producer");
        String url = String.format("http://%s:%s/user", instance.getHost(), instance.getPort());
        System.out.println("request url: " + url);
        return restTemplate.getForObject(url, String.class);
    }*/

    @GetMapping("/echo/mono")
    public Mono<String> echoReactor() {
        return Mono.just("hello spring webflux");
    }
}
