package com.Prueba.dto;

import javax.validation.constraints.NotNull;

/**
 * Clase UsuarioDto es un pojo con los datos del usuario
 * 
 * @author DAVID
 *
 */
public class UsuarioDto {

	/**
	 * Atributo de id de los usuarios
	 */
	@NotNull(message = "Id es Requerido para Editar")
	private Integer id;

	/**
	 * Atributo de nombre del usuario
	 */
	private String nombre;

	/**
	 * Atributo de apellido del usuario
	 */
	private String apellido;

	/**
	 * Atributo de cedula del usuario
	 */
	private String cedula;

	/**
	 * Atributo del correo del usuario
	 */
	private String correo;

	/**
	 * Atributo del telefono del usuario
	 */
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
