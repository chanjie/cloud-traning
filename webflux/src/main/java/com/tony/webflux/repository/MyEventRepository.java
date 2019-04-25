package com.tony.webflux.repository;

import com.tony.webflux.MyEvent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @author tony
 * 2019/2/14-16:38
 */
public interface MyEventRepository extends ReactiveMongoRepository<MyEvent, Long> {

    @Tailable
    public Flux<MyEvent> findBy();
}
