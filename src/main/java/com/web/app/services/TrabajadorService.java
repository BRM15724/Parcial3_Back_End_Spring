package com.web.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.web.app.models.Trabajador;

@Component
@Primary
public class TrabajadorService implements ITrabajadorService {

	private List<Trabajador> trabajadores = new ArrayList<Trabajador>();

	@Override
	public List<Trabajador> mostrarTrabajadores() {

		return trabajadores;
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
	
	public Trabajador buscarTrabajadorID(Integer id) {
		return null;
	}
	
	public List<Trabajador> buscarTrabajadorNombre(String nombre){
		return null;
	}
	public List<Trabajador> buscarTrabajadorSalario(float salarioMin , float salarioMax){
		return null;
	}
}
