package pruebas;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import src.Cafetera;

class CafeteraTest {
	
	private Cafetera cafetera;

	//Pruebas de constructores
	/*
	  	La prueba de un constructor se resume en tres pasos:
		 - Carga de los datos correspondientes al caso de prueba.
		 - Invocación del constructor, con lo que se crea una instancia de la clase.
		 - Realización de las comparaciones sobre las propiedades del objeto instanciado utilizando para ello
		los métodos get. Básicamente para cada propiedad del objeto cuyo valor ha de ser verificado,
		se utiliza el método assertEquals que compara su valor con el valor con el que se invocó al
		constructor.
	 */
	@Test
	void testConstructorVacio() {
		cafetera = new Cafetera();
		
		assertEquals(1000, cafetera.getCapacidadMaxima());
		assertEquals(0, cafetera.getCantidadActual());
	}
	
	@Test
	void testConstructorCapacidad() {
		cafetera = new Cafetera(500);
		
		assertEquals(500, cafetera.getCapacidadMaxima());
		assertEquals(500, cafetera.getCantidadActual());
	}
	
	@Test
	void testConstructorCapacidadMayorQueCantidad() {
		cafetera = new Cafetera(500, 30);
		
		assertEquals(500, cafetera.getCapacidadMaxima());
		assertEquals(30, cafetera.getCantidadActual());
	}
	
	@Test
	void testConstructorCapacidadMenorQueCantidadCantidad() {
		cafetera = new Cafetera(500, 1000);
		
		assertEquals(500, cafetera.getCapacidadMaxima());
		assertEquals(500, cafetera.getCantidadActual());
	}

	
	//Pruebas de metodos get y set
	/*
		Pasos para probar, mediante técnica de Caja Negra, una pareja de métodos get() y set()
		 - Se invoca el constructor para crear una instancia de la clase.
		 - Se almacena un valor en la propiedad usando el método set(…)
		 - Se obtiene el valor de la propiedad/atributo asignada usando el método get correspondiente.
		 - Se comprueba que el valor almacenado del atributo con el método set y el obtenido con el método get
		son iguales a través de assertEquals(…)
	 */
	/**
	 * Test donde comprobamos que la capacidad máxima 
	 * se actualiza correctamente haciendo uso de los 
	 * correspondientes get y set
	 */
	@Test
	void testGetSetCapacidadMaxima() {
		cafetera = new Cafetera();
		cafetera.setCapacidadMaxima(10);
		
		assertEquals(10, cafetera.getCapacidadMaxima());
	}
	
	/**
	 * Test donde comprobamos que en la cantidad
	 * actual se actualiza correctamente haciendo
	 * uso de los correspondientes get y set
	 */
	@Test
	void testGetSetCantidad() {
		cafetera = new Cafetera(1000);
		cafetera.setCantidadActual(0);
		
		assertEquals(0, cafetera.getCantidadActual());
	}
	
	/**
	 * Test donde que no se permite establecer una
	 * cantidad mayot que la capacidad de la cafetera
	 */
	@Test
	void testGetSetCantidadMayorQueCapacidad() {
		cafetera = new Cafetera(100);
		cafetera.setCantidadActual(100000);
		
		assertEquals(100, cafetera.getCantidadActual());
	}
	
	
	//Pruebas del resto de metodos
	/*
	 	El más complejo es servirTaza(int cc). Aplicamos la técnica de Caja Blanca. Crea el grafo de flujo para este
		método y define casos de prueba para cada uno de los caminos básicos.
	 */
	/**
	 * Método donde comprobamos que la cafetera se llena hasta el 
	 * maximo de capacidad cuando se llama al método correspondiente
	 */
	@Test
	void testLlenarCafetera() {
		cafetera = new Cafetera();
		assertEquals(0, cafetera.getCantidadActual());
		
		cafetera.llenarCafetera();
		assertEquals(cafetera.getCapacidadMaxima(), cafetera.getCantidadActual());
	}
	/**
	 * Método donde comprobamos que la cafetera se vacia completamente 
	 * cuando se llama al método correspondiente
	 */
	@Test
	void testVaciarCafetera() {
		cafetera = new Cafetera(1000);
		assertEquals(1000, cafetera.getCantidadActual());
		
		cafetera.vaciarCafetera();
		assertEquals(0, cafetera.getCantidadActual());
	}
	/**
	 * Método donde comprobamos que la cafetera añade a sus 
	 * reservas el cafe que especificamos en el metodo de
	 * agregar cafe
	 */
	@Test
	void testAgregarCafe() {
		cafetera = new Cafetera(1000,50);
		cafetera.agregarCafe(100);
		assertEquals(150, cafetera.getCantidadActual());
	}
	/**
	 * Método donde comprobamos que la cafetera añade a sus 
	 * reservas el cafe que especificamos en el metodo de
	 * agregar cafe pero que no llega a superar nunca el
	 * limite de capacidad de la cafetera
	 */
	@Test
	void testAgregarCafePorEncimaDelMaximo() {
		cafetera = new Cafetera(1000,50);
		cafetera.agregarCafe(cafetera.getCapacidadMaxima()*2);
		assertEquals(cafetera.getCapacidadMaxima(), cafetera.getCantidadActual());
	}
	
	//Test Servir cafe
	/**
	 * Metodo que comprueba el primer camino 
	 * 1-2-3-6
	 * Tenemos cafe suficiente para servir la taza
	 * la taza se sirve correctamente
	 * El valor de cafe actual cambia adecuadamente
	 */
	@Test
	void testServirTaza() {
		cafetera = new Cafetera(100);
		int cantidadActual =  cafetera.getCantidadActual();
		int taza = cafetera.servirTaza(30);
		
		assertEquals(30, taza);
		assertEquals(cantidadActual-taza, cafetera.getCantidadActual());
	}
	
	/**
	 * Metodo que comprueba el segundo camino 
	 * 1-2-4-6
	 * Tenemos algo de cafe en la cafetera pero no lo 
	 * suficiente para llenar la taza en su totalidad
	 * La taza devuelve el sobrante de cafe y la cantidad 
	 * actual se queda a 0
	 */
	@Test
	void testServirTazaAMedias() {
		cafetera = new Cafetera(100);
		int taza = cafetera.servirTaza(150);
		
		assertEquals(100, taza);
		assertEquals(0, cafetera.getCantidadActual());
	}
	
	/**
	 * Metodo que comprueba el tercer camino 
	 * 1-5-6
	 * No tenemos nada de cafe en la cafetera
	 * La taza devuelve 0 y la cantidad de la 
	 * cafetera se mantiene a 0
	 */
	@Test
	void testServirTazaSinCafe() {
		cafetera = new Cafetera(100, 0);
		int taza = cafetera.servirTaza(30);
		
		assertEquals(0, taza);
		assertEquals(0, cafetera.getCantidadActual());
	}
}
