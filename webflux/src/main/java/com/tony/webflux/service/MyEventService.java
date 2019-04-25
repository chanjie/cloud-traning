package com.tony.webflux.service;

import com.tony.webflux.MyEvent;
import com.tony.webflux.repository.MyEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author tony
 * 2019/2/14-16:34
 */
@Service
public class MyEventService {

    @Autowired
    private MyEventRepository eventRepository;

    public Mono<Void> loadEvents(Flux<MyEvent> events) {
        return eventRepository.insert(events).then();
    }

    public Flux<MyEvent> getEvents() {
        return eventRepository.findBy();
    }
}
