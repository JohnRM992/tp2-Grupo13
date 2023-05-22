package ar.edu.unju.fi.practico4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

//import ar.edu.unju.fi.practico4.model.FormProducto;

@Controller
public class WebController {
	@GetMapping("/index")
	public String getIndexPage(Model model) {
		return "index";
	}

	@GetMapping("/productos")
	public String getProductosPage(Model model) {
		return "productos";
	}

	@GetMapping("/consejos")
	public String getConsejosPage(Model model) {
		return "consejos";
	}

	@GetMapping("/servicios")
	public String getServiciosPage(Model model) {
		return "servicios";
	}

	@GetMapping("/sucursales")
	public String getSucursalesPage(Model model) {
		return "sucursales";
	}

	@GetMapping("/contacto")
	public String getContactoPage(Model model) {
		return "contacto";
	}

}
