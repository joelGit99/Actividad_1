package Clases;

import java.text.DecimalFormat;

import Herencias.Lavadora;
import Herencias.Television;

public class UD9App {
	public static final DecimalFormat DF = new DecimalFormat("##.##");
	
	public static void main(String[] args) {
		
		// Creo electrodomésticos y pruebo
		Electrodomestico elec1 = new Electrodomestico();
		System.out.println(elec1);
		
		Electrodomestico elec2 = new Electrodomestico(250.62, 125.14);
		System.out.println(elec2);
		elec2.precioFinal();
		System.out.println(elec2.getPrecioBase());
		
		Electrodomestico elec3 = new Electrodomestico(500.12, "gris", 'B', 400.23);
		System.out.println(elec3);
		elec3.precioFinal();
		System.out.println(elec3.getPrecioBase());
		
		Lavadora lavadora1 = new Lavadora(349.99, 50);
		System.out.println(lavadora1);
		System.out.println(lavadora1.getCARGA());
		
		Lavadora lavadora2 = new Lavadora(300.15, 600.3);
		System.out.println(lavadora2);
		
		Lavadora lavadora3 = new Lavadora(265.17, "blanco", 'D', 300.14, 50.2);
		System.out.println(lavadora3);
		
		Television tv1 = new Television();
		System.out.println(tv1);
		
		Television tv2 = new Television(1000, 90);
		System.out.println(tv2);
		
		Television tv3 = new Television(1200, "Negro", 'C', 96.5, 60, true);
		System.out.println(tv3);
		
		// Creo un array de electrodomésticos, y a cada posición asigno una lavadora o televisión
		Electrodomestico[] arrayElectrodomesticos = new Electrodomestico[10];
		rellenarArray(arrayElectrodomesticos);
		recorrerArray(arrayElectrodomesticos);
	}
	
	// Método para rellenar el array
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
	
	// Método que recorre el array de electrodomésticos, muestra por grupos de lavadoras y televisiones
	// y muestra también el precio de cada uno, y la suma de todos
	private static void recorrerArray(Electrodomestico[] arrayElectrodomesticos) {
		double sumaPrecio = 0;
		double sumaLavadoras = 0;
		double sumaTV = 0;
		double sumaElec = 0;
		for (int i = 0; i < arrayElectrodomesticos.length; i++) {
			if(arrayElectrodomesticos[i] instanceof Lavadora) {
				System.out.println("Televisión " + i + ": " + DF.format(arrayElectrodomesticos[i].precioFinal()) + "€");
				sumaLavadoras += arrayElectrodomesticos[i].precioFinal();
			} else if(arrayElectrodomesticos[i] instanceof Television) {
				System.out.println("Lavadora " + i + ": " + DF.format(arrayElectrodomesticos[i].precioFinal()) + "€");
				sumaTV += arrayElectrodomesticos[i].precioFinal();
			} else {
				System.out.println("Electrodoméstico " + i + ": " + DF.format(arrayElectrodomesticos[i].precioFinal()) + "€");
				sumaElec += arrayElectrodomesticos[i].precioFinal();
			}
		}
		System.out.println("El total de las lavadoras es: " + sumaLavadoras);
		System.out.println("El total de las TV es: " + sumaTV);
		System.out.println("El total de los electrodomésticos es: " + sumaElec);
		sumaPrecio = sumaLavadoras + sumaTV + sumaElec;
		System.out.println("En total son " + DF.format(sumaPrecio) + "€");
	}
}