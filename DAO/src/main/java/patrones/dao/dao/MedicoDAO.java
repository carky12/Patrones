package patrones.dao.dao;

import patrones.dao.model.Medico;

public interface MedicoDAO extends CRUD<Medico>{

	void curar();

}
