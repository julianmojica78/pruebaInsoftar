package com.Prueba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Prueba.dto.UsuarioDto;
import com.Prueba.entity.Usuario;
import com.Prueba.interfaces.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	IUsuarioService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> listaUsuario = service.listar();
		return new ResponseEntity<List<Usuario>>(listaUsuario, HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Usuario> guardar(@Valid @RequestBody Usuario obj) {
		Usuario usuario = service.guardar(obj);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
	}
	
	@PutMapping("/editar")
	public ResponseEntity<Usuario> editar(@Valid @RequestBody UsuarioDto obj) {
		Usuario usuario = service.editar(obj);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
}
