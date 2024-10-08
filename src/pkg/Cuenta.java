package pkg;

public class Cuenta {
	
	Double saldo;
	String nombre;
	
	
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
