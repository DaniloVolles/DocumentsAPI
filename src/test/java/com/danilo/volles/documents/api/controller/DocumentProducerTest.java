package com.danilo.volles.documents.api.controller;

import com.danilo.volles.documents.api.entity.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DocumentProducerTest {

    @Mock
    private KafkaTemplate<String, Document> kafkaTemplate;

    private DocumentProducer producer;

    private final String TOPIC = "test-topic";

    @BeforeEach
    void setUp() {
        producer = new DocumentProducer(kafkaTemplate, TOPIC);
    }

    @Test
    void shouldSendDocumentToKafkaTopic() {
        // given
        Document doc = new Document();
        doc.setTitle("Test Document");

        // when
        producer.sendDocument(doc);
        producer.sendDocument(doc);
        producer.sendDocument(doc);

        // then
        verify(kafkaTemplate, times(3)).send(TOPIC, doc);
    }
}