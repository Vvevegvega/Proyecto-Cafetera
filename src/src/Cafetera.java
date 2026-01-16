package src;

public class Cafetera {
	private int capacidadMaxima;
	private int cantidadActual;

	//CONSTRUCTORES
	public Cafetera() {
		this(1000, 0);
	}

	public Cafetera(int capacidadMaxima) {
		this(capacidadMaxima, capacidadMaxima);
	}

	public Cafetera(int capacidadMaxima, int cantidadActual) {
		this.capacidadMaxima = capacidadMaxima;
		this.cantidadActual = 
			cantidadActual > capacidadMaxima 
				? capacidadMaxima 
				: cantidadActual;
	}

	//GETTERS Y SETTERS
	public double getCantidadActual() {
		return this.cantidadActual;
	}
	public void setCantidadActual(int newCantidad) {
		this.cantidadActual = newCantidad;
	}
	public double getCapacidadMaxima() {
		return this.capacidadMaxima;
	}
	public void setCapacidadMaxima(int newCapacidad) {
		this.capacidadMaxima = newCapacidad;
	}
	
	//METODOS
	public void llenarCafetera() {
		 this.cantidadActual = this.capacidadMaxima;
	}
	
	public int servirTaza(int cc) {
		int servido = 0;
		if(cantidadActual== 0) {
			System.out.println("Lo sentimos, no queda café.");
			servido = 0;
		}else {
			if(cantidadActual <= cc) {
				System.out.println("Se ha servido todo lo que quedaba ("+cantidadActual+" c.c)");
				servido = cantidadActual;
				cantidadActual = 0;
			}else {
				servido = cc;
				cantidadActual -= cc;
				System.out.println("Todavía quedan "+cantidadActual + " c.c)");
			}
		}
		return servido;
	}
	
	public void vaciarCafetera() {
		this.cantidadActual = 0;
	}
	
	public void agregarCafe(int cc) {
		cantidadActual += cc;
	}
	
}
