package com.Prueba.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Prueba.dto.UsuarioDto;
import com.Prueba.entity.Usuario;
import com.Prueba.exception.NotFoundModelException;
import com.Prueba.interfaces.IUsuarioService;
import com.Prueba.repository.IUsuarioRepo;


/**
 * Clase UsuarioServiceImp se desarrolla la logica de usuarios y la conexion con la base de datos
 * @author DAVID
 *
 */
@Service
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	IUsuarioRepo repo;

	/**
	 * Metodo que me retorna los usuarios de la base de datos
	 */
	@Override
	public List<Usuario> listar() {
		List<Usuario> listaUsuario = repo.findAll();
		return listaUsuario;
	}

	/**
	 * Metodo que me retorna el usuario de la base de datos segun el id que le manden
	 */
	@Override
	public Usuario listarPorId(Integer id) {
		Usuario usuario = repo.findById(id).orElseThrow(
				() -> new NotFoundModelException("Consulta no encontrada"));
		return usuario;
	}

	/**
	 * Metodo que le permite guardar en la base de datos los usuarios
	 */
	@Override
	public Usuario guardar(Usuario obj) {

		List<Usuario> usuario = repo.listaUsuarios(obj.getCorreo(), obj.getCedula());
		for (Usuario usuario2 : usuario) {
			if (usuario2.getCorreo().equals(obj.getCorreo())) {
				throw new NotFoundModelException("Correo ya Registrado");
			}
			if (usuario2.getCedula().equals(obj.getCedula())) {
				throw new NotFoundModelException("Cedula ya Registrada");
			}
		}
		return repo.save(obj);
	}

	/**
	 * Metodo que permite la edición de los usuarios 
	 */
	@Override
	public Usuario editar(UsuarioDto obj) {
		Usuario user = repo.findById(obj.getId())
				.orElseThrow(() -> new NotFoundModelException("Usuario no Encontrado"));

		ModelMapper modelMapper = new ModelMapper();
		Usuario usuario = modelMapper.map(obj, Usuario.class);

		if (user.getCorreo().equals(usuario.getCorreo()) & user.getCedula().equals(usuario.getCedula())) {
			return repo.save(usuario);
		} else {
			List<Usuario> listaUsuario = repo.listaUsuarios(obj.getCorreo(), obj.getCedula());
			for (Usuario usuario2 : listaUsuario) {
				if (usuario2.getCorreo().equals(obj.getCorreo())) {
					throw new NotFoundModelException("Correo ya Registrado");
				}
				if (usuario2.getCedula().equals(obj.getCedula())) {
					throw new NotFoundModelException("Cedula ya Registrada");
				}
			}

		}
		return repo.save(usuario);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub

	}

	/**
	 * Metodo que me retorna la lista de usuarios en limites
	 */
	@Override
	public Page<Usuario> listarPaginado(Pageable pageable) {
		return repo.findAll(pageable);
	}
}
