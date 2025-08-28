package Negocio;

import java.util.ArrayList;
import java.util.Random;

public class Tabla {

	 private  int [][] tabla;
	 private int fila ;
	 private int columna ;
	
	 
	 public Tabla ( int tamano ) {
		 	fila = tamano ;
		 	columna=tamano;
		 	
		  crearTabla(tamano );  // en el constructor mando el tamano que se creara la tabla desde la interfaz 
		 
	 }
	 
//------------------------------------------------------------------------------------------------------------------------------	 
	 // //muestra el mapa,  con el random de pintados  con 1 es pintado  y 0 no pintado 
 	public  void crearTabla(int n) {
		tabla= new int [n][n];
		Random rand = new Random();
		for ( int fil=0 ; fil< tabla.length ; fil ++ ) {
			
			for (int col= 0 ; col < tabla[0].length ; col++) {
				
				 tabla[fil][col] = rand.nextInt(2);
				//System.out.print( tabla[fil][col] + " " );
			
			}
		//	System.out.println();
		}
		
	}
	
	

		
//---------------------------------------------------------------------------------------------------------------	
	// genera random en la tabla y coloca los pintados con 1 en cada posicion fila columna  
	/*		public  void generarRandom(int [][] tabla) {
				Random rand = new Random();
				for (int fil=0; fil<tabla.length; fil++ ) {
					for (int col=0; col<tabla[0].length; col++) {
						
						tabla[fil][col]= rand.nextInt(2); // genera random entre 1 y 0 
					
					 	
					}
				}
				
				
			}
	*/

//----------------------------------------------------------------------------------------------------------------	
//  PISTAS  DE LA FILA DE LA TABLA COMPLETO INVOCANDO A LOS METODOS PARA ENCONTRAR LAS PISTAS DE LAS FILAS Y MOSTRARLO   
//  EN UN  ArrayList LAS PISTAS DE LAS FILAS 
			public  ArrayList<String> buscarPistasFilaFinal(int[][] tabla) {
				ArrayList<String> pistas = new ArrayList<String>(5);
				
				for (int fil=0; fil<tabla.length; fil++ ) {
					String pis = buscarPistasFila(tabla[fil]);
					pistas.add(pis);
				}
				return pistas;
			}
			
			
			
			public int getFila() {
				return fila;
			}

			public void setFila(int fila) {
				this.fila = fila;
			}

			public int getColumna() {
				return columna;
			}

			public void setColumna(int columna) {
				this.columna = columna;
			}

			//-------------------------------------------------------------------------------------------------------------------------------------
			//guarda en un ArrayList las pistas de las columnas
			public  ArrayList<String> buscarPistasColumnaFinal(int[][] tabla) {
				ArrayList<String> pistas = new ArrayList<String>(5);
				
				for (int col=0; col<tabla.length; col++ ) {
					String pis = buscarPistasColumna(pasarColumnaArreglo(tabla, col));
					pistas.add(pis);
				}
				return pistas;
			}
			
//---------------------------------------------------------------------------------------------------------------------------
	//pasa las columnas de la matriz a un arreglo(o lista), para ubicar las posiciones al recorrer por columnas 
			public  int[] pasarColumnaArreglo(int[][] tabla, int col) {
				int[] columnas = new int[5];
						
				for(int f=0;f<tabla.length;f++) {
					int i = tabla[f][col];
					columnas[f] = i;
				}
				return columnas;
			}
			
			
			
			
			
			
			
//------------------------------------------------------------------------------------------------------------------------			
			//// TRANSCURSO DE ENCONTRAR LA PISTAS DE LAS  FILAS
	  /*lo que hacemos es recorrer la fila por indices
	  tenemos una variabe anterior que lo que hace es tener el elemento de la iteracion anterior
	  entonces, cuando iteramos preguntamos si es un 1, en el caso que lo sea se lo suma al cont1
	  sigue iterando y en el caso de que encuentre un 0 va a preguntar si el anterior es un 1
	   en el caso de que sea correcto, va a cambiar a la bandera 2 y empieza el cicli devuelta
	 */
	
