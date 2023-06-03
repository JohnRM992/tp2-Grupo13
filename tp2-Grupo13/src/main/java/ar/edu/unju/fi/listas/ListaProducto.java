package ar.edu.unju.fi.listas;


import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Producto;

//import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class ListaProducto {
	private List<Producto> productos;
	
	
	
	public ListaProducto() {
		productos = new ArrayList<Producto>();
	
	}



	public List<Producto> getProductos() {
		return productos;
	}



	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}

