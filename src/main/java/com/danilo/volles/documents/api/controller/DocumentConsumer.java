package com.danilo.volles.documents.api.controller;

import com.danilo.volles.documents.api.entity.Document;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DocumentConsumer {

    @KafkaListener(
            topics = "${topic.name.consumer}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "documentKafkaListenerContainerFactory"
    )
    public void documentListener(@Payload Document document){
        log.warn("@@@ DOCUMENT RECEIVED: {}", document);
    }
}
