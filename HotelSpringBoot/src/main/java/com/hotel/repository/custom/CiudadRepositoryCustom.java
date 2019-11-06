package com.hotel.repository.custom;

import java.util.List;

import com.hotel.entity.CiudadEntity;

public interface CiudadRepositoryCustom {

	public List<CiudadEntity> BuscarByName(String name);
}
