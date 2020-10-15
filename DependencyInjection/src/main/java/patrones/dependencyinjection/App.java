package patrones.dependencyinjection;

import patrones.dependencyinjection.dao.ConexionMySQL;
import patrones.dependencyinjection.dao.ConexionPostgre;
import patrones.dependencyinjection.dao.IConexion;
import patrones.dependencyinjection.dao.PersonaDAO;
import patrones.dependencyinjection.dao.PersonaDAOImpl;

public class App {

	public static void main(String[] args) {
		IConexion cx1 = new ConexionMySQL("mitocode", "7482", "localhost");				
		
		IConexion cx2 = new ConexionPostgre("mitocode", "7482", "192.168.1.1");
		
		PersonaDAO dao = new PersonaDAOImpl();
		dao.setConexion(cx1);
		
		dao.listarTodos();
		
	}
}
