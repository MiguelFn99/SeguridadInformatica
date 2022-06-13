package unileon;

import java.math.BigInteger;
import java.util.ArrayList;

public class Principal {

	static String alf = "¡!AÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZaábcdeéfghiíjklmnñoópqrstuúvwxyz0123456789 (),.";

	static String claveCifrado = "estrofa 2";
	static String mensajeCifrado = "iGUÍQbAVnv¡ZzepsÓYmékdTPyt5aC¡8ñoctSÚq7.3ñfv4ÓhéFrBKrXÉOúq¡pw)EñVfÍmMó3wpxÑiYlIYcx)ÚYÚ4f1át8eFÑDMIkrhí5ebí¡u.UHt0R2y";

	public static void main(String[] args) {

		varianteVigenere(alf, claveCifrado, mensajeCifrado);

		//RSAPorBloques(mensajeCifrado);

	}

	private static void RSAPorBloques(String mensajeCifrado) {

		// Pepa
		BigInteger n = new BigInteger("62439738695706104201747");
		BigInteger e = new BigInteger("356812573");
		BigInteger factN = new BigInteger("249879448303");
		BigInteger cdot = new BigInteger("249879448349");
//		double n = 62439738695706104201747.0;
//		double e = 356812573.0;
//		double factN = 249879448303.0;
//		double cdot = 249879448349.0;

		int N = alf.length();

		// Obtener bloques
		int k = 0;
		BigInteger compSup = new BigInteger(String.format("%.0f", Math.pow(N, k)));
		while (n.compareTo(compSup) == 1) {
			compSup = compSup.subtract(compSup);
			BigInteger aux = new BigInteger(String.format("%.0f", Math.pow(N, k++)));
			compSup = compSup.add(aux);
		}

		// Paso 1
		// Pasar de bloque a número
		ArrayList<Character> bloqueStr = new ArrayList<Character>();
		ArrayList<Integer> bloqueInt = new ArrayList<Integer>();
		BigInteger enteroCifrado = new BigInteger("0");
		for (int i = 0; i < k; i++) {
			bloqueStr.add(mensajeCifrado.charAt(i));
			bloqueInt.add(alf.indexOf(bloqueStr.get(i)));
			BigInteger aux = new BigInteger(bloqueInt.get(i) * N + "");
			enteroCifrado = enteroCifrado.add(aux);
		}

		// Paso 2
		// Calcula clave privada
		// factorizar(n);
		// Con máxima sacar los factores de n. ifactors(n);
		ArrayList<BigInteger> factores = new ArrayList<BigInteger>();
		factores.add(new BigInteger("249879448303"));
		factores.add(new BigInteger("249879448349"));

		BigInteger phiN = new BigInteger("1");
		for (int i = 0; i < factores.size(); i++) {
			BigInteger aux = new BigInteger(factores.get(i) + "");
			BigInteger uno = new BigInteger("1");
			aux = aux.subtract(uno);

			factores.set(i, aux);

			phiN = phiN.multiply(factores.get(i));
		}

	}

	private static void varianteVigenere(String alf, String claveCifrado, String mensajeCifrado) {

		int n = alf.length();

		ArrayList<Integer> minuendo = new ArrayList<Integer>();
		for (int i = 0; i < mensajeCifrado.length(); i++) {
			int index = alf.indexOf(mensajeCifrado.charAt(i));
			minuendo.add(index);
		}

		ArrayList<Integer> sustraendo = new ArrayList<Integer>();
		for (int i = 0; i < claveCifrado.length(); i++) {
			int index = alf.indexOf(claveCifrado.charAt(i));
			sustraendo.add(index);
		}
		for (int i = claveCifrado.length(); i < mensajeCifrado.length(); i++) {
			int aux = 0;
			for (int j = 0; j < claveCifrado.length(); j++) {
				aux = aux + (sustraendo.get(j) * sustraendo.get(i - j - 1));
				aux = Math.floorMod(aux, n);
			}
			sustraendo.add(aux);
		}

		String mensaje = "";
		for (int i = 0; i < mensajeCifrado.length(); i++) {
			int auxI = minuendo.get(i) - sustraendo.get(i);
			auxI = Math.floorMod(auxI, n);
			char auxC = alf.charAt(auxI);

			if (i < mensajeCifrado.length() - 1) {
				int sigI = Math.floorMod(minuendo.get(i + 1) - sustraendo.get(i + 1), n);
				int sigC = alf.charAt(sigI);
				if (auxC == ' ' && sigC == ' ') {
					auxC = '\n';
					i++;
				}
			}
			mensaje = mensaje + auxC;
		}
		System.out.println(mensaje);
	}
	
	public static long[] euclidesExtendido(long a, long b) {
		long[] resp = new long[3];
		long x = 0, y = 0, d = 0;
		if (b == 0) {
			resp[0] = a;
			resp[1] = 1;
			resp[2] = 0;
		} else {
			long x2 = 1, x1 = 0, y2 = 0, y1 = 1;
			long q = 0, r = 0;
			while (b > 0) {
				q = (a / b);
				r = a - q * b;
				x = x2 - q * x1;
				y = y2 - q * y1;
				a = b;
				b = r;
				x2 = x1;
				x1 = x;
				y2 = y1;
				y1 = y;
			}
			resp[0] = a;
			resp[1] = x2;
			resp[2] = y2;
		}
		return resp;
	}

}
