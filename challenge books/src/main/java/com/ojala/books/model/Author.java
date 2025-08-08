package com.ojala.books.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Author(@JsonProperty("name") String name,
                     @JsonProperty("birth_year") Integer birthYear,
                     @JsonProperty("death_year") Integer deathYear) {
    public String nombreFormateado() {
        if (name == null || name.isBlank()) return "Autor desconocido";

        String limpio = name.trim().replaceAll(",+$", ""); // elimina comas finales

        if (limpio.contains(",")) return limpio;

        String[] partes = limpio.split("\\s+");
        if (partes.length < 2) return limpio;

        String apellido = partes[partes.length - 1];
        String nombre = String.join(" ", java.util.Arrays.copyOf(partes, partes.length - 1));

        return apellido + ", " + nombre;
    }

    @Override
    public String toString() {
        return nombreFormateado();
    }

}
