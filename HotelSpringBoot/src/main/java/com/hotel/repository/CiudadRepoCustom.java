package com.hotel.repository;

import java.util.List;

import com.hotel.entity.CiudadEntity;

public interface CiudadRepoCustom {
	
	public List<CiudadEntity> BuscarByName(String name);

}
