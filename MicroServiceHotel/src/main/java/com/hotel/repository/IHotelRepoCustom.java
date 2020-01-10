package com.hotel.repository;

import java.util.List;

import com.hotel.entity.HotelEntity;

public interface IHotelRepoCustom {

	public List<HotelEntity> BuscarByName(String name);
	
	public void Logg(String data);

}
