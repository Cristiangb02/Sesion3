package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Cuenta;

class CuentaTest {
	
	static Cuenta cuenta;
	Cuenta cuenta1, cuenta2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		cuenta1 = new Cuenta(50d, "12345");
		cuenta2 = new Cuenta(0d, "67890");

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIngresar() {
		
		cuenta.ingresar(500);
		assertEquals(500, cuenta.getSaldo());
		
	}
	
	@Test
	void testRetirar() {
		
		cuenta.retirar(500);
		assertEquals(-500, cuenta.getSaldo());
		
	}
	
	@Test
	void test0014() {
		
		cuenta1.retirar(200);
		cuenta2.retirar(350);
		cuenta1.ingresar(100);
		cuenta2.retirar(200);
		cuenta2.retirar(150);
		cuenta1.retirar(250);
		cuenta2.ingresar(50);
		cuenta2.retirar(100);
		
		System.out.println("La cuenta 12345 tiene " + cuenta1.getSaldo() + " euros.");
		System.out.println("La cuenta 67890 tiene " + cuenta2.getSaldo() + " euros.");		
		
		assertEquals(-250, cuenta1.getSaldo());
		assertEquals(-450, cuenta2.getSaldo());
	}

}
