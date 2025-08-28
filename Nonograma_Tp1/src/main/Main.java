package main;

import model.GrillaModel;
import model.PistasModel;
import model.Tablero;
import view.VistaPrincipal;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static Tablero tableroActual;
    private static VistaPrincipal vista;

    public static void main(String[] args) {

        // ELEGIR TAMANIO DE LA CELDA
        int filas = 10;
        int columnas = 10;

        // CREAR TABLERO INICIAL
        crearNuevoTablero(filas, columnas);

        // BOTON DE REINICIAR
        JButton btnReiniciar = new JButton("Reiniciar tablero");
        btnReiniciar.addActionListener(e -> {
            crearNuevoTablero(filas, columnas);
            // CERRAR VENTANA ANTERIOR Y ABRIR NUEVA
            vista.dispose();
            // ANTES: vista = new VistaPrincipal(tableroActual);
            vista = new VistaPrincipal(tableroActual);
        });

        // MOSTRAR BOTON EN UNA VENTANA SIMPLE
        JFrame frameBoton = new JFrame();
        frameBoton.setTitle("Opciones");
        frameBoton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameBoton.add(btnReiniciar);
        frameBoton.pack();
        frameBoton.setLocationRelativeTo(null);
        frameBoton.setVisible(true);
    }

    private static void crearNuevoTablero(int filas, int columnas) {
        // GENERAR SOLUCION ALEATORIA
        int[][] solucion = Tablero.generarSolucionAleatoria(filas, columnas);

        // CREAR MODELO
        tableroActual = new Tablero(filas, columnas, solucion);

        // ABRIR VISTA SI AUN NO EXISTE
        if (vista == null) {
        	// ANTES: vista = new VistaPrincipal(tableroActual);
            vista = new VistaPrincipal(tableroActual);
        }
    }
}