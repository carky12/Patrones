package patrones.decorator;

import patrones.decorator.decorador.BlindajeDecorador;
import patrones.decorator.interfaz.ICuentaBancaria;
import patrones.decorator.interfaz.impl.CuentaAhorro;
import patrones.decorator.model.Cuenta;

public class App {

	public static void main(String[] args) {
		Cuenta c = new Cuenta(1, "MitoCode");	
		
		ICuentaBancaria cuenta = new CuentaAhorro();
		ICuentaBancaria cuentaBlindada = new BlindajeDecorador(cuenta);
		
		//cuenta.abrirCuenta(c);
		cuentaBlindada.abrirCuenta(c);
	}

}
