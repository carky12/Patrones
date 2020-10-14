package patrones.decorator.interfaz.impl;

import patrones.decorator.interfaz.ICuentaBancaria;
import patrones.decorator.model.Cuenta;

public class CuentaCorriente implements ICuentaBancaria {

	@Override
	public void abrirCuenta(Cuenta c) {
		System.out.println("-------------------------");
		System.out.println("Se abrió una cuenta Corriente");
		System.out.println("Cliente: " + c.getCliente());		
	}

}
