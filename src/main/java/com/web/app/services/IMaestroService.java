package com.web.app.services;

import java.util.List;

//import com.web.app.models.Trabajador;
import com.web.app.controllers.entitys.Maestro;

public interface IMaestroService {
	
	// PARCIAL 3
	
	void insert(Maestro t);

	Maestro find(Integer id);

	List<Maestro> findAll();

	void update(Maestro t);

	void delete(Integer id);
	
	List<Maestro> buscarMaestroNombre(String nombre);
	
	List<Maestro> buscarMaestroSalario(float salarioMin , float salarioMax);
}
