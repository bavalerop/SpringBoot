package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hotel.entity.CiudadEntity;
import com.hotel.repository.CiudadRepository;
import com.hotel.service.CiudadService;

@Service
public class CiudadServiceImpl implements CiudadService{
	
	@Autowired
	private CiudadRepository ciuRepo;
	
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
