package com.conversor.alura.service;

import com.google.gson.Gson;

public class ConvierteDatos {
    private Gson gson = new Gson();
    public <T> T obtenerDatos(String json, Class<T> clase){
        if (json == null || json.isEmpty() || !json.trim().startsWith("{")) {
            throw new IllegalStateException("JSON inválido o no es un objeto: " + json);
        }
        Gson gson = new Gson();
        return gson.fromJson(json, clase);
    }
}
