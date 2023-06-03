package ar.edu.unju.fi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//import ar.edu.unju.fi.controller.form.FormLogin;
import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Servicio;


@Controller
public class WebController {

	@GetMapping("/index")
	public String getIndexPage(Model model) {
		return "index";
	}

	
	
	
	@Autowired
    private ListaServicio listaServicios;

    @ModelAttribute("trabajadores")
    public List<Servicio> obtenerTrabajadoresDisponibles() {
        return listaServicios.getServicios();
    }

	@GetMapping("/contacto")
	public String getContactoPage(Model model) {
		return "contacto";
	}
	
//    @GetMapping("login")
//    public String getLoginpage(Model model) {
//    	FormLogin formLogin = new FormLogin();
//    	model.addAttribute("formLogin", formLogin);
//    	return "login";
//    	
//    }
//	
//    @PostMapping("login")
//    public String getValidar(Model model,FormLogin formLogin){
//    	if( formLogin.getUsuario().equals("administrador") && formLogin.getPassword().equals("123456") ) {
//    		model.addAttribute("usuario", formLogin.getUsuario());
//    		return "index";
//    	}
//    	
//    	model.addAttribute("error","Los datos son incorrectos");
//    	return "login";
//    	
//    	
//    }
	
}
