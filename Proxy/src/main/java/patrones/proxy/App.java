package patrones.proxy;

import patrones.proxy.interfaz.ICuenta;
import patrones.proxy.interfaz.impl.CuentaBancoBImpl;
import patrones.proxy.model.Cuenta;
import patrones.proxy.proxy.CuentaProxy;

public class App {

	public static void main(String[] args) {
		Cuenta c = new Cuenta(1, "carky", 100);
		
		ICuenta cuentaProxy = new CuentaProxy(new CuentaBancoBImpl());
		cuentaProxy.mostrarSaldo(c);
		c = cuentaProxy.depositarDinero(c, 50);
		c = cuentaProxy.retirarDinero(c, 20);
		cuentaProxy.mostrarSaldo(c);
		
	}

}
