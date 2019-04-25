package com.tony.webflux.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author tony
 * 2019/2/19-15:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Book {

    @Id
    private String id;

    @Indexed(unique = true)
    private String bookName;

    private Double price;

    private String publisher;

    private String author;

}
