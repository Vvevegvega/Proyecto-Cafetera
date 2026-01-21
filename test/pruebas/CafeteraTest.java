package pruebas;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Cafetera;

class CafeteraTest {


	private Cafetera cafetera;
	
	@BeforeEach
	void crearCafetera() {
		cafetera = new Cafetera();
	}

	//Pruebas de constructores
	/*
	  	La prueba de un constructor se resume en tres pasos:
		 Carga de los datos correspondientes al caso de prueba.
		 Invocación del constructor, con lo que se crea una instancia de la clase.
		 Realización de las comparaciones sobre las propiedades del objeto instanciado utilizando para ello
		los métodos get. Básicamente para cada propiedad del objeto cuyo valor ha de ser verificado,
		se utiliza el método assertEquals que compara su valor con el valor con el que se invocó al
		constructor.
	 */
	@Test
	void testConstructorVacio() {
		cafetera = new Cafetera();
		
		assertEquals(0, cafetera.getCantidadActual());
		assertEquals(1000, cafetera.getCapacidadMaxima());
	}
	
	@Test
	void testConstructorConCapacidad() {
		cafetera = new Cafetera(500);
		
		assertEquals(0, cafetera.getCantidadActual());
		assertEquals(500, cafetera.getCapacidadMaxima());
	}
	
	@Test
	void testConstructorConCapacidadYCantidadl() {
		cafetera = new Cafetera(500, 30);
		
		assertEquals(30, cafetera.getCantidadActual());
		assertEquals(500, cafetera.getCapacidadMaxima());
	}

	
	//Pruebas de metodos get y set
	/*
		Pasos para probar, mediante técnica de Caja Negra, una pareja de métodos get() y set()
		 Se invoca el constructor para crear una instancia de la clase.
		 Se almacena un valor en la propiedad usando el método set(…)
		 Se obtiene el valor de la propiedad/atributo asignada usando el método get correspondiente.
		 Se comprueba que el valor almacenado del atributo con el método set y el obtenido con el método get
		son iguales a través de assertEquals(…)
	 */
	@Test
	void testGet() {
		cafetera = new Cafetera(500, 30);
		
		assertEquals(30, cafetera.getCantidadActual());
		assertEquals(500, cafetera.getCapacidadMaxima());
	}
	
	//Pruebas del resto de metodos
	/*
	 	El más complejo es servirTaza(int cc). Aplicamos la técnica de Caja Blanca. Crea el grafo de flujo para este
		método y define casos de prueba para cada uno de los caminos básicos.
	 */
}
