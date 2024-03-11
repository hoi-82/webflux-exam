package com.example.flux.domain.document;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "shops")
@Getter
public class Shop {
    @Id
    private final String id;
    private final String name;
    private final String introduce;

    @Builder
    public Shop(String id, String name, String introduce) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
    }
}
