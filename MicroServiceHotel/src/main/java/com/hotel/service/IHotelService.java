package com.hotel.service;

import java.util.List;

import com.hotel.entity.HotelEntity;

public interface IHotelService {
	
	public List<HotelEntity> Todos() throws Exception;

	public List<HotelEntity> GuardarBloque(List<HotelEntity> hoteles);
	
	public HotelEntity Guardar(HotelEntity hotel);
	
	public HotelEntity Actualizar(HotelEntity hotel);
	
	public List<HotelEntity> BuscarNombre(String name);
	
	public HotelEntity BuscarId(int id);
	
	public int Borrar(int id);
	
	public void Logg(String data);
}
