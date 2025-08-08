package com.ojala.books.model;

public enum Idioma {
        EN("en", "Inglés"),
        FR("fr", "Francés"),
        DE("de", "Alemán"),
        ES("es", "Español"),
        PT("pt", "Portugués"),
        IT("it", "Italiano"),
        NL("nl", "Neerlandés"),
        FI("fi", "Finés"),
        LA("la", "Latín"),
        SV("sv", "Sueco"),
        EL("el", "Griego moderno"),
        PL("pl", "Polaco"),
        RU("ru", "Ruso");


        private final String codigo;
        private final String nombre;

        Idioma(String codigo, String nombre) {
            this.codigo = codigo;
            this.nombre = nombre;
        }

        public String getCodigo() {
            return codigo;
        }

        public String getNombre() {
            return nombre;
        }

}
