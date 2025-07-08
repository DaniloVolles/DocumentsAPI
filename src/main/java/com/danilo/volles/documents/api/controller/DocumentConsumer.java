package com.danilo.volles.documents.api.controller;

import com.danilo.volles.documents.api.entity.Document;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DocumentConsumer {

    private static final String TOPIC = "process-documents";

    @KafkaListener(topics = TOPIC, groupId = "documents-group")
    public void documentListener(Document document){
        log.info("@@@@@ Received Document: {}", document);
    }
}
