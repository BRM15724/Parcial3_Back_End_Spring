package com.web.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.web.app.models.maestro;
import com.web.app.controllers.entitys.Maestro;
import com.web.app.services.IMaestroService;

@Controller
@RequestMapping(path = {"/Maestro"})
public class MaestroController {
	
	@Autowired
	private IMaestroService service;
	
	// PUNTO 2 DE ESTE PARCIAL 3, ACCEDEMOS A "mensajes.properties" PARA PONER TODOS LOS TITULOS.
	@Autowired
	private Environment env;
	
	
	@RequestMapping(path = { "/index", "/" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("titulo", env.getProperty("mensaje.tituloInicio")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		model.addAttribute("listaMaestro" , service.findAll());
		return "maestro/inicioMaestros";
	}
	
	@RequestMapping(path = { "/listar" }, method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", env.getProperty("mensaje.tituloListar")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		model.addAttribute("listaMaestro" , service.findAll());
		return "maestro/listar";
	}
	
	@GetMapping(path = {"/editar/{id}"})
	public String editar_actual(@PathVariable Integer id , Model model) {
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloEditar")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		model.addAttribute("listaMaestro" , service.findAll());
		model.addAttribute("maestro" , service.find(id));
		return "maestro/form_editar";
	}
	
	@GetMapping(path = {"/eliminar/{id}"})
	public String eliminar_actual(@PathVariable Integer id , Model model) {
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloEliminar")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		service.delete(id);
		model.addAttribute("listaMaestro" , service.findAll());
		return "maestro/listar";
	}
	
	@GetMapping(path = "/form_alta")
	public String form_alta( Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloAlta")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		model.addAttribute("maestro" , new Maestro());
		
		return "maestro/form_alta";
	}
	
	
	@PostMapping(path= {"/form_alta"})
	public String resultado_alta(
			@Valid Maestro maestro ,
			BindingResult result ,
			Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloAlta")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		
		if(result.hasErrors()) {
			
			return "maestro/form_alta";
		}
		service.insert(maestro);
		model.addAttribute("listaMaestro" , service.findAll());
		
		return "maestro/inicioMaestros";
	}
	
	@GetMapping(path= {"/form_eliminar"})
	public String form_eliminar(
			Model model) {
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloEliminar")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		return "maestro/form_eliminar";
	}
	
	@PostMapping(path= {"/form_eliminar"})
	public String form_eliminar(
			Integer id,
			Model model) {
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloEliminar")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		if( id == null ||id < 0) {
			model.addAttribute("error", "ID no es valido, favor de varificarlo.");
			return "maestro/form_eliminar";
		}
		service.delete(id);
		model.addAttribute("titulo", env.getProperty("mensaje.titulo")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		model.addAttribute("listaMaestro" , service.findAll());
		return "maestro/inicioMaestros";
	}
	
	
	@GetMapping(path = "/form_editar")
	public String form_aditar( Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloEditar")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		model.addAttribute("listaMaestro" , service.findAll());
		model.addAttribute("maestro" , new Maestro());
		
		return "maestro/form_editar";
	}
	
	
	@PostMapping(path= {"/form_editar"})
	public String resultado_editar(
			@Valid Maestro maestro ,
			BindingResult result ,
			Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloEditar")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		model.addAttribute("listaMaestro" , service.findAll());
		if(result.hasErrors()) {
			
			return "maestro/form_editar";
		}
		service.update(maestro);
		
		return "maestro/inicioMaestros";
	}
	
	@GetMapping(path= {"/menu_buscar"})
	public String menu_buscar(Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloMenuBuscar")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		
		return "maestro/menu_buscar";
	}
	
	
	// DE AQUI PARA ABAJO HAY METODOS QUE AYUDAN A RESOLVER LA PROBLEMATICA DEL PUNTO 3 DEL PARCIAL 3, BUSQUEDAS PERSONALIZADAS
	
	
	@GetMapping(path= {"/buscar_ID"})
	public String buscar_ID(Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloBuscarID")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		model.addAttribute("maestro" , new Maestro());
		return "maestro/buscar_ID";
	}
	
	@PostMapping(path= {"/buscar_ID"})
	public String buscar_ID(
			Integer id,
			Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloBuscarID")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		if( id == null ||id < 0) {
			model.addAttribute("error", "ID no es valido, favor de varificarlo.");
			model.addAttribute("maestro" , new Maestro());
			return "maestro/buscar_ID";
		}
		
		model.addAttribute("maestro" , service.find(id));
		
		return "maestro/buscar_ID";
	}
	
	@GetMapping(path= {"/buscar_Nombre"})
	public String buscar_Nombre(Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloBuscarNombre")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		model.addAttribute("maestro" , new Maestro());
		return "maestro/buscar_Nombre";
	}
	
	@PostMapping(path= {"/buscar_Nombre"})
	public String buscar_Nombre(
			String nombre,
			Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloBuscarNombre")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		if( nombre == null || nombre == "") {
			model.addAttribute("error", "Nombre no valido, favor de varificarlo.");
			model.addAttribute("listaMaestro" , new Maestro());
			return "maestro/buscar_Nombre";
		}
		
		model.addAttribute("listaMaestro" , service.buscarMaestroNombre(nombre));
		
		return "maestro/buscar_Nombre";
	}
	
	@GetMapping(path= {"/buscar_Salario"})
	public String buscar_Salario(Model model) {
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloBuscarSalario")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		model.addAttribute("listaMaestro" , new Maestro());
		return "maestro/buscar_Salario";
	}
	
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
		
		model.addAttribute("titulo" , env.getProperty("mensaje.tituloBuscarSalario")); // PUNTO 2 DE ESTE PARCIAL 3, OBTENGO UN TITULO.
		
		if( stringMin == null || stringMin == "") {
			model.addAttribute("error1", "Al menos debe ingresar un salario minimo correctamente.");
			model.addAttribute("listaMaestro" , new Maestro());
			return "maestro/buscar_Salario";
		}
		
		model.addAttribute("listaMaestro" , service.buscarMaestroSalario(salarioMin , salarioMax));
		
		return "maestro/buscar_Salario";
	}
	
	
}
