package Clases;
import java.text.DecimalFormat;

/**
 * Clase para crear electrodomésticos
 * @author Joel
 *
 */

public class Electrodomestico {
	// Atributos
	protected double PRECIOBASE;
	protected final String COLOR;
	protected final char CONSENERGETICO;
	protected final double PESO;
	public static final DecimalFormat DF = new DecimalFormat("##.##");
	// Constructores
	public Electrodomestico() {
		this.PRECIOBASE = 100;
		this.COLOR = UD9App.COLOR;
		this.CONSENERGETICO = 'F';
		this.PESO = 5;
	}
	public Electrodomestico(double precioBase, double peso) {
		this.PRECIOBASE = precioBase;
		this.PESO = peso;
		this.COLOR = UD9App.COLOR;
		this.CONSENERGETICO = 'F';
	}
	public Electrodomestico(double precioBase, String color, char consEnergetico, double peso) {
		this.PRECIOBASE = precioBase;
		// Compruebo si el color está en la lista o no,
		// si lo está, se asigna dicho valor, sino, se pone otro por defecto
		if(comprobarColor(color)) {
			this.COLOR = color;
		} else {
			this.COLOR = UD9App.COLOR;
		}
		// Compruebo si el consumo energético está entre A y F
		// si lo está, se asigna, sino, se asigna el por defecto
		if(comprobarConsumoEnergetico(consEnergetico)) {
			this.CONSENERGETICO = consEnergetico;
		} else {
			this.CONSENERGETICO = 'F';
		}
		this.PESO = peso;
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
		if(color.equalsIgnoreCase(UD9App.COLOR) || 
				color.equalsIgnoreCase(UD9App.COLOR2) ||
				color.equalsIgnoreCase(UD9App.COLOR3) ||
				color.equalsIgnoreCase(UD9App.COLOR4) ||
				color.equalsIgnoreCase(UD9App.COLOR5)) {
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
		switch(this.CONSENERGETICO) {
		case 'A':
			this.PRECIOBASE += 100;
			break;
		case 'B':
			this.PRECIOBASE += 80;
			break;
		case 'C':
			this.PRECIOBASE += 60;
			break;
		case 'D':
			this.PRECIOBASE += 50;
			break;
		case 'E':
			this.PRECIOBASE += 30;
			break;
		default :
			this.PRECIOBASE += 10;
		}
		
		if(this.PESO >= 0 && this.PESO <= 19) {
			this.PRECIOBASE += 10;
		} else if(this.PESO >= 20 && this.PESO <= 49) {
			this.PRECIOBASE += 50;
		} else if(this.PESO >= 50 && this.PESO <= 79) {
			this.PRECIOBASE += 80;
		} else if(this.PESO > 80) {
			this.PRECIOBASE += 100;
		}
		
		return this.PRECIOBASE;
			
	}
	
	@Override
	public String toString() {
		return "Electrodomestico [PRECIO BASE=" + DF.format(PRECIOBASE) + "€" + ", COLOR=" + COLOR + ", CONSUMO ENERGÉTICO=" + CONSENERGETICO
				+ ", PESO=" + PESO + "kg" + "]";
	}
	// Getters
	public double getPRECIOBASE() {
		return PRECIOBASE;
	}
	public String getCOLOR() {
		return COLOR;
	}
	public char getCONSENERGETICO() {
		return CONSENERGETICO;
	}
	public double getPESO() {
		return PESO;
	}
	
}
