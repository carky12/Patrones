package patrones.abstractfactory.interfaz.impl;

import patrones.abstractfactory.interfaz.IConexionREST;

public class ConexionRESTCompras implements IConexionREST{

	@Override
	public void leerURL(String url) {		
		System.out.println("Conectándose a " + url);
	}

}
