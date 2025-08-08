package com.ojala.books.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsultaLibro {
    private final String titulo;
    private final LocalDateTime fechaConsulta;

    public ConsultaLibro(String titulo) {
        this.titulo = titulo;
        this.fechaConsulta = LocalDateTime.now();
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getFechaConsulta() {
        return fechaConsulta;
    }

    @Override
    public String toString() {
        return "- " + titulo + " (consultado el " + fechaConsulta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + ")";
    }
}
