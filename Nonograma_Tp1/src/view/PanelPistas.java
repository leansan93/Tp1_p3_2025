package view;

import javax.swing.*;

import model.PistasModel;

import java.awt.*;

public class PanelPistas extends JPanel {
	
	// CONSTRUCTOR DEL PANEL DE PISTAS
	public PanelPistas(PistasModel model) {
		int filas = model.getPistasFilas().length;
        int columnas = model.getPistasColumnas().length;
        
        setLayout(new BorderLayout());

        // PANEL DE COLUMNAS
        JPanel panelColumnas = new JPanel(new GridLayout(1, columnas));
        for (int j = 0; j < columnas; j++) {
        	String texto = "";
        	for (int n : model.getPistasColumnas()[j]) {
        		if (n != 0) texto += n + " ";
        	}
        	panelColumnas.add(new JLabel(texto, SwingConstants.CENTER));
        }
	
        // PANEL DE FILAS
        JPanel panelFilas = new JPanel(new GridLayout(filas, 1));
        for (int i = 0; i < filas; i++) {
        	String texto = "";
        	for (int n : model.getPistasFilas()[i]) {
        		if (n != 0) texto += n + " ";
        	}
        	panelFilas.add(new JLabel(texto, SwingConstants.RIGHT));
        }
        
        add(panelColumnas, BorderLayout.NORTH);
        add(panelFilas, BorderLayout.WEST);
	}
}
