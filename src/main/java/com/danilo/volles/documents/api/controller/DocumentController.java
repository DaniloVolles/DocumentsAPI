package com.danilo.volles.documents.api.controller;

import com.danilo.volles.documents.api.annotation.ApiController;
import com.danilo.volles.documents.api.entity.Document;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@ApiController
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentProducer producer;

    @PostMapping("/documents")
    public ResponseEntity<String> sendDocument(@RequestBody Document document) {
        producer.sendDocument(document);
        return ResponseEntity.ok("Document successfully sent: " + document.toString());
    }
}
