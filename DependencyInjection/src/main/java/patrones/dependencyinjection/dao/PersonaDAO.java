package patrones.dependencyinjection.dao;

import patrones.dependencyinjection.model.Persona;

public interface PersonaDAO extends CRUD<Persona>{

	void mostrarNombre();
	void setConexion(IConexion conexion);
	
}
