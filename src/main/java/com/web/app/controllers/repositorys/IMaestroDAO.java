package com.web.app.controllers.repositorys;

import java.util.List;

import com.web.app.controllers.entitys.Maestro;

public interface IMaestroDAO {
	
	void insert (Maestro t);
	
	Maestro find(Integer id);
	
	List<Maestro> findAll();
	
	void update (Maestro t);
	
	void delete(Integer t);
	
	List<Maestro> find_nombre(String nombre);
	
	List<Maestro> find_salarios(float salarioMin , float salarioMax);
}
