package com.ojala.books.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LibroEpilogo {
    @JsonProperty("title")
    private String title;
    @JsonProperty("authors")
    private List<Author> authors;
    @JsonProperty("languages")
    private List<String> languages;
    @JsonProperty("formats")
    private Map<String, String> formats;
    @JsonProperty("download_count")
    private int downloadCount;
    @JsonProperty("subjects")
    private List<String> subjects;
    @JsonProperty("description")
    private String description;
    @JsonProperty("summaries")
    private List<String> summaries;
    @JsonProperty("publication_date")
    LocalDate fechaPublicacion;

    public Book toBook() {
        return new Book(
                title != null ? title : "Título desconocido",
                authors != null ? authors : List.of(),
                languages != null ? languages : List.of(),
                subjects != null ? subjects : List.of(),
                downloadCount,
                description != null ? description : "Sin descripción disponible",
                fechaPublicacion,
                summaries != null ? summaries : List.of()

        );
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Map<String, String> getFormats() {
        return formats;
    }

    public void setFormats(Map<String, String> formats) {
        this.formats = formats;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<String> summaries) {
        this.summaries = summaries;
    }
}
