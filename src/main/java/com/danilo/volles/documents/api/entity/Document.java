package com.danilo.volles.documents.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    private String title;
    private String author;
    private Status status;
    private LocalDate sendDate;
}
