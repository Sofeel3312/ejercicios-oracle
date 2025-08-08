package com.ojala.books.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultadoBusqueda {
    private List<LibroEpilogo> results;

    public List<LibroEpilogo> getResults() {
        return results;
    }

    public void setResults(List<LibroEpilogo> results){
        this.results = results;
    }
}
