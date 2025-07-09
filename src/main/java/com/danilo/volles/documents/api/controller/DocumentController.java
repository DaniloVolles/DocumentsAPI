package com.danilo.volles.documents.api.controller;

import com.danilo.volles.documents.api.dto.ApiResponseWrapper;
import com.danilo.volles.documents.api.entity.Document;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentProducer producer;

    @PostMapping("/send")
    public ResponseEntity<ApiResponseWrapper> sendDocument(@RequestBody Document document) {
        producer.sendDocument(document);
        return ResponseEntity.ok(new ApiResponseWrapper("DOCUMENT SUCCESSFULLY SENT", document));
    }
}
