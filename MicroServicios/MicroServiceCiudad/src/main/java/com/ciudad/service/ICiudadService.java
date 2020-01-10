package com.ciudad.service;

import java.util.List;
import com.ciudad.entity.CiudadEntity;

public interface ICiudadService {
	
	public List<CiudadEntity> Todos();

	public void Guardar(List<CiudadEntity> ciudad);
	
	public List<CiudadEntity> Actualizar(List<CiudadEntity> ciudad);
	
	public List<CiudadEntity> BuscarNombre(String name);
	
	public List<CiudadEntity> BuscarId(int id);
	
	public int Borrar(int id);
	
	public void Logg(String data);
	
}
