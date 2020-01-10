package com.ciudad.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
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
	public List<CiudadEntity> Todos() {
		return (List<CiudadEntity>) ciuRepo.findAll();
	}
	
	@Override
	public void Guardar(List<CiudadEntity> ciudades) {
		ciudades.forEach(ciu -> {
		    ciu.setId(ciuCustom.idSig());
		});
		//ciuCustom.Logg(ciudades.toString());
		ciuRepo.saveAll(ciudades);
	}

	@Override
	public List<CiudadEntity> BuscarNombre(String name) {
		return (List<CiudadEntity>) ciuCustom.BuscarByName(name);
	}

	@Override
	public List<CiudadEntity> BuscarId(int id) {
		List<CiudadEntity> lista = new ArrayList<CiudadEntity>();
		try {
			lista.add(ciuRepo.findById(id).get());
		}catch(Exception e ) {
			return lista;
		}
		return lista;
	}
	

	@Override
	public List<CiudadEntity> Actualizar(List<CiudadEntity> ciudad) {
		List<CiudadEntity> lista = new ArrayList<CiudadEntity>();
		
		try {
			ciudad.forEach(ciu -> {
				if(ciuRepo.findById(ciu.getId()).isPresent()) {
					ciuRepo.save(ciu);
					lista.add(ciu); 
				} 
			});
		}catch(Exception e ) {
			return lista;
		}
		return lista;
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
