package com.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.hotel.entity.CiudadEntity;
import com.hotel.repository.CiudadRepoCustom;
import com.hotel.repository.CiudadRepo;
import com.hotel.service.CiudadService;

@Service
public class CiudadServiceImpl implements CiudadService{
	
	//Metodos Propios (Segun lenguaje)
	@Autowired
	@Qualifier("PSQL")
	private CiudadRepoCustom ciuCustom;
	//Metodos JPA
	@Autowired
	private CiudadRepo ciuRepo;
	
	@Override
	public List<CiudadEntity> Todos() {
		return (List<CiudadEntity>) ciuRepo.findAll();
	}

	@Override
	public void Guardar(List<CiudadEntity> ciudades) {
		ciuRepo.saveAll(ciudades);
	}

	@Override
	public List<CiudadEntity> BuscarNombre(String name) {
		return (List<CiudadEntity>) ciuCustom.BuscarByName(name);
	}

	@Override
	public List<CiudadEntity> BuscarId(int id) {
		List<CiudadEntity> lista = new ArrayList<CiudadEntity>();
		lista.add(ciuRepo.getOne(id));
		return lista;
	}
}
