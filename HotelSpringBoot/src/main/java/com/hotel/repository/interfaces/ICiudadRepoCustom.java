package com.hotel.repository.interfaces;

import java.util.List;

import com.hotel.entity.CiudadEntity;

public interface ICiudadRepoCustom {
	
	public List<CiudadEntity> BuscarByName(String name);

}
