package com.web.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.web.app.models.Trabajador;

@Service("Servicio2")  //// PUNTO 3 DEL EXAMEN, SE CREAR UN NUEVO "Servicio" PARA AGREGAR NUEVAS FUNCIONALIDADES DE BUSQUEDA
public class TrabajadorServicio2 implements ITrabajadorService{

	private List<Trabajador> trabajadores = new ArrayList<Trabajador>();
	
	@Override
	public List<Trabajador> mostrarTrabajadores() {

		return trabajadores.stream().filter(e -> (e.getId() != 0)?true : false).collect(Collectors.toList());  //Esto es es recomendable si quiero hacer una lista mas pequeña.
	}

	@Override
	public void agregarTrabajador(Integer id, String nombre, Integer edad, float salario) {

		Trabajador t = new Trabajador();
		t.setId(id);
		t.setNombre(nombre);
		t.setEdad(edad);
		t.setSalario(salario);

		trabajadores.add(t);
	}

	@Override
	public void agregarTrabajador(Trabajador t) {
		trabajadores.add(t);
	}

	@Override
	public void eliminarTrabajador(Integer id) {
		trabajadores.removeIf(e -> id.equals(e.getId()));
	}
	
	@Override
	public boolean editarTrabajador(Trabajador t) {

		for(Trabajador trabajador : trabajadores){
			
			if(trabajador.getId().equals(t.getId())) {
				trabajador.setNombre(t.getNombre());
				trabajador.setEdad(t.getEdad());
				trabajador.setSalario(t.getSalario());
				return true;
			}
		}
		return false;
	}
	
	// PUNTO 3 DEL EXAMEN
	public Trabajador buscarTrabajadorID(Integer id) {

		for(Trabajador trabajador : trabajadores){
			
			if(trabajador.getId().equals(id)) {
				return trabajador;
			}
		}
		return new Trabajador();
	}
	
	public List<Trabajador> buscarTrabajadorNombre(String nombre) {
		
		List<Trabajador> trabajadorSameName = new ArrayList<Trabajador>();
		
		for(Trabajador trabajador : trabajadores){
			
			if(trabajador.getNombre().equals(nombre)) {
				trabajadorSameName.add(trabajador);
			}
		}
		return trabajadorSameName;
	}
	
	public List<Trabajador> buscarTrabajadorSalario(float salarioMin , float salarioMax) {
		
		List<Trabajador> trabajadorSameName = new ArrayList<Trabajador>();
		
		for(Trabajador trabajador : trabajadores){
			if(salarioMax == 0) {
				if(trabajador.getSalario()>=salarioMin) {
					trabajadorSameName.add(trabajador);
				}
			}else {
				if(trabajador.getSalario()>=salarioMin && trabajador.getSalario()<=salarioMax) {
					trabajadorSameName.add(trabajador);
				}
			}
		}
		return trabajadorSameName;
	}

}
