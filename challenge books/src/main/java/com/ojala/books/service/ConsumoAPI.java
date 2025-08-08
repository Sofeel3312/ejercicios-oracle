package com.ojala.books.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ConsumoAPI {
    private final HttpClient client = HttpClient.newHttpClient();
    public String obtenerDatos(String url) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al consumir la API: " + e.getMessage());
            throw new RuntimeException("Error al consumir la API", e);
        }
    }
}
