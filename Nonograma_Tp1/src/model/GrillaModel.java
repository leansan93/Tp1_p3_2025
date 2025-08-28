package model;

public class GrillaModel {

	private int[][] celdas;
	
	public GrillaModel(int filas, int columnas) {
		celdas = new int[filas][columnas];
	}
	
	//GETTERS Y SETTERS
	public int getCelda(int fila, int columna) { return celdas[fila][columna]; }
    public void setCelda(int fila, int columna, int valor) { celdas[fila][columna] = valor; }
    public int[][] getCeldas() { return celdas; }
	
}
