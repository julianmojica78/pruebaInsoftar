package com.Prueba.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Prueba.dto.UsuarioDto;
import com.Prueba.entity.Usuario;

public interface IUsuarioService extends ICrud<Usuario, UsuarioDto, Integer>{
	
	public Page<Usuario> listarPaginado(Pageable pageable);
	
}
