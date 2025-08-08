package com.ojala.books.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;


@Service
public class ConvierteDatos {
    private final ObjectMapper mapper = new ObjectMapper();

    // Para objetos simples
    public <T> T deserializa(String json, Class<T> clase) {
        try {
            return mapper.readValue(json, clase);
        } catch (Exception e) {
            System.out.println("Error al deserializar objeto: " + e.getMessage());
            return null;
        }
    }

}
