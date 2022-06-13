package unileon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal {

	private static String alf = "aábcdeé AÁBCDEÉfghiíjklmnFGHIÍJKLMNoópqrstuúvwxyzOÓPQRSTUÚVWXYZ.,;¿?¡!";
	private static int lonAlf = alf.length();
	private static ArrayList<Integer> lista = new ArrayList<Integer>(Arrays.asList(0,1,1,1,0,1,1,0,0,0,1,1,0,0,0,0,0,1,1,1,1,1,1,0,0,1,1,1,0,0,1,0,0,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,1,1,1,0,1,1,1,0,1,1,0,0,0,1,1,0,0,0,0,1,0,0,1,1,0,1,1,1,0,0,1,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,1,1,1,0,0,1,0,0,0,0,1,1,1,0,1,1,1,0,0,1,0,1,0,0,1,0,0,1,1,0,0,0,0,1,1,1,0,0,1,0,1,1,1,0,0,0,1,1,1,0,0,1,0,1,1,1,0,0,0,0,1,1,1,1,1,1,0,0,1,0,0,1,0,0,1,1,0,1,1,1,1,1,0,1,1,0,0,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,1,1,0,0,0,0,0,0,1,1,0,1,0,1,1,0,0,0,1,0,0,1,0,1,0,0,1,0,0,1,1,0,0,0,1,1,1,0,1,0,0,1,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,1,1,1,0,0,1,0,0,1,0,0,0,0,1,1,0,1,1,0,0,0,0,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,0,0,1,0,0,0,0,1,1,1,1,1,1,0,0,1,0,1,0,0,0,0,1,1,1,0,1,1,1,1,1,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,0,1,1,1,0,1,1,1,0,1,1,0,0,1,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,0,1,0,0,0,0,1,1,1,1,1,1,0,0,1,0,0,0,1,1,1,0,0,1,0,1,1,1,0,0,0,0,1,1,1,1,1,1,0,0,1,0,1,0,0,0,0,1,1,1,0,1,1,1,0,0,1,0,0,1,1,0,1,1,1,1,1,1,1,0,1,0,1,0,1,1,0,1,1,0,0,0,1,1,1,0,1,0,0,1,0,0,0,0,0,1,0,0,1,1,0,1,1,1,1,1,0,1,0,0,1,1,0,0,0,1,1,1,0,0,1,0,0,1,1,0,0,0,1,1,1,0,1,1,0,1));
	private static int lonLista = lista.size();
	//TODO
	//Sustituir el 6 por en nº de columnas
	private static int palCod = lonLista/5;
	private static int simBin = lonLista%5;
	private static int[][] A = {{1,1,0}, {1,0,1}, {0,1,1}};
	
	
	private static ArrayList<ArrayList> codigo = new ArrayList<ArrayList>();
	private static ArrayList<ArrayList> secuencia = new ArrayList<ArrayList>();
	private static ArrayList<Integer> codCola = new ArrayList<Integer>();
	private static ArrayList<Integer> secCola = new ArrayList<Integer>();
	private static ArrayList<String> listado = new ArrayList<String>();
	private static ArrayList<String> listadoSiete = new ArrayList<String>();
	private static ArrayList<String> letraBinario = new ArrayList<String>();
	private static String mensaje = "";
	
	
	
	public static void main(String[] args) {
		
		
		extraerCodigo();
		
		extraerSecuencia();
		
		extraerCola();
		
		
		juntarSecuencias();
		
		dividirSecuencias();
		
		for (int i = 0; i < alf.length(); i++) {
			String binario = Integer.toBinaryString(i);
			for (int j = binario.length(); j < 7; j++) {
				binario = "0" + binario;
			}
			letraBinario.add(binario);
		}
		
		for (int i = 0; i < listadoSiete.size(); i++) {
			for (int j = 0; j < letraBinario.size(); j++) {
				if (listadoSiete.get(i).equals(letraBinario.get(j)) ) {
					mensaje += alf.charAt(j);
				}
			}
			
		}
		
		System.out.println(mensaje);
			
		
		
	}

	private static void dividirSecuencias() {
		//Divido las secuencias de 7 en 7
		for (int i = 0; i < listado.size(); i+=7) {
			
			String aux = "";
			aux += listado.get(i);
			aux += listado.get(i+1);
			aux += listado.get(i+2);
			aux += listado.get(i+3);
			aux += listado.get(i+4);
			aux += listado.get(i+5);
			aux += listado.get(i+6);
			
			listadoSiete.add(aux);			
		}
	}

	private static void juntarSecuencias() {
		//Meto en un arrayList las secuencias
		for (int i = 0; i < secuencia.size(); i++) {
			listado.add(secuencia.get(i).get(0).toString());
			listado.add(secuencia.get(i).get(1).toString());
			listado.add(secuencia.get(i).get(2).toString());
		}
		for (int i = 0; i < secCola.size(); i++) {
			listado.add(secCola.get(i).toString());
		}
	}

	private static void extraerCodigo() {
		//Divido de 6 en 6 la lista y añado a al código.
		for (int i = 0; i < lonLista-simBin; i+=5) {
			
			ArrayList<Integer> aux = new ArrayList<Integer>();
			
			aux.add(lista.get(i));
			aux.add(lista.get(i+1));
			aux.add(lista.get(i+2));
			aux.add(lista.get(i+3));
			aux.add(lista.get(i+4));
			
			codigo.add(aux);
						
		}
	}

	private static void extraerSecuencia() {
		//Divido de 3 en 3 el codigo y añado a la secuencia.
		for (int i = 0; i < codigo.size(); i++) {
			
			ArrayList<Integer> aux = new ArrayList<Integer>();
			
			aux.add((Integer) codigo.get(i).get(0));
			aux.add((Integer) codigo.get(i).get(1));
			aux.add((Integer) codigo.get(i).get(2));
			
			secuencia.add(aux);
		}
	}

	private static void extraerCola() {
		
		//Añadir el código de cola
		for (int i = lonLista-simBin; i < lonLista; i++) {	
			codCola.add(lista.get(i));
		}
		
		
		//Añadir la secuencia de cola
		for (int i = 0; i < 3; i++) {
			if (i < codCola.size()) {
				secCola.add(codCola.get(i));
			}
		}
		
		
	}

}
