package com.tony.webflux.controller;

import com.tony.webflux.MyEvent;
import com.tony.webflux.service.MyEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author tony
 * 2019/2/14-16:34
 */
@RestController
@RequestMapping("/events")
public class MyEventController {

    @Autowired
    private MyEventService eventService;

    @PostMapping
    public Mono<Void> loadEvents(@RequestBody Flux<MyEvent> events) {
        return eventService.loadEvents(events);
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<MyEvent> getEvents() {
        return eventService.getEvents();
    }
}
