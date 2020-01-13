package com.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotel.entity.CiudadEntity;
import com.hotel.entity.HotelEntity;
import com.hotel.repository.IHotelRepoCustom;
import com.hotel.service.IHotelService;
import com.hotel.repository.IHotelRepo;


@Service
public class HotelServiceImpl implements IHotelService{
	
	//Metodos Propios (Segun lenguaje)
	@Autowired
	@Qualifier("PSQL")
	private IHotelRepoCustom hotCustom;
	//Metodos JPA
	@Autowired
	private IHotelRepo hotRepo;
	//RestTemplate para hacer llamada a otros servicios
	@Autowired
	private RestTemplate Rest;
	
	@Override
	public List<HotelEntity> Todos() {
		return (List<HotelEntity>) hotRepo.findAll();
	}
	
	@Override
	public List<HotelEntity> Guardar(List<HotelEntity> Hoteles) {
		List<HotelEntity> lista = new ArrayList<HotelEntity>();
		
		try {
			Hoteles.forEach(hot -> {
				if(!hotRepo.findById(hot.getId()).isPresent()) {
					hotRepo.save(hot);
					lista.add(hot); 
				} 
			});
			return lista;
		}catch(Exception e ) {
			return lista;
		}
	}

	@Override
	public List<HotelEntity> BuscarNombre(String name) {
		List<HotelEntity> lista = new ArrayList<HotelEntity>();
		hotCustom.BuscarByName(name).stream().forEach((h) -> {
			h.setCiudad(Rest.getForObject("http://localhost:8082/CiudadById/" + h.getCiudad().getId(), CiudadEntity.class));
			lista.add(h);
		});
		return lista;
	}

	@Override
	public List<HotelEntity> BuscarId(int id) {
		
		List<HotelEntity> lista = new ArrayList<HotelEntity>();
		CiudadEntity ciu = new CiudadEntity();
		HotelEntity h = new HotelEntity();
		
		try {
			ciu = Rest.getForObject("http://localhost:8082/CiudadById/" + hotRepo.findById(id).get().getCiudad().getId(), CiudadEntity.class);
			h = hotRepo.findById(id).get();
			h.setCiudad(ciu);
			lista.add(h);
			return lista;
	
		}catch(Exception e ) {
			return lista;
		}
	}
	

	@Override
	public List<HotelEntity> Actualizar(List<HotelEntity> Hotel) {
		List<HotelEntity> lista = new ArrayList<HotelEntity>();
		
		try {
			Hotel.forEach(hot -> {
				if(hotRepo.findById(hot.getId()).isPresent()) {
					hotRepo.save(hot);
					lista.add(hot); 
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
		if(hotRepo.findById(id).isPresent()) {
			hotRepo.deleteById(id);
			res = 1;
		}
		return res;
	}

	@Override
	public void Logg(String data) {
		hotCustom.Logg(data);
	}

}
