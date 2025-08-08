package com.conversor.alura.model;

public class HistorialCambio {
    private String fecha;
    private String base;
    private String destino;
    private double monto;
    private double resultado;
    private double tasa;

    public HistorialCambio(String fecha, String base, String destino, double monto, double resultado, double tasa) {
        this.fecha = fecha;
        this.base = base;
        this.destino = destino;
        this.monto = monto;
        this.resultado = resultado;
        this.tasa = tasa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }
}

