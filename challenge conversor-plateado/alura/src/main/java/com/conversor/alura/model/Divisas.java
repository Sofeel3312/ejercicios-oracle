package com.conversor.alura.model;

public enum Divisas {
    USD("Dólar estadounidense", "Estados Unidos"),
    EUR("Euro", "Unión Europea"),
    MXN("Peso mexicano","México"),
    GBP("Libra esterlina","Reino Unido"),
    JPY("Yen japonés","Japón"),
    CAD("Dólar canadiense","Canadá"),
    BRL("Real brasileño","Brasil"),
    CNY("Yuan chino","China"),
    INR("Rupia india","India"),
    AUD("Dólar australiano","Australia"),
    CHF("Franco suizo","Suiza"),
    KRW("Won surcoreano","Corea del Sur"),
    SEK("Corona sueca","Suecia"),
    NOK("Corona noruega","Noruega"),
    ZAR("Rand sudafricano","Sudáfrica");

    private final String nombre;
    private final String pais;

    Divisas(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getCodigo() {
        return this.name(); // El nombre del enum (ej. USD)
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

}
