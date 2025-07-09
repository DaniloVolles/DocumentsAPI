package com.danilo.volles.documents.api.controller;

import com.danilo.volles.documents.api.entity.Document;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Implements a simple PRODUCER for KAFKA flow
 */
@Slf4j
@Service
public class DocumentProducer {

    private final KafkaTemplate<String, Document> kafkaTemplate;
    private final String TOPIC;

    public DocumentProducer(KafkaTemplate<String, Document> kafkaTemplate,
                            @Value("${topic.name.producer}") String TOPIC) {
        this.kafkaTemplate = kafkaTemplate;
        this.TOPIC = TOPIC;
    }

    public void sendDocument(Document document) {
        kafkaTemplate.send(TOPIC, document);
        log.warn("@@@ DOCUMENT SENT: {}", document);
    }
}
