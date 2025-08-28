package model;

public class PistasModel {
    private int[][] pistasFilas;
    private int[][] pistasColumnas;

    public PistasModel(int[][] pistasFilas, int[][] pistasColumnas) {
        this.pistasFilas = pistasFilas;
        this.pistasColumnas = pistasColumnas;
    }

    public int[][] getPistasFilas() { return pistasFilas; }
    public int[][] getPistasColumnas() { return pistasColumnas; }
}
