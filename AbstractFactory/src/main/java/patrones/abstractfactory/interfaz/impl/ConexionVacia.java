package patrones.abstractfactory.interfaz.impl;

import patrones.abstractfactory.interfaz.IConexionBD;

public class ConexionVacia implements IConexionBD{

	@Override
	public void conectar() {
		System.out.println("NO SE ESPECIFICÓ PROVEEDOR");		
	}

	@Override
	public void desconectar() {
		System.out.println("NO SE ESPECIFICÓ PROVEEDOR");		
	}

}