			public  String buscarPistasFila(int[] fila) {
				String pistas = "";
				int cont1 = 0;
				int cont2 = 0;
				int cont3 = 0;
				int bandera = 1;		//la bandera nos srve para ir cambiando de contadores.

				for(int fil = 0; fil<fila.length; fil++) {
					int anterior;
					if (fil > 0) {
						anterior = fila[fil - 1];	
					}
					else {
						anterior = 0;
					}
					if (fila[fil] == 1) {
						if (bandera == 1) {
							cont1++;
						}
						if(bandera == 2) {
							cont2++;
						}
						if(bandera == 3) {
							cont3++;
						}
					}
					if(fila[fil] == 0 && anterior == 1) {
						if(bandera == 1) {
							bandera = 2;
						}
						else
							if(bandera == 2) {
							bandera = 3;
						}
					}
				}
				if(cont1 == 0) {
					pistas = 0 + "";
					return pistas;
				}
				if(cont2 == 0) {
					pistas = cont1 + "";
					return pistas;
				}
				if(cont3 == 0) {
					pistas = cont1 + "-" + cont2 + "";
					return pistas;
				}
				else{
					pistas = cont1 + "-" + cont2 + "-" + cont3;
				}
				return pistas;
			}
			
//-----------------------------------------------------------------------------------------------------------------------------------------
	/// buscar pistas COLUMNAS
			
			
			public  String buscarPistasColumna(int[] columna) {
				String pistas = "";
				int cont1 = 0;
				int cont2 = 0;
				int cont3 = 0;
				int bandera = 1;		//la bandera nos srve para ir cambiando de contadores.

				for(int col = 0; col<columna.length; col++) {
					int anterior;
					if (col > 0) {
						anterior = columna[col - 1];	
					}
					else {
						anterior = 0;
					}
					if (columna[col] == 1) {
						if (bandera == 1) {
							cont1++;
						}
						if(bandera == 2) {
							cont2++;
						}
						if(bandera == 3) {
							cont3++;
						}
					}
					if(columna[col] == 0 && anterior == 1) {
						if(bandera == 1) {
							bandera = 2;
						}
						else
							if(bandera == 2) {
							bandera = 3;
						}
					}
				}
				if(cont1 == 0) {
					pistas = 0 + "";
					return pistas;
				}
				if(cont2 == 0) {
					pistas = cont1 + "";
					return pistas;
				}
				if(cont3 == 0) {
					pistas = cont1 + "-" + cont2;
					return pistas;
				}
				else{
					pistas = cont1 + "-" + cont2 + "-" + cont3;
				}
				return pistas;
			}
//-------------------------------------------------------------------------------------------------------------------------------------------
			//muestra las pistas de las columnas
			public  void mostrarArraglo(ArrayList<String> arreglo) {
					System.out.println(arreglo);
			}
			
			//muestra las pistas de las filas
			public void mostrarArraglofila(ArrayList<String> arreglo) {
				for(int i = 0; i<arreglo.size(); i++) {
					System.out.println(arreglo.get(i));
			}	
		}

		
//--------------------------------------------------------------------------------------------------------------------------------------------
	// ACA HAY QUE CREAR EL METODO DE SI HACERTO LA TABLA PINTADA, en ves de hacer una constante comprobacion de si hacerto o no 
			// le damos la tabla entera luego de que el usuario halla terminado (lo envia por un boton "confirmar") se chequea si hacerto de manera
			// correcta todo seguido sin darle a una x , en el caso de que halla solo uno que se equivoco perdera 
			
			
			
			
 //-----------------------------------------------------------------------------------------------------------------------------------------
			// getters and setters de TABLA 
			
			public int[][] getTabla() {
				return tabla;
			}

			public void setTabla(int[][] tabla) {
				this.tabla = tabla;
			}
			 
	
	
}
