package ar.edu.unju.fi.practico4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.practico4.model.Producto;

@Controller
public class WebController {
	@GetMapping("/index")
	public String getIndexPage(Model model) {
		return "index";
	}

//	@GetMapping("/productos")
//	public String getProductosPage(Model model) {
//		return "productos";
//	}

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
	
	
	 private List<Producto> productos = new ArrayList<>();

	    @GetMapping("/productos")
	    public ModelAndView mostrarListaProductos() {
	        ModelAndView modelAndView = new ModelAndView("productos");
	        modelAndView.addObject("productos", productos);
	        return modelAndView;
	    }

	
	    
	    @GetMapping("/productos/nuevo")
	    public ModelAndView mostrarFormularioNuevo() {
	        ModelAndView modelAndView = new ModelAndView("nuevo_producto");
	        modelAndView.addObject("producto", new Producto()); 
	        return modelAndView;
	    }

	    @PostMapping("/productos/crear")
	    public ModelAndView crearProducto(@ModelAttribute Producto producto) {
	        productos.add(producto);
	        ModelAndView modelAndView = new ModelAndView("redirect:/productos");
	        modelAndView.addObject("productos", productos);
	        return modelAndView;
	    }
	    
	    @GetMapping("/productos/eliminar/{id}")
	    public ModelAndView eliminarProducto(@PathVariable int id) {
	        productos.removeIf(producto -> producto.getId() == id);
	        ModelAndView modelAndView = new ModelAndView("redirect:/productos");
	        modelAndView.addObject("mensaje", "Producto eliminado correctamente");
	        return modelAndView;
	    }

}
