package com.swetzell.modelo;

public class TasaCambio {
    private Moneda monedaOrigen;
    private Moneda monedaDestino;
    private double tasa;

    public TasaCambio(Moneda monedaOrigen, Moneda monedaDestino, double tasa) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tasa = tasa;
    }

    public Moneda getMonedaOrigen() {
        return monedaOrigen;
    }

    public Moneda getMonedaDestino() {
        return monedaDestino;
    }

    public double getTasa() {
        return tasa;
    }
}
