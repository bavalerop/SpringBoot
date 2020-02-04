package com.ciudad.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciudad.entity.CiudadEntity;
import com.ciudad.repository.ICiudadRepoCustom;
import com.ciudad.service.ICiudadService;
import com.ciudad.repository.ICiudadRepo;


@Service
public class CiudadServiceImpl implements ICiudadService{
	
	//Metodos Propios (Segun lenguaje)
	@Autowired
	@Qualifier("PSQL")
	private ICiudadRepoCustom ciuCustom;
	//Metodos JPA
	@Autowired
	private ICiudadRepo ciuRepo;
	
	@Override
	public List<CiudadEntity> Todos() throws Exception{
		return (List<CiudadEntity>) ciuRepo.findAll();
	}
	
	@Override
	//Rollback en la BD
     @Transactional(readOnly = true)
	public List<CiudadEntity> GuardarBloque(List<CiudadEntity> ciudades) {
		ciudades.stream().forEach(ciu -> {
		    ciu.setId(ciuCustom.idSig());
		    ciuRepo.save(ciu);
		});
		return ciudades;
		//ciuCustom.Logg(ciudades.toString()); 
	}

	@Override
	public CiudadEntity Guardar(CiudadEntity ciudad) {
		ciudad.setId(ciuCustom.idSig());
		ciuRepo.save(ciudad);
		return ciudad;
	}

	@Override
	public List<CiudadEntity> BuscarNombre(String name) {
		return (List<CiudadEntity>) ciuCustom.BuscarByName(name);
	}

	@Override
	public CiudadEntity BuscarId(int id) {
		try {
			return ciuRepo.findById(id).get();
		}catch(Exception e ) {
			return null;
		}
	}
	

	@Override
	public CiudadEntity Actualizar(CiudadEntity ciudad) {
		try {
			if(ciuRepo.findById(ciudad.getId()).isPresent()) {
				ciuRepo.save(ciudad);
				return ciudad;
			}else {
				return null;
			} 
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public int Borrar(int id) {
		int res=0;
		if(ciuRepo.findById(id).isPresent()) {
			ciuRepo.deleteById(id);
			res = 1;
		}
		return res;
	}

	@Override
	public void Logg(String data) {
		ciuCustom.Logg(data);
		
	}
}
