package com.web.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.app.models.Trabajador;
import com.web.app.services.ITrabajadorService;

@Controller
@RequestMapping(path = {"/Trabajador"})
public class TrabajadorController {
	@Autowired
	@Qualifier("Servicio2") //Esto es para tambien incluir la funcionalidad de Servici2,este servicio mejorado incluye la funcionalidad de buscar
	private ITrabajadorService service;
	
	@Autowired
	private Environment env;
	
	
	@RequestMapping(path = { "/index", "/" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("titulo", env.getProperty("mensaje.tituloInicio")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		model.addAttribute("listaTrabajador" , service.mostrarTrabajadores());
		return "trabajador/inicioTrabajador";
	}
	
	
	@GetMapping(path = "/form_alta")
	public String form_alta( Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloAlta")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		model.addAttribute("trabajador" , new Trabajador());
		
		return "trabajador/form_alta";
	}
	
	
	@PostMapping(path= {"/form_alta"})
	public String resultado_alta(
			@Valid Trabajador trabajador ,
			BindingResult result ,
			Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloAlta")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		
		if(result.hasErrors()) {
			
			return "trabajador/form_alta";
		}
		service.agregarTrabajador(trabajador);
		model.addAttribute("listaTrabajador" , service.mostrarTrabajadores()); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		
		return "trabajador/inicioTrabajador";
	}
	
	@GetMapping(path= {"/form_eliminar"})
	public String form_eliminar(
			Model model) {
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloEliminar")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		return "trabajador/form_eliminar";
	}
	
	@PostMapping(path= {"/form_eliminar"})
	public String form_eliminar(
			Integer id,
			Model model) {
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloEliminar")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		if( id == null ||id < 0) {
			model.addAttribute("error", "ID no es valido, favor de varificarlo.");
			return "trabajador/form_eliminar";
		}
		service.eliminarTrabajador(id);
		model.addAttribute("titulo", env.getProperty("mensaje.titulo")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		model.addAttribute("listaTrabajador" , service.mostrarTrabajadores());
		return "trabajador/inicioTrabajador";
	}
	
	
	@GetMapping(path = "/form_editar")
	public String form_aditar( Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloEditar")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		model.addAttribute("trabajador" , new Trabajador());
		
		return "trabajador/form_editar";
	}
	
	
	@PostMapping(path= {"/form_editar"})
	public String resultado_editar(
			@Valid Trabajador trabajador ,
			BindingResult result ,
			Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloEditar")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		
		if(result.hasErrors()) {
			
			return "trabajador/form_editar";
		}
		service.editarTrabajador(trabajador);
		model.addAttribute("listaTrabajador" , service.mostrarTrabajadores());
		
		return "trabajador/inicioTrabajador";
	}
	
	// PUNTO 3 DEL EXAMEN
	@GetMapping(path= {"/menu_buscar"})
	public String menu_buscar(Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloMenuBuscar")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		
		return "trabajador/menu_buscar";
	}
	
	// PUNTO 3 DEL EXAMEN
	@GetMapping(path= {"/buscar_ID"})
	public String buscar_ID(Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloBuscarID")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		model.addAttribute("trabajador" , new Trabajador());
		return "trabajador/buscar_ID";
	}
	
	// PUNTO 3 DEL EXAMEN
	@PostMapping(path= {"/buscar_ID"})
	public String buscar_ID(
			Integer id,
			Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloBuscarID")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		if( id == null ||id < 0) {
			model.addAttribute("error", "ID no es valido, favor de varificarlo.");
			model.addAttribute("trabajador" , new Trabajador());
			return "trabajador/buscar_ID";
		}
		
		model.addAttribute("trabajador" , service.buscarTrabajadorID(id));
		
		return "trabajador/buscar_ID";
	}
	
	// PUNTO 3 DEL EXAMEN
	@GetMapping(path= {"/buscar_Nombre"})
	public String buscar_Nombre(Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloBuscarNombre")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		model.addAttribute("trabajador" , new Trabajador());
		return "trabajador/buscar_Nombre";
	}
	
	// PUNTO 3 DEL EXAMEN
	@PostMapping(path= {"/buscar_Nombre"})
	public String buscar_Nombre(
			String nombre,
			Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloBuscarNombre")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		if( nombre == null || nombre == "") {
			model.addAttribute("error", "Nombre no valido, favor de varificarlo.");
			model.addAttribute("listaTrabajador" , new Trabajador());
			return "trabajador/buscar_Nombre";
		}
		
		model.addAttribute("listaTrabajador" , service.buscarTrabajadorNombre(nombre));
		
		return "trabajador/buscar_Nombre";
	}
	
	// PUNTO 3 DEL EXAMEN
	@GetMapping(path= {"/buscar_Salario"})
	public String buscar_Salario(Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloBuscarSalario")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		model.addAttribute("listaTrabajador" , new Trabajador());
		return "trabajador/buscar_Salario";
	}
	
	// PUNTO 3 DEL EXAMEN
	@PostMapping(path= {"/buscar_Salario"})
	public String buscar_Salario(
			String stringMin,
			String stringMax,
			Model model) {
		float salarioMin;
		float salarioMax;
		
		if(stringMin!="" && stringMin!=null) {
			salarioMin = Float.parseFloat(stringMin);
		} else {salarioMin = 0;}
		
		if(stringMax!="" && stringMax!=null) {
			salarioMax = Float.parseFloat(stringMax);
		}else {salarioMax = 0;}
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloBuscarSalario")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		
		if( stringMin == null || stringMin == "") {
			model.addAttribute("error1", "Al menos debe ingresar un salario minimo correctamente.");
			model.addAttribute("listaTrabajador" , new Trabajador());
			return "trabajador/buscar_Salario";
		}
		
		model.addAttribute("listaTrabajador" , service.buscarTrabajadorSalario(salarioMin , salarioMax));
		
		return "trabajador/buscar_Salario";
	}
	
}
