package unileon;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {

		String cadena = "aaaaaaaaaaaaabb";
		int longitud = cadena.length();
		ArrayList<String> alfabeto = new ArrayList<String>();
		ArrayList<String> caracteres = new ArrayList<String>();
		ArrayList<Integer> frecuencias = new ArrayList<Integer>();
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
		
		
		//Cálculo de la entropía
		double total = alfabeto.size();
		double sumatorio = 0;
		for (int i = 0; i < caracteres.size(); i++) {
			sumatorio = sumatorio + (frecuencias.get(i) * Math.log(frecuencias.get(i)));
		}
		double entropia = (1/Math.log(2)) * (Math.log(total) - ((1/total) * sumatorio));
		System.out.println("La entropía es: " + entropia);
		
	
		
		
		//Ordenar de mayor a menor frecuencia.
		for(int i = 0; i < (probabilidades.size()-1); i++){		
            for(int j = i+1; j < probabilidades.size(); j++){
            	if (probabilidades.get(i) < probabilidades.get(j)) {
            		
            		String auxCar = caracteres.get(i);
            		int auxFre = frecuencias.get(i);
            		double auxPro = probabilidades.get(i);
            		
            		caracteres.set(i, caracteres.get(j));
            		caracteres.set(j, auxCar);
            		
            		frecuencias.set(i, frecuencias.get(j));
            		frecuencias.set(j, auxFre);
            		
            		probabilidades.set(i, probabilidades.get(j));
            		probabilidades.set(j, auxPro);
            	}
            	
            }
		}
		
		//Imprime caracteres, frecuencia y probabilidad
		for (int i = 0; i < caracteres.size(); i++) {
//			System.out.print("Caracter: " + caracteres.get(i));
//			System.out.print(" |Frecuencia: " + frecuencias.get(i));
//			System.out.println(" |Probabilidad: " + probabilidades.get(i));
//			System.out.print(", " + frecuencias.get(i));
		}
		
		
		System.out.print("{");
		for (int i = 0; i < caracteres.size(); i++) {
			System.out.print("'"+ caracteres.get(i) +"', ");
		}
		System.out.print("}\n");
		
		System.out.print("{");
		for (int i = 0; i < caracteres.size(); i++) {
			System.out.print(frecuencias.get(i) +", ");
		}
		System.out.print("}\n");
		
		//Imprime el caracter, la frecuencia y la probabilidad del caracter que desees.
//		for (int i = 0; i < caracteres.size(); i++) {
//			if (caracteres.get(i).equals("b")) {
//				System.out.print("Caracter: " + caracteres.get(i));
//				System.out.print(" |Frecuencia: " + frecuencias.get(i));
//				System.out.println(" |Probabilidad: " + probabilidades.get(i));
//			}
//		}
		
		

	}

}
