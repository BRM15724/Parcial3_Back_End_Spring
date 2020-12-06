package com.web.app.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//import com.web.app.models.Trabajador;
import com.web.app.controllers.entitys.Maestro;
import com.web.app.controllers.repositorys.MaestroDAO;

@Component
@Primary
public class MaestroService implements IMaestroService {
	
	// PARCIAL 3
	
	@Autowired
	private MaestroDAO maestroDAO;
	
	@Override
	public void insert(Maestro t) {
		maestroDAO.insert(t);
	}

	@Override
	public List<Maestro> findAll() {
		return maestroDAO.findAll();
	}

	@Override
	public void update(Maestro m) {
		maestroDAO.update(m);
	}

	@Override
	public void delete(Integer id) {
		maestroDAO.delete(id);
		
	}
	
	// DE AQUI PARA ABAJO HAY METODOS QUE AYUDAN A RESOLVER LA PROBLEMATICA DEL PUNTO 3 DEL PARCIAL 3, BUSQUEDAS PERSONALIZADAS (SERVICIO)
	
	@Override
	public Maestro find(Integer id) {
		return maestroDAO.find(id);
	}
	
	@Override
	public List<Maestro> buscarMaestroNombre(String nombre) {
		List<Maestro> result = maestroDAO.find_nombre(nombre);
		return result;
	}
	
	@Override
	public List<Maestro> buscarMaestroSalario(float salarioMin , float salarioMax){
		List<Maestro> result = maestroDAO.find_salarios(salarioMin , salarioMax);
		return result;
	}
}
