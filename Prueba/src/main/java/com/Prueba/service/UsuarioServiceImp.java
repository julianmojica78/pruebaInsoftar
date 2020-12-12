package com.Prueba.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prueba.dto.UsuarioDto;
import com.Prueba.entity.Usuario;
import com.Prueba.exception.NotFoundModelException;
import com.Prueba.interfaces.IUsuarioService;
import com.Prueba.repository.IUsuarioRepo;

@Service
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	IUsuarioRepo repo;

	@Override
	public List<Usuario> listar() {
		List<Usuario> listaUsuario = repo.findAll();
		return listaUsuario;
	}

	@Override
	public Usuario listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario guardar(Usuario obj) {
		List<Usuario> listaUsuario = repo.findAll();
		for (Usuario usuario : listaUsuario) {
			if (usuario.getCorreo().equals(obj.getCorreo())) {
				throw new NotFoundModelException("Correo ya Registrado");
			} else if (usuario.getCedula().equals(obj.getCedula())) {
				throw new NotFoundModelException("Cedula ya Registrado");
			}
		}
		return repo.save(obj);
	}

	@Override
	public Usuario editar(UsuarioDto obj) {
		repo.findById(obj.getId()).orElseThrow(() -> new NotFoundModelException("Usuario no Encontrado"));

		ModelMapper modelMapper = new ModelMapper();
		Usuario usuario = modelMapper.map(obj, Usuario.class);

		return repo.save(usuario);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub

	}

}
