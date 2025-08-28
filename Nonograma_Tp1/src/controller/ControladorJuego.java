package controller;

import model.GrillaModel;
import model.Tablero;
import view.PanelGrilla;

public class ControladorJuego {

	private Tablero tablero;
	private PanelGrilla panelGrilla;
	private GrillaModel grillaModel;
	
	public ControladorJuego(Tablero tablero, PanelGrilla panelGrilla) {
//	public ControladorJuego(GrillaModel grillaModel, PanelGrilla panel) {
		// NUEVO
		this.grillaModel = grillaModel;
		
//		this.tablero = tablero;
//		this.panelGrilla = panelGrilla;
		
		// REGISTRAR LISTENER PARA LOS CLICKS EN CADA CELDA.
		panelGrilla.activarClickCelda((fila, columna) -> {
			int estadoActual = tablero.getCelda(fila, columna);
			int nuevoEstado = siguienteEstado(estadoActual);
			tablero.marcarCelda(fila, columna, nuevoEstado);
			panelGrilla.actualizar(tablero.getCeldas());
		});
	}
	
	private int siguienteEstado(int actual) {
	    if (actual == 0) return 1;   // blanco → negro
	    if (actual == 1) return -1;  // negro → X
	    return 0;                     // X → blanco
	}
	
	public void verificarSolucion() {
		if (tablero.validarSolucion()) {
            panelGrilla.mostrarMensaje("¡Ganaste!");
        } else {
            panelGrilla.mostrarMensaje("Perdiste, intenta de nuevo.");
        }
    }
}
