package com.Prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Prueba.entity.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	
	@Query("SELECT u FROM Usuario u WHERE u.correo = :correo OR u.cedula = :cedula")
	List<Usuario> listaUsuarios (@Param("correo") String correo, @Param("cedula") String cedula);

}
