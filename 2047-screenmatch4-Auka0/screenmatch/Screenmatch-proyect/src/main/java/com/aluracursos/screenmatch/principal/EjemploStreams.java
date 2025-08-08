package com.aluracursos.screenmatch.principal;

import java.util.Arrays;
import java.util.List;

public class EjemploStreams {
    public void muestraEjemplo() {
        List<String> nombres = Arrays.asList("Hayde", "Luis", "Eric", "Genesys", "Arwen");
        nombres.stream()
                .sorted()
                .limit(2)
                .filter(n->n.startsWith("A"))
                .map(n->n.toUpperCase())
                .forEach(System.out::println);
    }
}
