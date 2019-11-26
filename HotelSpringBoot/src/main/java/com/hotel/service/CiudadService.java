package com.hotel.service;

import java.util.List;

import com.hotel.entity.CiudadEntity;

public interface CiudadService {
	
	public List<CiudadEntity> Todos();

	public void Guardar(List<CiudadEntity> ciudad);
	
	public int Actualizar(CiudadEntity ciudad);
	
	public List<CiudadEntity> BuscarNombre(String name);
	
	public List<CiudadEntity> BuscarId(int id);
	
	public int Borrar(int id);
	
}
