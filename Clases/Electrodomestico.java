package Clases;
import java.text.DecimalFormat;

/**
 * Clase para crear electrodomésticos
 * @author Joel, Marius, Jose Luis
 *
 */

public class Electrodomestico {
	//Constantes para los valores por defecto
	protected final String COLOR = "blanco";
	protected final int PRECIOBASE = 100;
	protected final char CONSENERGETICO = 'F';
	protected final int PESO = 5;
	
	// Atributos
	protected double precioBase;
	protected String color;
	protected char consEnergetico;
	protected double peso;
	
	public static final DecimalFormat DF = new DecimalFormat("##.##");
	// Constructores
	public Electrodomestico() {
		this.precioBase = PRECIOBASE;
		this.color = COLOR;
		this.consEnergetico = CONSENERGETICO;
		this.peso = PESO;
	}
	public Electrodomestico(double precioBase, double peso) {
		this.precioBase = precioBase;
		this.peso = peso;
		this.color = COLOR;
		this.consEnergetico = CONSENERGETICO;
	}
	public Electrodomestico(double precioBase, String color, char consEnergetico, double peso) {
		this.precioBase = precioBase;
		// Compruebo si el color está en la lista o no,
		// si lo está, se asigna dicho valor, sino, se pone otro por defecto
		if(comprobarColor(color)) {
			this.color = color;
		} else {
			this.color = COLOR;
		}
		// Compruebo si el consumo energético está entre A y F
		// si lo está, se asigna, sino, se asigna el por defecto
		if(comprobarConsumoEnergetico(consEnergetico)) {
			this.consEnergetico = consEnergetico;
		} else {
			this.consEnergetico = CONSENERGETICO;
		}
		this.peso = peso;
	}
	
	// Métodos
	
	// Método que devuelve true o false, dependiendo de si el consumo energético
	// está entre A y F
	private boolean comprobarConsumoEnergetico(char letra) {
		if(letra >= 'A' && letra <= 'F') {
			return true;
		} else {
			return false;
		}
	}
	
	// Método que devuelve true o false, dependiendo de si el color está
	// entre la lista
	private boolean comprobarColor(String color) {
		if(color.equalsIgnoreCase("blanco") || 
				color.equalsIgnoreCase("Negro") ||
				color.equalsIgnoreCase("Rojo") ||
				color.equalsIgnoreCase("Azul") ||
				color.equalsIgnoreCase("Gris")) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Método que suma el precio dependiendo del consumo energético
	 * y del peso
	 * @return double
	 */
	public double precioFinal() {
		switch(this.consEnergetico) {
		case 'A':
			this.precioBase += 100;
			break;
		case 'B':
			this.precioBase += 80;
			break;
		case 'C':
			this.precioBase += 60;
			break;
		case 'D':
			this.precioBase += 50;
			break;
		case 'E':
			this.precioBase += 30;
			break;
		default :
			this.precioBase += 10;
		}
		
		if(this.peso >= 0 && this.peso <= 19) {
			this.precioBase += 10;
		} else if(this.peso >= 20 && this.peso <= 49) {
			this.precioBase += 50;
		} else if(this.peso >= 50 && this.peso <= 79) {
			this.precioBase += 80;
		} else if(this.peso > 80) {
			this.precioBase += 100;
		}
		
		return this.precioBase;
			
	}
	
	@Override
	public String toString() {
		return "Electrodomestico [PRECIO BASE=" + DF.format(precioBase) + "€" + ", COLOR=" + color + ", CONSUMO ENERGÉTICO=" + consEnergetico
				+ ", PESO=" + peso + "kg" + "]";
	}
	// Getters
	public double getPrecioBase() {
		return precioBase;
	}
	public String getColor() {
		return color;
	}
	public char getConsEnergetico() {
		return consEnergetico;
	}
	public double getPeso() {
		return peso;
	}
}