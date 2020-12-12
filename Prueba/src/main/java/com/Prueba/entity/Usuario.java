package com.Prueba.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = " El Nombre del Usuario es Requerido")
	@Size(min = 3, max = 60, message = "Longitud del Nombre Fuera de Desfase")
	@Column(nullable = false, length = 60)
	@Pattern(regexp = "[a-zA-Z_. ]*",message = "Solo Ingrese Caracteres")
	private String nombre;
	
	@NotNull(message = "Apellido del Usuario es Requerido")
	@Size(min = 3, max = 60, message = "Longitud del Apellido fuera de Desfase")
	@Column(nullable = false, length = 60)
	@Pattern(regexp = "[a-zA-Z_. ]*",message = "Solo Ingrese Caracteres")
	private String apellido;
	
	@NotNull(message = "Cedula del Usuario es Requerido")
	@Size(min = 8, max = 10, message = "Longitud de la Cedula Fuera de Desfase")
	@Column(nullable = false, length = 10)
	@Pattern(regexp = "[0-9]*",message = "Solo Ingrese Numeros")
	private String cedula;
	
	@NotNull(message = "Correo del Usuario es Requerido")
	@Column(nullable = false, length = 50)
	@Email
	private String correo;
	
	@NotNull(message = "Telefono del Usuario es Requerido")
	@Size(min = 6,max = 10 , message = "Telefono del Usuario Fuera de Desfase")
	@Column(nullable = false, length = 10)
	@Pattern(regexp = "[0-9]*",message = "Solo Ingrese Numeros")
	private String telefono;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
