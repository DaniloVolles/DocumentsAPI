package com.danilo.volles.documents.api.controller;

import com.danilo.volles.documents.api.entity.Document;
import com.danilo.volles.documents.api.service.DocumentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DocumentConsumerTest {

    @Mock
    private DocumentService service;

    private DocumentConsumer consumer;

    @BeforeEach
    void setUp() {
        consumer = new DocumentConsumer(service);
    }

    @Test
    void shouldProcessReceivedDocument() {
        // given
        Document doc = new Document();
        doc.setTitle("Consumed Document");

        // when
        consumer.documentListener(doc);
        consumer.documentListener(doc);
        consumer.documentListener(doc);

        // then
        verify(service, times(3)).processDocument(doc);
    }
}