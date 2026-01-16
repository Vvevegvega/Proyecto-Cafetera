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

	/**
	 * GIVEN: Una cuenta bancaria nueva y vacia
	 * WHEN: Se intenta ingresar una cantidad positiva
	 * THEN: El saldo se incrementa adecuadamente
	 */
	@Test
	void testIngresarCuentaVacia() {
		
	}

}
