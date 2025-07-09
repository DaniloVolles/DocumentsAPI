package com.danilo.volles.documents.api.dto;

import com.danilo.volles.documents.api.entity.Document;

public record ApiResponseWrapper(String message, Document document) {
}
