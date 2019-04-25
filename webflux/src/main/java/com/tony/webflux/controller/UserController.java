package com.tony.webflux.controller;

import com.tony.webflux.entity.User;
import com.tony.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author tony
 * 2019/2/14-14:31
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Mono<User> save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{username}")
    public Mono<Long> deleteByUsername(@PathVariable("username") String username) {
        return userService.deleteByUserName(username);
    }

    @GetMapping("/{username}")
    public Mono<User> findByUsername(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> findAll() {
        return userService.findAll();
    }
}
