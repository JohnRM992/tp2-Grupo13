package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

//import ar.edu.unju.fi.controller.form.FormLogin;
//import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Controller
public class ConsejosController {

	
	@Autowired
	private IConsejoService consejoService;
	
	
	@Autowired
	private Consejo consejo;


	//Muestra la lista de consejos
	@GetMapping("/consejos")
	public ModelAndView getConsejosPage() {
			ModelAndView mav = new ModelAndView("consejos");
			mav.addObject("consejos", consejoService.getConsejos());
			return mav;
	}

	//Muestra en un html, todo el contenido de un consejo a partir de su id
	@GetMapping("/consejo/detallado/{id}")
	public String mostrarDetalleConsejo(@PathVariable("id") int id, Model model) {
	    Consejo consejo = consejoService.findConsejoById(id);
	    model.addAttribute("consejo", consejo);
	    return "detalle_consejo";
	}
	
	

	@GetMapping("consejo/nuevo")
	public ModelAndView getFormularioNuevoConsejo() {
		consejo = new Consejo();
		boolean editando = false;
		ModelAndView mav = new ModelAndView("nuevo_consejo");
		mav.addObject("consejo", consejo);
		mav.addObject("editando", editando);
		return mav;
		
	}
	

	//Solicitud para guardar lo rellenado en un formulario
	@PostMapping("/consejo/guardar")
	public ModelAndView getGuardarConsejoPage(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result) {
	    if (result.hasErrors()) {
	        ModelAndView modelView = new ModelAndView("nuevo_consejo");
	        modelView.addObject("consejos", consejoService.getConsejos());
	        return modelView;
	    }

	    ModelAndView modelAndView = new ModelAndView("consejos");
	    consejoService.guardarConsejo(consejo); 
	    modelAndView.addObject("consejos", consejoService.getConsejos());
	    return modelAndView;
	}

	
	//Solicita la pagina de modificación segun un id
	@GetMapping("consejo/modificar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
		boolean editando = true;
		Consejo consejo = consejoService.findConsejoById(id);
		
		model.addAttribute("consejo", consejo);
		model.addAttribute("editando", editando);
		return "nuevo_consejo";
	}
	//Solicita la modificación de un consejo a traves de su id
	@PostMapping("/consejo/modificar/{id}")
	public String editarConsejo(@PathVariable("id") Integer id, @ModelAttribute("consejo") Consejo consejoModificado) {
	    consejoService.actualizarConsejo(id, consejoModificado);

	    return "redirect:/consejos";
	}

	//Elimina un consejo tomando como base un id
	@GetMapping("/consejo/eliminar/{id}")
	public String eliminarConsejo(@PathVariable(value = "id") Integer id) {
	    consejoService.consejoAEliminar(id);
	    return "redirect:/consejos";
	}

}
