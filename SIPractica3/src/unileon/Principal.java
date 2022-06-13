package unileon;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Principal {
	
	private static final int DECIMALS = 100;
	private static BigDecimal numDec = new BigDecimal("0.64305190090813701863205198297481592574");
	private static int lonMen = 28;
	private static String cadena = "En Hegroz, a últimos de enero de 1948, el guardabosques de los\n" + 
			"Corvo se mató sin querer, cuando la batida contra los lobos. Decían\n" + 
			"que el arma que usó era vieja y mala, y le estalló en la cara,\n" + 
			"dejándolsela como una esponja. Como era hombre sin parientes ni\n" + 
			"amigos, únicamente fueron a enterrarle el viejo Gerardo Corvo y\n" + 
			"los chavales de la escuela, porque les obligó el cura.";
	private static ArrayList<Integer> frecuencias = new ArrayList<Integer>();
	private static ArrayList<String> caracteres = new ArrayList<String>();
	private static ArrayList<String> alfabeto = new ArrayList<String>();
	private static String mensaje = "";
	
	public static void main(String[] args) {
		
		ejercicio1();
		
		BigDecimal sumFrec = new BigDecimal(alfabeto.size()+"");
		
		for (int i = 0; i < lonMen; i++) {
			
			BigDecimal numL = new BigDecimal("0");
			for (int j = 0; j < caracteres.size(); j++) {
				
				BigDecimal frecAct = new BigDecimal(frecuencias.get(j)+"");
				
				BigDecimal numH = new BigDecimal(numL.add(frecAct)+"");
				
				BigDecimal l = new BigDecimal(numL.divide(sumFrec, DECIMALS, RoundingMode.HALF_UP)+"");
				BigDecimal h = new BigDecimal(numH.divide(sumFrec, DECIMALS, RoundingMode.HALF_UP)+"");
				
				numL = numL.subtract(numL);
				numL = numL.add(numH);
				
				//Si l < numDec < h
				if (numDec.compareTo(l) == 1 && h.compareTo(numDec) == 1) {
					
					mensaje = mensaje + caracteres.get(j);
					
					BigDecimal num = new BigDecimal(numDec.subtract(l)+"");
					BigDecimal den = new BigDecimal(h.subtract(l)+"");
					BigDecimal res = new BigDecimal(num.divide(den, DECIMALS, RoundingMode.HALF_UP)+"");
					
					numDec = numDec.subtract(numDec);
					numDec = numDec.add(res);					
					
					break;
				}
				
				
				
			}
		}
		System.out.println(mensaje);
		
	}

	private static void ejercicio1() {

		int longitud = cadena.length();
		ArrayList<Double> probabilidades = new ArrayList<Double>();

		//Meter en el array alfabeto toda la cadena cambiando saltos de linea por dos espacios.
		for (int i = 0; i < longitud; i++) {
			String letra = cadena.substring(i, i + 1);
			
			if (letra.equals("\n")) {
				letra = " ";
				alfabeto.add(letra);
			}
			alfabeto.add(letra);
		}
		
		//Meter los caracteres sin repetición al array caracteres
		for (int i = 0; i < alfabeto.size(); i++) {
			
			if (!caracteres.contains(alfabeto.get(i))) {
				caracteres.add(alfabeto.get(i));
			}
		}		

		//Calcular la frecuencia de cada caracter.
		for (int i = 0; i < caracteres.size(); i++) {
			int cont = 0;
			for (int j = 0; j < alfabeto.size(); j++) {
				if (caracteres.get(i).equals(alfabeto.get(j))) {
					cont++;
				}
			}
			frecuencias.add(cont);			
		}
		
		//Añadir al array probabilidades las probabilidades de cada caracter
		for (int i = 0; i < caracteres.size(); i++) {
			probabilidades.add((double)frecuencias.get(i)/(double)alfabeto.size());
		}
		
		
		
	}

}
