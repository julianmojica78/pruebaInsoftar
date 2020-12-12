package com.Prueba.interfaces;

import java.util.List;

public interface ICrud <T, T2, ID>{
	
	public List<T> listar();
	
	public T listarPorId(ID id);
	
	public T guardar(T obj);
	
	public T editar(T2 obj);
	
	public void eliminar(ID id);

}
