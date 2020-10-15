package patrones.dao.dao;

import patrones.dao.model.Persona;

public interface PersonaDAO extends CRUD<Persona>{

	void mostrarNombre();
	
}
