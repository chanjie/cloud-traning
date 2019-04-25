package com.tony.webflux;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

/**
 * @author tony
 * 2019/2/14-13:52
 */
public class TimeHandler {

    public static Mono<ServerResponse> timePerSec(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(
                Flux.interval(Duration.ofSeconds(1))
                        .map(time -> new SimpleDateFormat("HH:mm:ss").format(new Date())),
                String.class
        );
    }
}
