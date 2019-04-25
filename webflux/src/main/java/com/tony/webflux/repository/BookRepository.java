package com.tony.webflux.repository;

import com.tony.webflux.entity.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

/**
 * @author tony
 * 2019/2/19-15:14
 */
public interface BookRepository extends ReactiveMongoRepository<Book, String> {

    @Tailable   //<1>
    Flux<Book> findBy();    //<2>
}
