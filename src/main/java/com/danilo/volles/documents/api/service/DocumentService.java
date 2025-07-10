package com.danilo.volles.documents.api.service;

import com.danilo.volles.documents.api.entity.Document;
import com.danilo.volles.documents.api.entity.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Implements a simple process for the consumed document, assigning it a random status.
 * Simulates a state change in production flows.
 */
@Slf4j
@Service
public class DocumentService {

    public void processDocument(Document document) {

        log.warn("@@@ PREVIOUS DOCUMENT STATUS: {}", document.getStatus());

        // Set a new random Status
        document.setStatus(Status.getRandomStatus());

        log.warn("@@@ NEW DOCUMENT STATUS: {}", document.getStatus());
    }
}
