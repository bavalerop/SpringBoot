package com.ciudad.service;

import java.util.List;
import com.ciudad.entity.CiudadEntity;

public interface ICiudadService {
	
	public List<CiudadEntity> Todos();

	public List<CiudadEntity> GuardarBloque(List<CiudadEntity> ciudades);
	
	public CiudadEntity Guardar(CiudadEntity ciudad);
	
	public CiudadEntity Actualizar(CiudadEntity ciudad);
	
	public List<CiudadEntity> BuscarNombre(String name);
	
	public CiudadEntity BuscarId(int id);
	
	public int Borrar(int id);
	
	public void Logg(String data);
	
}
