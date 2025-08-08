package com.ojala.books.model;

public enum FichaVisual {
    TITULO("title", "Título"),
    AUTOR("authors", "Autor(es)"),
    IDIOMA("languages", "Idioma(s)"),
    GENERO("subjects", "Género(s)"),
    DESCARGAS("download_count", "Descargas"),
    DESCRIPCION("description", "Descripción"),
    SINOPSIS("summaries", "Sinopsis");

    private final String campoOriginal;
    private final String campoEspanol;

    FichaVisual(String campoOriginal, String campoEspanol) {
        this.campoOriginal = campoOriginal;
        this.campoEspanol = campoEspanol;
    }

    public String getCampoOriginal() {
        return campoOriginal;
    }

    public String getCampoEspanol() {
        return campoEspanol;
    }

    public static FichaVisual fromOriginal(String text) {
        for (FichaVisual campo : FichaVisual.values()) {
            if (campo.campoOriginal.equalsIgnoreCase(text)) {
                return campo;
            }
        }
        throw new IllegalArgumentException("Campo no reconocido: " + text);
    }

    public static FichaVisual fromEspanol(String text) {
        for (FichaVisual campo : FichaVisual.values()) {
            if (campo.campoEspanol.equalsIgnoreCase(text)) {
                return campo;
            }
        }
        throw new IllegalArgumentException("Campo no reconocido: " + text);
    }
}