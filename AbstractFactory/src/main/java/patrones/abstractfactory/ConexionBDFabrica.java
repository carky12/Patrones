package patrones.abstractfactory;

import patrones.abstractfactory.interfaz.FabricaAbstracta;
import patrones.abstractfactory.interfaz.IConexionBD;
import patrones.abstractfactory.interfaz.IConexionREST;
import patrones.abstractfactory.interfaz.impl.ConexionMySQL;
import patrones.abstractfactory.interfaz.impl.ConexionOracle;
import patrones.abstractfactory.interfaz.impl.ConexionPostgreSQL;
import patrones.abstractfactory.interfaz.impl.ConexionSQLServer;
import patrones.abstractfactory.interfaz.impl.ConexionVacia;

public class ConexionBDFabrica implements FabricaAbstracta{

	@Override
	public IConexionBD getBD(String motor) {
		if (motor == null) {
			return new ConexionVacia();
		}
		if (motor.equalsIgnoreCase("MYSQL")) {
			return new ConexionMySQL();
		} else if (motor.equalsIgnoreCase("ORACLE")) {
			return new ConexionOracle();
		} else if (motor.equalsIgnoreCase("POSTGRE")) {
			return new ConexionPostgreSQL();
		} else if (motor.equalsIgnoreCase("SQL")) {
			return new ConexionSQLServer();
		}

		return new ConexionVacia();
	}

	@Override
	public IConexionREST getREST(String area) {
		return null;
	}
}
