package com.swetzell.controlador;

import com.swetzell.modelo.*;
import com.swetzell.vista.VistaConversor;

import java.util.HashMap;
import java.util.Map;

public class ControladorConversor {
    private VistaConversor vista;
    private Map<String, Moneda> monedas;
    private Map<String, TasaCambio> tasasCambio;

    public ControladorConversor(VistaConversor vista) {
        this.vista = vista;
        inicializarMonedas();
        inicializarTasasCambio();
    }

    private void inicializarMonedas() {
        monedas = new HashMap<>();
        monedas.put("dolares", new Moneda("USD", "Dólares"));
        monedas.put("euros", new Moneda("EUR", "Euros"));
        monedas.put("soles", new Moneda("PEN", "Soles"));
        monedas.put("yen", new Moneda("YEN", "Yen"));
    }

    private void inicializarTasasCambio() {
        tasasCambio = new HashMap<>();
        tasasCambio.put("USD-PEN", new TasaCambio(monedas.get("dolares"), monedas.get("soles"), 3.75));
        tasasCambio.put("USD-EUR", new TasaCambio(monedas.get("dolares"), monedas.get("euros"), 0.85));
        tasasCambio.put("USD-YEN", new TasaCambio(monedas.get("dolares"), monedas.get("yen"),0.0065));
        tasasCambio.put("EUR-PEN", new TasaCambio(monedas.get("euros"), monedas.get("soles"), 4.10));
        tasasCambio.put("EUR-USD", new TasaCambio(monedas.get("euros"), monedas.get("dolares"), 1.18));
        tasasCambio.put("EUR-YEN", new TasaCambio(monedas.get("euros"), monedas.get("yen"), 166.43));
        tasasCambio.put("PEN-USD", new TasaCambio(monedas.get("soles"), monedas.get("dolares"), 0.27));
        tasasCambio.put("PEN-EUR", new TasaCambio(monedas.get("soles"), monedas.get("euros"), 0.24));
        tasasCambio.put("PEN-YEN", new TasaCambio(monedas.get("soles"), monedas.get("yen"), 40.57));
        tasasCambio.put("YEN-PEN", new TasaCambio(monedas.get("yen"), monedas.get("soles"), 0.025));
        tasasCambio.put("YEN-USD", new TasaCambio(monedas.get("yen"), monedas.get("dolares"), 0.0065));
        tasasCambio.put("YEN-EUR", new TasaCambio(monedas.get("yen"), monedas.get("euros"), 0.0060));
    }

    public void iniciar() {
        while (true) {
            vista.limpiarPantalla();
            vista.mostrarMenuPrincipal();
            String opcion = vista.obtenerMonedaOrigen();
            if (opcion.equals("2")) {
                vista.mostrarMensaje("Gracias por usar el conversor. ¡Hasta luego!");
                break;
            } else if (opcion.equals("1")) {
                realizarConversion();
            } else {
                vista.mostrarError("Opción no valida. Por favor, intente de nuevo.");
            }
            vista.pausar();
        }
    }

    private void realizarConversion() {
        String monedaOrigenStr = vista.obtenerMonedaOrigen();
        String monedaDestinoStr = vista.obtenerMonedaDestino();
        double cantidad = vista.obtenerCantidad();

        Moneda monedaOrigen = monedas.get(monedaOrigenStr);
        Moneda monedaDestino = monedas.get(monedaDestinoStr);

        if (monedaOrigen == null || monedaDestino == null) {
            vista.mostrarError("Moneda no valida. Por favor, intente de nuevo.");
            return;
        }

        String claveTasa = monedaOrigen.getCodigo() + "-" + monedaDestino.getCodigo();
        TasaCambio tasaCambio = tasasCambio.get(claveTasa);

        if (tasaCambio == null) {
            vista.mostrarError("No se encontro una tasa de cambio para la conversión solicitada.");
            return;
        }

        double resultado = cantidad * tasaCambio.getTasa();
        vista.mostrarResultado(monedaOrigenStr, monedaDestinoStr, cantidad, resultado);
    }
}
