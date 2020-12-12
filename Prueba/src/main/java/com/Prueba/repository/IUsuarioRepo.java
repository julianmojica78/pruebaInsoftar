package com.Prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Prueba.entity.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

}
