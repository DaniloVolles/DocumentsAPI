package com.danilo.volles.documents.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Demo document object")
public class Document implements Serializable {
    private String title;
    private String author;
    private Status status;
    private LocalDate sendDate;
}
