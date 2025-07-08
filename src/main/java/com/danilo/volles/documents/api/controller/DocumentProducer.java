package com.danilo.volles.documents.api.controller;

import com.danilo.volles.documents.api.entity.Document;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentProducer {

    private final KafkaTemplate<String, Document> documentKafkaTemplate;
    private static final String TOPIC = "process-documents";

    public void sendDocument(Document document) {
        documentKafkaTemplate.send(TOPIC, document);
        log.info("@@@@@ document sent: {}", document);
    }
}
