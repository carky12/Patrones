package patrones.abstractfactory.interfaz.impl;

import patrones.abstractfactory.interfaz.IConexionREST;

public class ConexionRESTNoArea implements IConexionREST{

	@Override
	public void leerURL(String url) {
		System.out.println("AREA NO ELEGIDA");
	}

}
