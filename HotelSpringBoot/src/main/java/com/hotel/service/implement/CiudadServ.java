package com.hotel.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hotel.entity.CiudadEntity;
import com.hotel.repository.interfaces.ICiudadRepo;
import com.hotel.service.interfaces.ICiudadServ;

@Service
public class CiudadServ implements ICiudadServ{
	
	@Autowired
	//@Qualifier("postgresql")
	private ICiudadRepo ciuRepo;
	
	@Override
	public List<CiudadEntity> Todos() {
		return (List<CiudadEntity>) ciuRepo.findAll();
	}

	@Override
	public void Guardar(CiudadEntity ciudad) {
		ciuRepo.save(ciudad);
	}

	@Override
	public List<CiudadEntity> BuscarNombre(String name) {
		return (List<CiudadEntity>) ciuRepo.BuscarByName(name);
	}
}
