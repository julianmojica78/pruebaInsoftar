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


/**
 * Clase Usuario es un entity asociada a una tabal en la base de datos
 * @author DAVID
 *
 */
@Entity
@Table
public class Usuario {
	
	/**
	 * Atributo de id de los usuarios
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Atributo de nombre del usuario
	 */
	@NotNull(message = " El Nombre del Usuario es Requerido")
	@Size(min = 3, max = 60, message = "Longitud del Nombre Fuera de Desfase")
	@Column(nullable = false, length = 60)
	@Pattern(regexp = "[a-zA-Z_. ]*",message = "Solo Ingrese Caracteres")
	private String nombre;
	
	/**
	 * Atributo de apellido del usuario
	 */
	@NotNull(message = "Apellido del Usuario es Requerido")
	@Size(min = 3, max = 60, message = "Longitud del Apellido fuera de Desfase")
	@Column(nullable = false, length = 60)
	@Pattern(regexp = "[a-zA-Z_. ]*",message = "Solo Ingrese Caracteres")
	private String apellido;
	
	/**
	 * Atributo de cedula del usuario
	 */
	@NotNull(message = "Cedula del Usuario es Requerido")
	@Size(min = 8, max = 10, message = "Longitud de la Cedula Fuera de Desfase")
	@Column(nullable = false, length = 10)
	@Pattern(regexp = "[0-9]*",message = "Solo Ingrese Numeros")
	private String cedula;
	
	/**
	 * Atributo del correo del usuario
	 */
	@NotNull(message = "Correo del Usuario es Requerido")
	@Column(nullable = false, length = 50)
	@Email
	private String correo;
	
	/**
	 * Atributo del telefono del usuario
	 */
	@NotNull(message = "Telefono del Usuario es Requerido")
	@Size(min = 6,max = 10 , message = "Telefono del Usuario Fuera de Desfase")
	@Column(nullable = false, length = 10)
	@Pattern(regexp = "[0-9]*",message = "Solo Ingrese Numeros")
	private String telefono;

	/**
	 * retorna el id de los usuarios
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Modifica el id de los usuarios
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * retorna el nombre de los usuarios
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre de los usuarios
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Retorna el apellido de los usuarios
	 * @return apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * modifica el apellido de los usuarios
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Retorna la cedula de los usuarios
	 * @return cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * Modifica la cedula de los usuarios
	 * @param cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * Retorna el correo de los usuarios
	 * @return correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Modifica el correo de los usuarios
	 * @param correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Retorna el telefono de los usuarios
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Modifica el telefono de los usuarios
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
