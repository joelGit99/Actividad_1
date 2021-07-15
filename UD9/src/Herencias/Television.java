package Herencias;
/**
 * Clase para crear televisiones
 * @author Joel
 *
 */
public class Television extends Clases.Electrodomestico {
	// Atributos
	private int resolucion;
	private boolean sintonizadorTDT;
	// Constructores
	public Television() {
		this.resolucion = 20;
		this.sintonizadorTDT = false;
	}
	public Television(double precioBase, double peso) {
		super(precioBase, peso);
		this.resolucion = 20;
		this.sintonizadorTDT = false;
		PRECIOBASE = precioFinal();
	}
	public Television(double precioBase, String color, char consEnergetico, double peso, int resolucion, boolean sintonizadorTDT) {
		super(precioBase, color, consEnergetico, peso);
		this.resolucion = resolucion;
		this.sintonizadorTDT = sintonizadorTDT;
		PRECIOBASE = precioFinal();
	}
	
	// Métodos
	public double precioFinal() {
		PRECIOBASE = super.precioFinal();
		if(resolucion > 40) {
			PRECIOBASE = PRECIOBASE + (PRECIOBASE * 0.3);
		}
		if(sintonizadorTDT) {
			PRECIOBASE += 50;
		}
		return PRECIOBASE;
	}
	@Override
	public String toString() {
		if(sintonizadorTDT) {
			return "Televisión [PRECIO BASE=" + DF.format(PRECIOBASE) + "€" + ", COLOR=" + COLOR + ", CONSUMO ENERGÉTICO=" + CONSENERGETICO
					+ ", PESO=" + PESO + "kg" + ", RESOLUCIÓN=" + resolucion + " pulgadas" + ", SINTONIZADOR TDT=" + "Sí" + "]";
		} else {
			return "Televisión [PRECIO BASE=" + DF.format(PRECIOBASE) + "€" + ", COLOR=" + COLOR + ", CONSUMO ENERGÉTICO=" + CONSENERGETICO
					+ ", PESO=" + PESO + "kg" + ", RESOLUCIÓN=" + resolucion + " pulgadas" + ", SINTONIZADOR TDT=" + "No" + "]";
		}
		
	}
	// Getters y setters
	public int getResolucion() {
		return resolucion;
	}
	public boolean isSintonizadorTDT() {
		return sintonizadorTDT;
	}
	
}
