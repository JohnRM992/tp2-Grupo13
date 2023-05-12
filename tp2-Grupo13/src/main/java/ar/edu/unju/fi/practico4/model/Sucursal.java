package ar.edu.unju.fi.practico4.model;

import java.time.LocalDate;

public class Sucursal {
	private String nombre;
	private String dirección;
	private String provincia;
	private LocalDate fechaInicio;
	private String email;
	private String telefono;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDirección() {
		return dirección;
	}
	public void setDirección(String dirección) {
		this.dirección = dirección;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public Sucursal(String nombre, String dirección, String provincia, LocalDate fechaInicio, String email,
			String telefono) {
		super();
		this.nombre = nombre;
		this.dirección = dirección;
		this.provincia = provincia;
		this.fechaInicio = fechaInicio;
		this.email = email;
		this.telefono = telefono;
	}
	
	public Sucursal() {
		
	}
	
}
