package com.tony.webflux;

import com.tony.webflux.entity.Book;
import com.tony.webflux.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

/**
 * @author tony
 * 2019/2/14-15:36
 */
public class Test {

    private static final String BASE_URL = "http://127.0.0.1:9300";

    public static void main(String[] args) {
//        testUser();
//        testEvent();
        insertBooks();
    }

    private static void insertBooks() {
        Flux<Book> bookFlux = Flux.just(
                new Book(null, "java4", 50.00, "嘉为", "tonychen"),
                new Book(null, "java5", 45.00, "嘉为", "rich"),
                new Book(null, "java6", 40.00, "嘉为", "kelvin"),
                new Book(null, "vue js1", 35.00, "嘉为", "julie"),
                new Book(null, "测试攻略1", 30.00, "嘉为", "helenC")
        );

        WebClient.builder()
                .baseUrl(BASE_URL)
                .build()
                .post()
                .uri("/book")
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(bookFlux, Book.class)
                .retrieve()
                .bodyToFlux(Book.class)
                .doOnNext(System.out :: println)
                .blockLast();
    }

    private static void testEvent() {
        Flux<MyEvent> eventFlux = Flux.interval(Duration.ofSeconds(1))
                .map(l -> new MyEvent(System.currentTimeMillis(), "event - " + l)).take(5);
        WebClient webClient = WebClient.builder().baseUrl(BASE_URL).build();
        webClient
                .post()
                .uri("/events")
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(eventFlux, MyEvent.class)
                .retrieve()
                .bodyToMono(void.class)
                .block();
    }

    private static void testUser() {
        WebClient webClient = WebClient.builder().baseUrl(BASE_URL).build();
        webClient
                .get()
                .uri("/user")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .flatMapMany(resp -> resp.bodyToFlux(User.class))
                .doOnNext(System.err :: println)
                .blockLast();
    }

    private static Long sum1(List<Long> list) {
        Long result = 0L;
        for (int i = 0; i < list.size(); i++) {
            Long aLong = list.get(i);
            if (aLong > 3 && aLong < 10000 && aLong % 2 == 0) {
                result += aLong;
            }
        }
        return result;
    }

    private static Long sum2(List<Long> list) {
        return list.stream()
                .filter(l -> l > 3)
                .filter(l -> l < 10000)
                .limit(20)
                .mapToLong(l -> l)
                .sum();
    }
}
