package patrones.factoria;

import patrones.factoria.interfaz.IConexion;
import patrones.factoria.interfaz.impl.ConexionMySQL;
import patrones.factoria.interfaz.impl.ConexionOracle;
import patrones.factoria.interfaz.impl.ConexionPostgreSQL;
import patrones.factoria.interfaz.impl.ConexionSQLServer;
import patrones.factoria.interfaz.impl.ConexionVacia;

public class ConexionFabrica {

	public IConexion getConexion(String motor) {
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
}
