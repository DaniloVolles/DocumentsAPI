package com.danilo.volles.documents.api.controller;

import com.danilo.volles.documents.api.dto.ApiResponseWrapper;
import com.danilo.volles.documents.api.entity.Document;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Documents", description = "Documents endpoints")
@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentProducer producer;

    @Operation(
            summary = "Send document's metadata",
            description = "Send a document to KAFKA's Queue")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Document successfully sent"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/send")
    public ResponseEntity<ApiResponseWrapper> sendDocument(@RequestBody Document document) {
        producer.sendDocument(document);
        return ResponseEntity.ok(new ApiResponseWrapper("DOCUMENT SUCCESSFULLY SENT", document));
    }
}
