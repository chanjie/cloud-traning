package com.tony.webflux.service;

import com.tony.webflux.entity.User;
import com.tony.webflux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author tony
 * 2019/2/14-14:26
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Mono<User> save(User user) {
        return userRepository.save(user)
                .onErrorResume(e ->
                        userRepository.findByUsername(user.getUsername())
                            .flatMap(originalUser -> {
                                user.setId(originalUser.getId());
                                return userRepository.save(user);
                            }));
    }

    public Mono<Long> deleteByUserName(String username) {
        return userRepository.deleteByUsername(username);
    }

    public Mono<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Flux<User> findAll() {
        return userRepository.findAll().delayElements(Duration.ofSeconds(2));
    }
}
