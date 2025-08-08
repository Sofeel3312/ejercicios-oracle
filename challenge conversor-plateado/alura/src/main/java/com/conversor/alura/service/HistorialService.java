package com.conversor.alura.service;

import com.conversor.alura.model.HistorialCambio;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HistorialService {
    private final String archivo = "historial.json";
    private final Gson gson = new Gson();

    public HistorialService() {
        limpiarHistorial(); //borra el historial
        File file = new File(archivo);
        if (!file.exists()) {
            try (Writer writer = new FileWriter(file)) {
                writer.write("[]");
            } catch (IOException e) {
                System.out.println("Error al inicializar historial: " + e.getMessage());
            }
        }
    }

    public void guardarCambio(HistorialCambio cambio) {
        List<HistorialCambio> historial = cargarHistorial();
        historial.add(cambio);
        try (Writer writer = new FileWriter(archivo)) {
            gson.toJson(historial, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el historial: " + e.getMessage());
        }
    }

    public List<HistorialCambio> cargarHistorial() {
        File file = new File(archivo);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea);
            }

            String json = contenido.toString().trim();

            if (json.isEmpty() || json.equals("null") || !json.startsWith("[") || !json.endsWith("]")) {
                System.out.println("Archivo de historial vacío o corrupto. Se devolverá historial vacío.");
                return new ArrayList<>();
            }

            Type tipoLista = new TypeToken<List<HistorialCambio>>(){}.getType();
            return gson.fromJson(contenido.toString(), tipoLista);
        } catch (IOException e) {
            System.out.println("Error al leer historial: " + e.getMessage());
            return new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Error al deserializar historial: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void limpiarHistorial(){
        try (Writer writer = new FileWriter(archivo)) {
            writer.write("[]");
        } catch (IOException e) {
            System.out.println("Error al limpiar historial: " + e.getMessage());
        }
    }


}

