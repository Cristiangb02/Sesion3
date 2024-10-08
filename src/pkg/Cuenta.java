package pkg;

import java.util.List;

public class Cuenta {
	
	Double saldo;
	String nombre;
	List<Movimiento> movimientos;
	
	
	public Cuenta(Double saldo, String nombre) {
		this.saldo=saldo;
		this.nombre=nombre;
	}


	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public void ingresar(double i) {
		this.saldo+=i;
	}

	public void retirar(double i) {
		this.saldo-=i;
		
	}

}
