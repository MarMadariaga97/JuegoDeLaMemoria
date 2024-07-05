package juego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Tablero {
 private ArrayList<Carta> listadoCartas;
 private Carta[][] tabla;
 private String archivo="src/datos/DatosPalabras.txt";
 
 
 public Tablero() {
	 this.listadoCartas=new ArrayList<>();
	 this.cargarCartas();
	 this.tabla=new Carta[4][4];
	 this.cargarTablero();
 }
 
 public void cargarCartas() {
	 try {
	        BufferedReader lector = new BufferedReader(new FileReader(archivo));

	        String linea;
	        int i=0;
	        while (i<=16 && (linea = lector.readLine()) != null) {
	        	Carta c=new Carta(linea);
	        	Carta c1=new Carta(linea);
	            this.listadoCartas.add(c);
	            this.listadoCartas.add(c1);
	        
	           i++;
	        }
	        
	        //Mezcla los elementos del arrayList listadoDeCartas
	        Collections.shuffle(this.listadoCartas);
	       
	        lector.close();
	    } catch (IOException e) {
	    	 System.err.println("Error al leer el archivo: "+ e.getMessage());;
	    }
 }
 
 public void cargarTablero() {
	 int s=0;
	 for(int i=0; i<this.getDimension(); i++) {
		 for(int j=0; j<this.getDimension(); j++) {
			 this.tabla[i][j]=this.listadoCartas.get(s);
			 s+=1;
		 }
	 }
 }
 
 public int getDimension() {
	 return this.tabla.length;
 }
 
 public Carta [][] getTabla(){
	 return this.tabla;
 }
 
 public boolean sonIguales(Carta c1, Carta c2) {
	 if(c1.getPalabra().equals(c2.getPalabra())){
		 return true;
	 }
	 else
		 return false;
 }
 
 
}
