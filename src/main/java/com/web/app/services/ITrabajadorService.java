package com.web.app.services;

import java.util.List;

import com.web.app.models.Trabajador;

public interface ITrabajadorService {

	public List<Trabajador> mostrarTrabajadores();
	public void agregarTrabajador(Integer id, String nombre, Integer edad, float salario);
	public void agregarTrabajador(Trabajador t);
	public void eliminarTrabajador(Integer id);
	public boolean editarTrabajador(Trabajador t);
	
	// PUNTO 3 DEL EXAMEN
	public Trabajador buscarTrabajadorID(Integer id);
	public List<Trabajador> buscarTrabajadorNombre(String nombre);
	public List<Trabajador> buscarTrabajadorSalario(float salarioMin , float salarioMax);
}
