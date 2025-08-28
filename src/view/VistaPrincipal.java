package view;

import controller.ControladorJuego;
import model.GrillaModel;
import model.PistasModel;
import model.Tablero;

import javax.swing.*;
import java.awt.*;

public class VistaPrincipal extends JFrame {
	
	// CONSTRUCTOR DE LA VISTA PRINCIPAL
	public VistaPrincipal(Tablero tablero) {
        setTitle("Nonograma 5x5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        int filas = tablero.getFilas();
        int columnas = tablero.getColumnas();
        
        // PANEL PRINCIPAL DE 6X6
        JPanel panelPrincipal = new JPanel(new GridLayout(filas + 1 + 1, columnas + 1, 2, 2));
        panelPrincipal.add(new JLabel("")); // ESQUINA VACIA
        
        // PISTAS DE LA COLUMNA:
        for (int j = 0; j < columnas; j++) {
            String texto = "";
            // ANTES: tablero.
            for (int n : tablero.getPistasColumnas()[j]) {
                if (n != 0) texto += n + " ";
            }
            panelPrincipal.add(new JLabel(texto, SwingConstants.CENTER));
        }

        // PISTAS DE FILAS + BOTONES
        PanelGrilla panelGrilla = new PanelGrilla(filas, columnas);
        for (int i = 0; i < filas; i++) {
            // PISTA DE LA GRILLA:
            String textoFila = "";
            //ANTES: tablero.
            for (int n : tablero.getPistasFilas()[i]) {
                if (n != 0) textoFila += n + " ";
            }
            panelPrincipal.add(new JLabel(textoFila, SwingConstants.RIGHT));

            // BOTONES DE LA GRILLA:
            for (int j = 0; j < columnas; j++) {
                panelPrincipal.add(panelGrilla.getBoton(i, j));
            }
        }
        
        // MOSTRAR SOLUCION AL INICIAR (SOLO USAR PARA VER SI ANDA LA SOLUCION)
//        panelGrilla.mostrarSolucion(tablero.getSolucion());

        // BOTON PARA VERIFICAR LA SOLUCION
        JButton btnVerificar = new JButton("Verificar solución");

        // CONTROLADOR
        ControladorJuego controlador = new ControladorJuego(tablero, panelGrilla);
        btnVerificar.addActionListener(e -> controlador.verificarSolucion());

        // LAYOUT DE LA VENTANA
        setLayout(new BorderLayout());
        add(panelPrincipal, BorderLayout.CENTER);
        add(btnVerificar, BorderLayout.SOUTH);
        
        // TAMANIO FIJO DE LA PANTALLA
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null); // CENTRAR PANTALLA AL DISPOSITIVO
        setVisible(true);
    }
}
