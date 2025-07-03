package com.danilo.volles.documents.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class DocumentsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocumentsApiApplication.class, args);
    }

}
