package com.swetzell.vista;

public interface VistaConversor {


    void mostrarMenuPrincipal();

    String obtenerMonedaOrigen();

    String obtenerMonedaDestino();

    double obtenerCantidad();

    void mostrarResultado(String monedaOrigen, String monedaDestino, double cantidad, double resultado);

    void mostrarError(String mensaje);

    void mostrarMensaje(String mensaje);

    void limpiarPantalla();

    void pausar();
}

