package com.ciudad.service;

import java.util.List;
import com.ciudad.entity.CiudadEntity;

public interface ICiudadService {
	
	public List<CiudadEntity> Todos() throws Exception;

	public List<CiudadEntity> GuardarBloque(List<CiudadEntity> ciudades) throws Exception;
	
	public CiudadEntity Guardar(CiudadEntity ciudad) throws Exception;
	
	public CiudadEntity Actualizar(CiudadEntity ciudad) throws Exception;
	
	public List<CiudadEntity> BuscarNombre(String name) throws Exception;
	
	public CiudadEntity BuscarId(int id) throws Exception;
	
	public int Borrar(int id) throws Exception;
	
	public void Logg(String data) throws Exception;
	
}
