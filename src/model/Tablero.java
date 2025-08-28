package model;

import java.util.Random;

public class Tablero {

    // VARIABLES DEL TABLERO
    private int filas;
    private int columnas;
    private int[][] celdas; //  -1 = X, 0 = blanco, 1 = negro
    private int[][] pistasFilas;
    private int[][] pistasColumnas;
    private int[][] solucion;

    // CONSTRUCTOR TABLERO
    public Tablero(int filas, int columnas, int[][] solucion) {
    	this.filas = filas;
    	this.columnas = columnas;
    	this.solucion = solucion;
    	this.celdas = new int[filas][columnas];
    	
    	// CALCULA AUTOMATICAMENTE LAS PISTAS
        this.pistasFilas = calcularPistasFilas(solucion);
        this.pistasColumnas = calcularPistasColumnas(solucion);
    }

    // MARCAR CELDA
    public void marcarCelda(int fila, int columna, int valor) {
        celdas[fila][columna] = valor;
    }

    // OBTENER CELDA
    public int getCelda(int fila, int columna) {
        return celdas[fila][columna];
    }

    // VALIDAR SOLUCION
    public boolean validarSolucion() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (celdas[i][j] != solucion[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    // RESETEAR TABLERO
    public void reset() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = 0; // BLANCO
            }
        }
    }
    
    // GENERAR MATRIZ/SOLUCION ALEATORIA
    public static int[][] generarSolucionAleatoria(int filas, int columnas) {
    	int[][] solucion = new int[filas][columnas];
    	Random rnd = new Random();
    	
    	for (int i = 0; i < filas; i++) {
    		for (int j = 0; j < columnas; j++) {
    			solucion[i][j] = rnd.nextBoolean() ? 1 : 0;
    		}
    	}
    	return solucion;
    }
    
 // FUNCION PARA PISTAS FILAS
 public static int[][] calcularPistasFilas(int[][] solucion) {
     int filas = solucion.length;
     int columnas = solucion[0].length;
     // MATRIZ DONDE SE GUARDARAN LAS PISTAS DE CADA FILA
     int[][] pistasFilas = new int[filas][columnas];
     
     // RECORREMOS CADA FILA DE LA SOLUCION
     for (int i = 0; i < filas; i++) {
         int indice = 0;   // POSICION DENTRO DE LA FILA DE PISTAS DONDE SE VA A ESCRIBIR
         int contador = 0; // CUENTA LA CANTIDAD DE 1 CONSECUTIVOS
         
         for (int j = 0; j < columnas; j++) {
             if (solucion[i][j] == 1) { 
                 // SI LA CELDA ESTA PINTADA, INCREMENTAMOS EL CONTADOR
                 contador++;
             } else {
                 // SI ENCONTRAMOS UN 0
                 if (contador > 0) {
                     // GUARDAMOS LA LONGITUD DEL BLOQUE EN LAS PISTAS
                     pistasFilas[i][indice++] = contador;
                     contador = 0; // REINICIAMOS EL CONTADOR
                 }
             }
         }
         // SI LA FILA TERMINO CON UN BLOQUE DE 1s, TAMBIEN LO GUARDAMOS
         if (contador > 0) {
             pistasFilas[i][indice] = contador;
         }
     }
     return pistasFilas;
 }

 // FUNCION PARA PISTAS COLUMNAS
 public static int[][] calcularPistasColumnas(int[][] solucion) {
     int filas = solucion.length;
     int columnas = solucion[0].length;

     // MATRIZ DONDE SE GUARDARAN LAS PISTAS DE CADA COLUMNA
     int[][] pistasColumnas = new int[columnas][filas];
     
     for (int j = 0; j < columnas; j++) {
         int indice = 0;   // POSICION DENTRO DE LA COLUMNA DE PISTAS DONDE SE VA A ESCRIBIR
         int contador = 0; // CUENTA LA CANTIDAD DE 1 CONSECUTIVOS
         
         for (int i = 0; i < filas; i++) {
             if (solucion[i][j] == 1) {
                 // SI LA CELDA ESTA PINTADA, INCREMENTAMOS EL CONTADOR
                 contador++;
             } else {
                 // SI ENCONTRAMOS UN 0
                 if (contador > 0) {
                     // GUARDAMOS LA LONGITUD DEL BLOQUE EN LAS PISTAS
                     pistasColumnas[j][indice++] = contador;
                     contador = 0; // REINICIAMOS CONTADOR
                 }
             }
         }
         // SI LA COLUMNA TERMINO CON UN BLOQUE DE 1s, TAMBIEN LO GUARDAMOS
         if (contador > 0) {
             pistasColumnas[j][indice] = contador;
         }
     }
     return pistasColumnas;
 }

 	// GETTERS
    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }
    public int[][] getPistasFilas() { return pistasFilas; }
    public int[][] getPistasColumnas() { return pistasColumnas; }
    public int[][] getSolucion() { return solucion; }
    public int[][] getCeldas() { return celdas; }
} 

