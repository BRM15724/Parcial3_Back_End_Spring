package com.web.app.controllers.entitys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.web.app.validations.MayorDeEdad;
import com.web.app.validations.SalarioMinimo;

@Entity
@Table(name = "maestro")
public class Maestro {
	// LOS MENSAJES DE VALIDACIONES ESTAN EN "messages.properties"
	@Id
	@NotNull      // PUNTO 2 DE ESTE PARCIAL 3, REALIZO VALIDACION.
	private Integer id;
	//@Column(name = "NombreX")
	@NotEmpty     // PUNTO 2 DE ESTE PARCIAL 3, REALIZO VALIDACION.
	private String nombre;
	@NotNull
	@MayorDeEdad    // PUNTO 2 DE ESTE PARCIAL 3, REALIZO VALIDACION PERSONALIZADA DE EDAD ADULTA.
	private Integer edad;
	@SalarioMinimo	// PUNTO 2 DE ESTE PARCIAL 3, REALIZO VALIDACION PERSONALIZADA DE SALARIO MINIMO.
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
