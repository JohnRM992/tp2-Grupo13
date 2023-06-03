package ar.edu.unju.fi.model;


import org.springframework.stereotype.Component;

/*VALIDACIONES*/

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

/**
 * Representa un producto ofrecido
 * @author Jonathan R. Mascareño
 * @version 1.0 date: 2/6/23
 */



@Component
public class Producto {
	
	@NotBlank(message="El nombre no puede estar vacio")
	private String nombre;
	@Min(value = 1, message="El valor minimo para codigo es 1")
	@Positive(message="El codigo debe ser un número positivo")
	private int codigo;
	//@NotEmpty(message="El precio no puede estar vacio")
	@Min(value = 1, message="El valor minimo para precio es 1")
	@Positive(message="El precio debe ser un número positivo")
	private float precio;
	@Min(value = 0, message = "El valor minimo permitido es 0")
	@Max(value = 50, message = "El valor maximo permitido es 50")
	private int descuento;
	@NotBlank(message = "Debe seleccionar una provincia")
	private String categoria;
	
	
	//private int id;
	
	
	public Producto() {}
	
	
	
	
	
	/**
	 * Constructor parametrizado
	 * @param nombre es el nombre del producto
	 * @param codigo es el codigo de identificación del producto
	 * @param precio es el precio del producto
	 * @param categoria es la categoria a la que pertenece el producto
	 * @param descuento es el % de descuento que tiene un producto
	 */
	
	public Producto(String nombre, int codigo, float precio, String categoria, int descuento) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
	}
	
//	 public int getId() {
//	        return id;
//	    }
//
//	    public void setId(int id) {
//	        this.id = id;
//	    }
	    
	    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	
	public double calcularDescuento() {
        if (this.getDescuento() >= 0 && this.getDescuento()<= 50) {
            double descuentoDecimal = this.getDescuento() / 100.0;
            double  precioConDescuento = this.getPrecio() * (1 - descuentoDecimal);
           
            return precioConDescuento;
        } else {
            throw new IllegalArgumentException("El valor no está en el rango");
        }
    }
	
	
	
	
	
}
