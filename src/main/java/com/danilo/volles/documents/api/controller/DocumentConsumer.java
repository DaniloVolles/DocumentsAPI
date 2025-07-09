package com.danilo.volles.documents.api.controller;

import com.danilo.volles.documents.api.entity.Document;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DocumentConsumer {

    private static final String TOPIC = "documents";

    @KafkaListener(
            topics = TOPIC,
            groupId = "documents-group",
            containerFactory = "documentKafkaListenerContainerFactory"
    )
    public void documentListener(@Payload Document document){
        System.out.println("$$$$$ document received: " + document);
//        log.info("@@@@@ Received Document: {}", document);
    }
}
