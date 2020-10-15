package patrones.mvc.service;

import java.util.List;

import patrones.mvc.dao.PersonaDAO;
import patrones.mvc.model.Persona;

public class PersonaServiceImpl implements PersonaService{

	private PersonaDAO dao;
	
	public PersonaServiceImpl(PersonaDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Persona> listar() {		
		return dao.listar();
	}

}
