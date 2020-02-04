package com.hotel.service;

import java.util.List;

import com.hotel.entity.HotelEntity;

public interface IHotelService {
	
	public List<HotelEntity> Todos() throws Exception;

	public List<HotelEntity> GuardarBloque(List<HotelEntity> hoteles) throws Exception;
	
	public HotelEntity Guardar(HotelEntity hotel) throws Exception;
	
	public HotelEntity Actualizar(HotelEntity hotel) throws Exception;
	
	public List<HotelEntity> BuscarNombre(String name) throws Exception;
	
	public HotelEntity BuscarId(int id) throws Exception;
	
	public int Borrar(int id) throws Exception;
	
	public void Logg(String data) throws Exception;
}
