package com.tony.webflux.controller;

import com.tony.webflux.entity.Book;
import com.tony.webflux.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author tony
 * 2019/2/19-15:20
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Book> findAll() {
        return bookService.findAll().delayElements(Duration.ofSeconds(1));
    }

    @PostMapping(consumes = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Book> save(@RequestBody Flux<Book> books) {
        return bookService.save(books);
    }
}
