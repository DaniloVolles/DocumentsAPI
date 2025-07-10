package com.danilo.volles.documents.api.controller;

import com.danilo.volles.documents.api.entity.Document;
import com.danilo.volles.documents.api.service.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Implements a simple CONSUMER for KAFKA flow
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DocumentConsumer {

    private final DocumentService documentService;

    @KafkaListener(
            topics = "${topic.name.consumer}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "documentKafkaListenerContainerFactory"
    )
    public void documentListener(@Payload Document document) {
        log.warn("@@@ DOCUMENT RECEIVED: {}", document);
        documentService.processDocument(document);
    }
}
