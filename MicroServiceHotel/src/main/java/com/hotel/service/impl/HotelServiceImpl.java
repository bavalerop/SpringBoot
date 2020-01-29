package com.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.clients.CiudadRest;
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
	private CiudadRest RestFeing;
	
	@Override
	public List<HotelEntity> Todos() throws Exception{
		return (List<HotelEntity>) hotRepo.findAll();
	}
	
	@Override
	//Rollback en la BD
	@Transactional(readOnly = true)
	public List<HotelEntity> GuardarBloque(List<HotelEntity> Hoteles) {		
		List<HotelEntity> listaHot = new ArrayList<HotelEntity>();
		try {
			Hoteles.stream().forEach((hot) -> {
				List<CiudadEntity> ciu = null;
				boolean f=false;
				ciu = (List<CiudadEntity>) RestFeing.findByID(hot.getCiudad().getId()).getBody();
				hotCustom.Logg("---->"+ciu);
//				id = ciu.get(0).getId();
//				if(id>0) {
//					listaHot.add(hot);
//					hot.setId(hotCustom.idSig());
//					hot.setCiudad(ciu.get(0));
//				}  
			});
			hotCustom.Logg(Hoteles.toString());
			hotRepo.saveAll(listaHot);
			return listaHot;
		}catch(Exception e ) {
			return null;
		}
	}
	
	@Override
	public HotelEntity Guardar(HotelEntity Hotel) {		
		List<HotelEntity> listaHot = new ArrayList<HotelEntity>();
		try {
//			Hoteles.stream().forEach((hot) -> {
			//------------------------
//				CiudadEntity ciu = null;
//				ciu=RestFeing.findByID(Hotel.getCiudad().getId()).getBody();
//				if(ciu != null) {
//					Hotel.setId(hotCustom.idSig());
//					Hotel.setCiudad(ciu);
//					hotRepo.save(Hotel);
//				}else {
//					return new throws Exception;
//				}
			//------------------------
//				List<CiudadEntity> ciu = null;
//				boolean f=false;
//				ciu = (List<CiudadEntity>) RestFeing.findByID(hot.getCiudad().getId()).getBody();
//				hotCustom.Logg("---->"+ciu);
//				id = ciu.get(0).getId();
//				if(id>0) {
//					listaHot.add(hot);
//					hot.setId(hotCustom.idSig());
//					hot.setCiudad(ciu.get(0));
//				}  
//			});
//			hotCustom.Logg(Hoteles.toString());
//			hotRepo.saveAll(listaHot);
			return null;
		}catch(Exception e ) {
			return null;
		}
	}

	@Override
	public List<HotelEntity> BuscarNombre(String name) {
		return (List<HotelEntity>) hotCustom.BuscarByName(name);
	}

	@Override
	public HotelEntity BuscarId(int id) {
		try {
			return hotRepo.findById(id).get();
		}catch(Exception e ) {
			return null;
		}
	}
	

	@Override
	public HotelEntity Actualizar(HotelEntity Hotel) {
		try {
			if(hotRepo.findById(Hotel.getId()).isPresent()) {
				hotRepo.save(Hotel);
				return Hotel;
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
