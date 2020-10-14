package patrones.abstractfactory;

import patrones.abstractfactory.interfaz.FabricaAbstracta;
import patrones.abstractfactory.interfaz.IConexionBD;
import patrones.abstractfactory.interfaz.IConexionREST;
import patrones.abstractfactory.interfaz.impl.ConexionRESTCompras;
import patrones.abstractfactory.interfaz.impl.ConexionRESTNoArea;
import patrones.abstractfactory.interfaz.impl.ConexionRESTVentas;

public class ConexionRESTFabrica implements FabricaAbstracta {

	@Override
	public IConexionREST getREST(String area) {
		if (area == null) {
			return new ConexionRESTNoArea();
		}
		if (area.equalsIgnoreCase("COMPRAS")) {
			return new ConexionRESTCompras();
		} else if (area.equalsIgnoreCase("VENTAS")) {
			return new ConexionRESTVentas();
		}

		return new ConexionRESTNoArea();
	}

	@Override
	public IConexionBD getBD(String motor) {
		return null;
	}
}
