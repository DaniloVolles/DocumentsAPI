package com.danilo.volles.documents.api.dto;

import com.danilo.volles.documents.api.entity.Document;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Demo API wrapper object")
public record ApiResponseWrapper(String message, Document document) {
}
