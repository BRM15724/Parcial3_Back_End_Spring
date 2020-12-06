package com.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.controllers.entitys.Maestro;
import com.web.app.services.IMaestroService;

//TODO ESTE CONTROLADOR RESUELVE EL PUNTO 4 DE ESTE PARCIAL 3
@RestController
@RequestMapping("/restMaestro")
public class MaestroRestController {

	@Autowired
	private IMaestroService service;
	
	@GetMapping(path= {"" , "/"})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public List<Maestro> findAll(){
		return service.findAll();
	}
	
	@GetMapping(path= {"/{id}"})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Maestro find(@PathVariable Integer id){
		return service.find(id);
	}
	
	@GetMapping(path= {"/agregar/{id}/{nombre}/{edad}/{salario}"})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Maestro insert(@PathVariable Integer id,@PathVariable String nombre ,@PathVariable Integer edad,@PathVariable float salario){
		Maestro m = new Maestro();
		m.setId(id);
		m.setNombre(nombre);
		m.setEdad(edad);
		m.setSalario(salario);
		service.insert(m);
		return m;
	}
	
	@GetMapping(path= {"/editar/{id}/{nombre}/{edad}/{salario}"})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Maestro update(@PathVariable Integer id,@PathVariable String nombre ,@PathVariable Integer edad,@PathVariable float salario){
		Maestro m = new Maestro();
		m.setId(id);
		m.setNombre(nombre);
		m.setEdad(edad);
		m.setSalario(salario);
		service.update(m);
		return m;
	}
	
	@GetMapping(path= {"eliminar/{id}"})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Boolean delete(@PathVariable Integer id){
		service.delete(id);
		return true;
	}
}
