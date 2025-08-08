package com.ojala.books.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record Book(
        @JsonProperty("title")
        String titulo,
        @JsonProperty("authors")
        List<Author> autores,
        @JsonProperty("languages")
        List<String> idiomas,
        @JsonProperty("subjects")
        List<String> generos,
        @JsonProperty("download_count")
        int descargas,
        String descripcion,
        @JsonProperty("publication_date")
        LocalDate fechaPublicacion,
        @JsonProperty("summaries")
        List<String> summaries

) {}

