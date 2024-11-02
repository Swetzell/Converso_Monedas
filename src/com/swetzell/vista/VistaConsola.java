package com.swetzell.vista;

import java.util.Scanner;

public class VistaConsola implements VistaConversor {
    private Scanner scanner;

    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void mostrarMenuPrincipal() {
        System.out.println("=== Conversor de Monedas ===");
        System.out.println("1 - Realizar conversión");
        System.out.println("2 - Salir");
        System.out.print("Seleccione una opcion: ");
    }

    @Override
    public String obtenerMonedaOrigen() {
        System.out.print("Ingrese la moneda de origen (dolares, euros, soles, yen): ");
        return scanner.nextLine().toLowerCase();
    }

    @Override
    public String obtenerMonedaDestino() {
        System.out.print("Ingrese la moneda de destino (dolares, euros, soles, yen): ");
        return scanner.nextLine().toLowerCase();
    }

    @Override
    public double obtenerCantidad() {
        while (true) {
            System.out.print("Ingrese la cantidad a convertir: ");
            try {
                double cantidad = Double.parseDouble(scanner.nextLine());
                if (cantidad < 0) {
                    System.out.println("La cantidad no puede ser negativa. Intente nuevamente.");
                    continue;
                }
                return cantidad;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
            }
        }
    }



    @Override
    public void mostrarResultado(String monedaOrigen, String monedaDestino, double cantidad, double resultado) {
        System.out.printf("%.2f %s equivale a %.2f %s\n", cantidad, monedaOrigen, resultado, monedaDestino);
    }

    @Override
    public void mostrarError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void pausar() {
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();
    }
}
