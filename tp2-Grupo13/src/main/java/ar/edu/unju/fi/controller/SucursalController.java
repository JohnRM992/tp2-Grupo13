package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Servicio;
import ar.edu.unju.fi.model.Sucursal;
import jakarta.validation.Valid;

@Controller
public class SucursalController {

	@Autowired
	private Sucursal sucursal;

	@Autowired
	private ListaSucursal listaSucursales;

	@GetMapping("/sucursales")
	public String mostrarListaSucursales(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		return "sucursales";
	}

	@GetMapping("/sucursal/nuevo")
	public String mostrarFormularioNuevaSucursal(Model model) {
		boolean editando = false;
		model.addAttribute("sucursal", sucursal);
		model.addAttribute("editando", editando);

		return "nueva_sucursal";
	}



	@PostMapping("/sucursal/guardar")
	public ModelAndView getGuardarSucursalpage(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result) {
			
		  if (result.hasErrors()) {
		        ModelAndView modelView = new ModelAndView("nueva_sucursal");
		        modelView.addObject("sucursal", sucursal);
		        return modelView;
		    }

		ModelAndView modelAndView = new ModelAndView("sucursales");
		listaSucursales.getSucursales().add(sucursal);
		
		modelAndView.addObject("sucursales", listaSucursales.getSucursales());
		return modelAndView;
	}

	@GetMapping("/sucursal/modificar/{nombre}")
	public String getModificarSucursalPage(Model model, @PathVariable(value = "nombre") String nombre) {
		Sucursal sucursalEncontrada = new Sucursal();
		boolean editando = true;
		for (Sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getNombre().equals(nombre)) {
				sucursalEncontrada = sucu;
				break;
			}
		}

		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("editando", editando);
		return "nueva_sucursal";
	}

	@PostMapping("/sucursal/modificar")
	public String modificarSucursal(Model model, @ModelAttribute("sucursal") Sucursal sucursalActualizada) {

		for (Sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getNombre().equals(sucursalActualizada.getNombre())) {
				sucu.setDireccion(sucursalActualizada.getDireccion());
				sucu.setProvincia(sucursalActualizada.getProvincia());
				sucu.setFechaInicio(sucursalActualizada.getFechaInicio());
				sucu.setEmail(sucursalActualizada.getEmail());
				sucu.setTelefono(sucursalActualizada.getTelefono());
				sucu.setCantidadEmpleados(sucursalActualizada.getCantidadEmpleados());

				break;
			}
		}

		return "redirect:/sucursales";
	}

	@GetMapping("/sucursal/eliminar/{nombre}")
	public String eliminarSucursal(Model model, @PathVariable(value = "nombre") String nombre) {

		for (Sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getNombre().equals(nombre)) {
				listaSucursales.getSucursales().remove(sucu);
				break;
			}
		}

		return "redirect:/sucursales"; 
	}

	@Autowired
    private ListaServicio listaServicios;

    @ModelAttribute("trabajadores")
    public List<Servicio> obtenerTrabajadoresDisponibles() {
        return listaServicios.getServicios();
    }
	
}
