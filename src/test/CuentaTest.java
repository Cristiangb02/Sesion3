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

		cuenta = new Cuenta(0d, "00000");
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
	    boolean seCumple = true; 

	    cuenta1.retirar(200d);
	    System.out.println("Saldo cuenta1 tras retirar 200€: " + cuenta1.getSaldo());  
	    seCumple = seCumple && cuenta1.getSaldo() == -150;
	    
	    cuenta2.retirar(350d);
	    System.out.println("Saldo cuenta2 tras retirar 350€: " + cuenta2.getSaldo());  
	    seCumple = seCumple && cuenta2.getSaldo() == -350;
	    
	    cuenta1.ingresar(100d);
	    System.out.println("Saldo cuenta1 tras ingresar 100€: " + cuenta1.getSaldo());  
	    seCumple = seCumple && cuenta1.getSaldo() == -50;
	    
	    cuenta2.retirar(200d);
	    System.out.println("Saldo cuenta2 tras intentar retirar 200€: " + cuenta2.getSaldo());  
	    seCumple = seCumple && cuenta2.getSaldo() == -350;  

	    cuenta2.retirar(150d);
	    System.out.println("Saldo cuenta2 tras intentar retirar 150€: " + cuenta2.getSaldo());  
	    seCumple = seCumple && cuenta2.getSaldo() == -500;  

	    cuenta1.retirar(250d);
	    System.out.println("Saldo cuenta1 tras retirar 250€: " + cuenta1.getSaldo());  
	    seCumple = seCumple && cuenta1.getSaldo() == -300;  

	    cuenta2.ingresar(50d);
	    System.out.println("Saldo cuenta2 tras ingresar 50€: " + cuenta2.getSaldo());  
	    seCumple = seCumple && cuenta2.getSaldo() == -450;

	    cuenta2.retirar(100d);
	    System.out.println("Saldo cuenta2 tras intentar retirar 100€: " + cuenta2.getSaldo());  
	    seCumple = seCumple && cuenta2.getSaldo() == -450;  

	    seCumple = seCumple && cuenta1.getSaldo() == -300 && cuenta2.getSaldo() == -450;

	    assertTrue(seCumple); 
	}

}
