package Herencias;

import java.text.DecimalFormat;
/**
 * Clase para crear lavadoras
 * @author Joel, Jose Luis y Marius
 *
 */

public class Lavadora extends Clases.Electrodomestico {
	// Métodos
	private final double CARGA;
	private final DecimalFormat DF = Clases.Electrodomestico.DF;
	
	// Constructores
	public Lavadora() {
		this.CARGA = 5;
	}

	public Lavadora(double precioBase, double peso) {
		super(precioBase, peso);
		this.CARGA = 5;
	}

	public Lavadora(double precioBase, String color, char consEnergetico, double peso, double carga) {
		super(precioBase, color, consEnergetico, peso);
		this.CARGA = carga;
	}
	
	// Métodos
	
	// Extiendo el método de las clase padre, y le añado la condición de
	// si la carga es mayor a 30, al precio se le suman 50
	public double precioFinal() {
        super.precioFinal();
        if (CARGA > 30) {
            PRECIOBASE += 50;
        }

        return PRECIOBASE;
    }
	
	
	@Override
	public String toString() {
		return "Lavadora [PRECIO BASE=" + DF.format(PRECIOBASE) + "€" + ", COLOR=" + COLOR + ", CONSUMO ENERGÉTICO=" + CONSENERGETICO
				+ ", PESO=" + PESO + "kg" + ", CARGA=" + CARGA + "]";
	}

	// Getters y setters
	public double getCARGA() {
		return CARGA;
	}

	
}
