package com.swetzell.modelo;

public class Conversion {
    private Moneda monedaOrigen;
    private Moneda monedaDestino;
    private double cantidadOrigen;
    private double cantidadDestino;

    public Conversion(Moneda monedaOrigen, Moneda monedaDestino, double cantidadOrigen, double cantidadDestino) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidadOrigen = cantidadOrigen;
        this.cantidadDestino = cantidadDestino;
    }

    public Moneda getMonedaOrigen() {
        return monedaOrigen;
    }

    public Moneda getMonedaDestino() {
        return monedaDestino;
    }

    public double getCantidadOrigen() {
        return cantidadOrigen;
    }

    public double getCantidadDestino() {
        return cantidadDestino;
    }
}
