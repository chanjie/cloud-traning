package com.tony.webflux;

import com.tony.webflux.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunctions;
import reactor.ipc.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author tony
 * 2019/2/14-10:24
 */
@SpringBootApplication
public class WebFluxApplication {

    public static void main(String[] args) throws IOException {
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebFluxApplication.class);
        HttpHandler httpHandler = WebHttpHandlerBuilder.applicationContext(context).build();
        ReactorHttpHandlerAdapter httpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer.create("127.0.0.1", 9300).newHandler(httpHandlerAdapter).block();
        System.in.read();*/

        /*HttpHandler httpHandler = RouterFunctions.toHttpHandler(
                route(POST("/selectStudent").and(accept(MediaType.APPLICATION_JSON_UTF8)), StudentHandler::selectStudent)
                        .and(route(GET("/saveStudent"), StudentHandler::insertStudent))
                        .and(route(GET("/timePerSec"), TimeHandler :: timePerSec))
        );

        ReactorHttpHandlerAdapter httpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer.create("127.0.0.1", 9300).newHandler(httpHandlerAdapter).block();
        System.in.read();*/

        SpringApplication.run(WebFluxApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(MongoOperations mongoOperations) {
        return (String ... args) -> {   //<1>
            mongoOperations.dropCollection(Book.class);     //<2>
            mongoOperations.createCollection(Book.class,
                    CollectionOptions.empty()
                            .maxDocuments(100000)      //<3>
                            .size(100000)      //<4>
                            .capped());
        };
    }
}
