package com.hotel.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hotel.entity.CiudadEntity;
import com.hotel.repository.implement.CiudadRepo;
import com.hotel.service.interfaces.ICiudadServ;

@Service
@Qualifier("JPA")
public class CiudadServ implements ICiudadServ {

	@Autowired
	@Qualifier("postgresql")
	private CiudadRepo ciuRepo;

	@Override
	public List<CiudadEntity> Todos() {
		return ciuRepo.findAll();
	}

	@Override
	public void Guardar(CiudadEntity ciudad) {
		ciuRepo.save(ciudad);
	}

}
