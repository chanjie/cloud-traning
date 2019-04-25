package com.tony.webflux.repository;

import com.tony.webflux.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * @author tony
 * 2019/2/14-14:24
 */
public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Mono<User> findByUsername(String username);

    Mono<Long> deleteByUsername(String username);
}
