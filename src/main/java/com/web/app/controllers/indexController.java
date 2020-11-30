package com.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = {"/Aplicacion" , ""})
public class indexController {
	
	@Autowired
	private Environment env;
	
	@RequestMapping(path = { "/index", "/" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("titulo", env.getProperty("mensaje.tituloIndex")); // PUNTO 2 DEL EXAMEN, MENSAJES EN "mensajes.properties"
		return "index";
	}
}
