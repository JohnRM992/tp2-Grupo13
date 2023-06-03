package ar.edu.unju.fi.model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/*VALIDACIONES*/
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;



/**
 * Representa una sucursal
 * @author Jonathan R. Mascareño
 * @version 1.0 date: 2/6/23
 */


@Component
public class Sucursal {

	@NotEmpty(message = "El nombre no puede estar vacio")
	private String nombre;
	@Size(min = 5, max = 100, message = "La dirección debe tener entre 5 y 100 caracteres")
	private String direccion;
	@NotEmpty(message = "Debe seleccionar una provincia")
	private String provincia;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "La fecha no puede ser null")
	@Past(message = "La fecha debe ser menor a la fecha actual")
	private LocalDate fechaInicio;
	@Email(message = "Debe ingresar un correo valido")
	@NotEmpty(message="El correo no puede quedar vacio")
	@NotNull(message = "Este campo no puede quedar vacio")
	private String email;
	@NotEmpty(message = "El telefono no puede ser vacio")
	private String telefono;
	@Min(value = 5, message = "El valor minimo permitido es 5")
	@Max(value = 30, message = "El valor maximo permitido es 30")
	@Positive(message = "Solo se permiten valores positivos")
	private int cantidadEmpleados;

	public Sucursal() {
		super();
	}
	
	
	
	/**
	 * Constructor parametrizado
	 * @param nombre es el nombre de la sucursal
	 * @param direccion  es la direccion de la sucursal
	 * @param provincia es la provincia en donde se encuentra la sucursal
	 * @param fechaInicio es la fecha de comienzo de la sucursal
	 * @param email es el correo utilizado por la sucursal
	 *  @param  telefono es el telefono de la sucursal
	 *  @param  cantidadEmpleados es la cantidad de empleados que posee la sucursal
	 */

	public Sucursal(String nombre, String direccion, String provincia, LocalDate fechaInicio, String email,
			String telefono, int cantidadEmpleados) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fechaInicio = fechaInicio;
		this.email = email;
		this.telefono = telefono;
		this.cantidadEmpleados = cantidadEmpleados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public int getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	public void setCantidadEmpleados(int cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}

}
