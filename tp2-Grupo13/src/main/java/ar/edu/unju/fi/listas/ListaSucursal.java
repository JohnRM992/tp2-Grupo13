package ar.edu.unju.fi.listas;


import java.util.List;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Sucursal;

import java.util.ArrayList;

@Component
public class ListaSucursal {
	
	
		private List<Sucursal> sucursales;
		
		
		
		public ListaSucursal() {
			sucursales = new ArrayList<Sucursal>();
		
		}



		public List<Sucursal> getSucursales() {
			return sucursales;
		}



		public void setSucursales(List<Sucursal> sucursales) {
			this.sucursales = sucursales;
		}
		
		
}

