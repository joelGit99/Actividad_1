package Herencias;
/**
 * Clase para crear televisiones
 * @author Team 6 Joel, Marius y Jose Luis
 *
 */
public class Television extends Clases.Electrodomestico {
	// Declaramos los atributos resolucion y sintonizador que solo seran de Television.
	private int resolucion;
	private boolean sintonizadorTDT;
	/** Crearemos 3 constructores
	* El primero contructor con todos los atributos por defecto.
	* El segundo contructor con los atributos precio y peso asignados y los demas atributos seran por defecto.
	* El tercer constructor con todos los atributos asignados.
	*/
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
	
	// El Método precioFinal y ejecutara un if para resolucion y sintonizadorTDT, si las condiciones se cumplen añadira un precio extra al producto.
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
	//Hacemos un toString.
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
	// Generamos los Getters.
	public int getResolucion() {
		return resolucion;
	}
	public boolean isSintonizadorTDT() {
		return sintonizadorTDT;
	}
	
}
