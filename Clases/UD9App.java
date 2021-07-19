package Clases;

import java.text.DecimalFormat;

import Herencias.Lavadora;
import Herencias.Television;

/**
 * Clase main
 * 
 * @author Joel, Marius, Jose Luis
 *
 */
public class UD9App {
	public static final DecimalFormat DF = new DecimalFormat("##.##");

	public static void main(String[] args) {
		// Creo un array de electrodomesticos, y a cada posicion asigno una lavadora o
		// television
		Electrodomestico[] arrayElectrodomesticos = new Electrodomestico[10];
		rellenarArray(arrayElectrodomesticos);
		recorrerArray(arrayElectrodomesticos);
	}

	// Metodo para rellenar el array
	private static void rellenarArray(Electrodomestico[] arrayElectrodomesticos) {
		arrayElectrodomesticos[0] = new Television(1000, "Azul", 'F', 85.2, 55, true);
		arrayElectrodomesticos[1] = new Television(957, "Negro", 'A', 75.2, 50, false);
		arrayElectrodomesticos[2] = new Television(800, "Rojo", 'D', 76.6, 50, true);
		arrayElectrodomesticos[3] = new Television(899, "Blanco", 'D', 85.2, 55, true);
		arrayElectrodomesticos[4] = new Television(978.99, "Azul", 'F', 87.2, 45, false);
		arrayElectrodomesticos[5] = new Lavadora(458.23, "Blanco", 'B', 500, 40);
		arrayElectrodomesticos[6] = new Lavadora(369.24, "Blanco", 'F', 326, 57);
		arrayElectrodomesticos[7] = new Electrodomestico(263, "Rojo", 'B', 50);
		arrayElectrodomesticos[8] = new Lavadora(289.5, "Blanco", 'B', 450, 56);
		arrayElectrodomesticos[9] = new Lavadora(500.2, "Blanco", 'A', 326, 66);
	}

	// Metodo que recorre el array de electrodomesticos, muestra por grupos de
	// lavadoras y televisiones
	// y muestra tambien el precio de cada uno, y la suma de todos
	private static void recorrerArray(Electrodomestico[] arrayElectrodomesticos) {
		double sumaPrecio = 0;
		double sumaLavadoras = 0;
		double sumaTV = 0;
		double sumaElec = 0;
		for (int i = 0; i < arrayElectrodomesticos.length; i++) {
			if (arrayElectrodomesticos[i] instanceof Television) {
				System.out.println("Television " + i + ": " + DF.format(arrayElectrodomesticos[i].precioFinal()) + "€");
				sumaTv += arrayElectrodomesticos[i].precioFinal();
			} else if (arrayElectrodomesticos[i] instanceof Lavadora) {
				System.out.println("Lavadora " + i + ": " + DF.format(arrayElectrodomesticos[i].precioFinal()) + "€");
				sumaLavadoras += arrayElectrodomesticos[i].precioFinal();
			} else {
				System.out.println(
						"Electrodomestico " + i + ": " + DF.format(arrayElectrodomesticos[i].precioFinal()) + "€");
				sumaElec += arrayElectrodomesticos[i].precioFinal();
			}
		}
		System.out.println("El total de las lavadoras es: " + DF.format(sumaLavadoras) + "€");
		System.out.println("El total de las TV es: " + DF.format(sumaTV) + "€");
		System.out.println("El total de los electrodomesticos es: " + DF.format(sumaElec) + "€");
		sumaPrecio = sumaLavadoras + sumaTV + sumaElec;
		System.out.println("En total son " + DF.format(sumaPrecio) + "€");
	}
}
