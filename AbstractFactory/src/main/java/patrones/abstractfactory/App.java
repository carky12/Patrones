package patrones.abstractfactory;

import patrones.abstractfactory.interfaz.FabricaAbstracta;
import patrones.abstractfactory.interfaz.IConexionBD;
import patrones.abstractfactory.interfaz.IConexionREST;

public class App {

	public static void main(String[] args) {
		FabricaAbstracta fabricaBD = FabricaProductor.getFactory("BD");
		IConexionBD cxBD1 = fabricaBD.getBD("MYSQL");

		cxBD1.conectar();

		FabricaAbstracta fabricaREST = FabricaProductor.getFactory("REST");
		IConexionREST cxRS1 = fabricaREST.getREST("COMPRAS");

		cxRS1.leerURL("http://carky.synology.me");
	}

}
