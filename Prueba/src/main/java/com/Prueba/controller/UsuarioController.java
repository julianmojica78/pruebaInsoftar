package com.Prueba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Prueba.dto.UsuarioDto;
import com.Prueba.entity.Usuario;
import com.Prueba.interfaces.IUsuarioService;


/**
 * Clase UsuarioController que recibe las peticiones del navegador
 * @author DAVID
 *
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	IUsuarioService service;
	
	
	/**
	 * Metodo que permite listar los usuarios a través de pageable 
	 * @param pageable
	 * @return listaUsuario, HttpStatus.OK
	 */
	@GetMapping("/listar")
	public ResponseEntity<Page<Usuario>> listar(Pageable pageable) {
		Page<Usuario> listaUsuario = service.listarPaginado(pageable);
		return new ResponseEntity<Page<Usuario>>(listaUsuario, HttpStatus.OK);
	}
	
	/**
	 * Metodo que retorna el usuario segun el id
	 * @param id
	 * @return usuario, HttpStatus.OK
	 */
	@GetMapping("/usuarioId/{id}")
	public ResponseEntity<Usuario> usuarioId(@PathVariable Integer id){
		Usuario usuario = service.listarPorId(id);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);		
	}
	/**
	 * Metodo que permite guardar usuarios en la Base de Datos
	 * @param obj
	 * @return usuario, HttpStatus.CREATED
	 */
	
	@PostMapping("/guardar")
	public ResponseEntity<Usuario> guardar(@Valid @RequestBody Usuario obj) {
		Usuario usuario = service.guardar(obj);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
	}
	
	/**
	 * Metodo que permite editar el usuario y almacenarlo los cambios en la BD
	 * @param obj
	 * @return usuario, HttpStatus.OK
	 */
	@PutMapping("/editar")
	public ResponseEntity<Usuario> editar(@Valid @RequestBody UsuarioDto obj) {
		Usuario usuario = service.editar(obj);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
}
