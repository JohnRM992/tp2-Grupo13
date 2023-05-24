package ar.edu.unju.fi.practico4.model;

public class Producto {
	private String nombre;
	private int codigo;
	private float precio;
	private int descuento;
	private String categoria;
	
	//private float precioyDescuento;
	private int id;
	
	
	public Producto() {}
	
	
	public Producto(String nombre, int codigo, float precio, String categoria, int descuento) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
	}
	
	 public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }
	    
	    
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
