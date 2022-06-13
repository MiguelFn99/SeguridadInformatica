package unileon;

public class Principal {

	//Datos que se pueden modificar
	static int a = 79;
	static int b = 25;
	static String msjCifrado = "KdDWAá,ÚD7Aá(3Úá5ÚáR3YOÚ7ááEirXRWáKÁYXRWUhiWÁiWRáKÁYXRáWWral,aJyRaEDÉRaPjWDfjKDRaarfRF(éOU(iHFúf8 O8fU(Á";
	static String alf = "¡!AÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZaábcdeéfghiíjklmnñoópqrstuúvwxyz0123456789 (),.";
	
	//Longitud del alfabeto (módulo)
	static int n = alf.length();
	
	static String msj = "";

	public static void main(String[] args) {

		double linea = 1;

		int act = 0;
		int aux = act + 1;

		boolean fin = false;

		while (fin == false) {

			// Inverso de A
			int invA = (int) euclidesExtendido(n, a)[2];
			invA = (int) Math.pow(invA, linea);
			invA = Math.floorMod(invA, n);
			// Inverso de B
			int invB = Math.floorMod(-invA * b, n);
			invB = (int) (invB * linea);
			invB = Math.floorMod(invB, n);
			
			// Caracter actual
			int indAct = alf.indexOf(msjCifrado.charAt(act));
			char carAct = alf.charAt(Math.floorMod(invA * indAct + invB, n));
			act++;

			// Comprobar si el auxiliar no se ha pasado de longitud
			if (aux < msjCifrado.length()) {
				// Caracter siguiente
				int indSig = alf.indexOf(msjCifrado.charAt(aux));
				int carSig = alf.charAt(Math.floorMod(invA * indSig + invB, n));
				aux++;

				// Comprobar si hay doble espacio para el salto de linea
				if (carAct == ' ' && carSig == ' ') {
					carAct = '\n';
					act++;
					aux++;
					linea++;
					
					//Clave de cifrado y descifrado para cada linea
					System.out.println("Clave descifrado (" + invA + ", " + invB + ")");
				}
			}

			msj = msj + carAct;

			// Comprobar si es el final
			if (act == msjCifrado.length()) {
				fin = true;
			}

		}
		System.out.print(msj);

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
