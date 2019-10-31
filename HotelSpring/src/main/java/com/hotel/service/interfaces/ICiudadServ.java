package com.hotel.service.interfaces;

import java.util.List;

import com.hotel.entity.CiudadEntity;

public interface ICiudadServ {

	public List<CiudadEntity> Todos();

	public void Guardar(CiudadEntity ciudad);
}
