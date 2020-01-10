package com.hotel.service;

import java.util.List;

import com.hotel.entity.HotelEntity;

public interface IHotelService {
	
	public List<HotelEntity> Todos();

	public List<HotelEntity> Guardar(List<HotelEntity> hotel);
	
	public List<HotelEntity> Actualizar(List<HotelEntity> hotel);
	
	public List<HotelEntity> BuscarNombre(String name);
	
	public List<HotelEntity> BuscarId(int id);
	
	public int Borrar(int id);
	
	public void Logg(String data);
}
