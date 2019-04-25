package com.tony.webflux;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author tony
 * 2019/2/14-16:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "event")
public class MyEvent {

    @Id
    private Long id;

    private String message;
}
