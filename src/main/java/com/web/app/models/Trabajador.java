package com.web.app.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.web.app.validations.MayorDeEdad;
import com.web.app.validations.SalarioMinimo;

public class Trabajador {
	
	@NotNull // PUNTO 2 DEL EXAMEN, VALIDACIONES
	private Integer id;
	
	@NotEmpty // PUNTO 2 DEL EXAMEN, VALIDACIONES
	private String nombre;
	
	@NotNull // PUNTO 2 DEL EXAMEN, VALIDACIONES
	@MayorDeEdad // PUNTO 2 DEL EXAMEN, VALIDACIONES, esta validacion fue hecha por mi y se encunetra en "com.web.app.validations" dentro de "MayorDeEdad"
	private Integer edad;
	
	@SalarioMinimo // PUNTO 2 DEL EXAMEN, VALIDACIONES
	private float salario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

}
