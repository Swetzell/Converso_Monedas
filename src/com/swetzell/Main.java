package com.swetzell;

import com.swetzell.controlador.ControladorConversor;
import com.swetzell.vista.VistaConsola;
import com.swetzell.vista.VistaConversor;

public class Main {
    public static void main(String[] args) {
        VistaConversor vista = new VistaConsola();
        ControladorConversor controlador = new ControladorConversor(vista);
        controlador.iniciar();
    }
}
