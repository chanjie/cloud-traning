package com.tony.webflux.service;

import com.tony.webflux.entity.Book;
import com.tony.webflux.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author tony
 * 2019/2/19-15:17
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Flux<Book> save(Flux<Book> books) {
        return bookRepository.saveAll(books);
    }

    public Flux<Book> findAll() {
        return bookRepository.findBy();
    }
}
