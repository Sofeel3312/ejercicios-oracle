package com.ojala.books.model;

public class MenuIdiomas {
    public static void mostrarMenuIdiomas() {
        System.out.println("\nIdiomas disponibles:");
        for (Idioma idioma : Idioma.values()) {
            System.out.printf("%s (%s)\n", idioma.getNombre(), idioma.getCodigo());
        }
        System.out.println("\nIngresa uno o varios códigos separados por coma (ej. en,fr,es):");

    }


}
