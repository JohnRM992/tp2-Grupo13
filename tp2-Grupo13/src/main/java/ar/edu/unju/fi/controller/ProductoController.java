package ar.edu.unju.fi.controller;

import java.util.List;

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
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.model.Servicio;
import jakarta.validation.Valid;


@Controller
public class ProductoController {

	
	@Autowired
	private Producto producto;

	@Autowired
	private ListaProducto listaProductos;

	@GetMapping("/productos")
	public String mostrarListaProductos(Model model) {
		model.addAttribute("productos", listaProductos.getProductos());
		return "productos";
	}

	@GetMapping("/producto/nuevo")
	public String mostrarFormularioNuevoProducto(Model model) {
		boolean editando = false;
		model.addAttribute("producto", producto);
		model.addAttribute("editando", editando);

		return "nuevo_producto";
	}



	@PostMapping("/producto/guardar")
	public ModelAndView getGuardarProductopage(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
		
		  if (result.hasErrors()) {
		        ModelAndView modelView = new ModelAndView("nuevo_producto");
		        modelView.addObject("producto", producto);
		        return modelView;
		    }
		
		
		ModelAndView modelAndView = new ModelAndView("productos");
		listaProductos.getProductos().add(producto);
		
		modelAndView.addObject("productos", listaProductos.getProductos());
		return modelAndView;
	}

	@GetMapping("/producto/modificar/{nombre}")
	public String getModificarProductoPage(Model model, @PathVariable(value = "nombre") String nombre) {
		Producto productoEncontrado = new Producto();
		boolean editando = true;
		for (Producto prod: listaProductos.getProductos()) {
			if (prod.getNombre().equals(nombre)) {
				productoEncontrado= prod;
				break;
			}
		}

		model.addAttribute("producto", productoEncontrado);
		model.addAttribute("editando", editando);
		return "nuevo_producto";
	}

	@PostMapping("/producto/modificar")
	public String modificarProducto(Model model, @ModelAttribute("producto") Producto productoActualizado) {

		for (Producto sucu : listaProductos.getProductos()) {
			if (sucu.getNombre().equals(productoActualizado.getNombre())) {
				sucu.setCodigo(productoActualizado.getCodigo());
				sucu.setPrecio(productoActualizado.getPrecio());
				sucu.setNombre(productoActualizado.getNombre());
				sucu.setDescuento(productoActualizado.getDescuento());
				sucu.setCategoria(productoActualizado.getCategoria());
			

				break;
			}
		}

		return "redirect:/productos";
	}

	@GetMapping("/producto/eliminar/{nombre}")
	public String eliminarProducto(Model model, @PathVariable(value = "nombre") String nombre) {

		for (Producto prod : listaProductos.getProductos()) {
			if (prod.getNombre().equals(nombre)) {
				listaProductos.getProductos().remove(prod);
				break;
			}
		}

		return "redirect:/productos"; 
	}
	
	@Autowired
    private ListaServicio listaServicios;

    @ModelAttribute("trabajadores")
    public List<Servicio> obtenerTrabajadoresDisponibles() {
        return listaServicios.getServicios();
    }

}
