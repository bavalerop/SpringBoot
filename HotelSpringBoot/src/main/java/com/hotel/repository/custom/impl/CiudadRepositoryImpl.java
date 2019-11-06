package com.hotel.repository.custom.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.hotel.HotelSpringBootApplication;
import com.hotel.entity.CiudadEntity;
import com.hotel.repository.custom.CiudadRepositoryCustom;


@Repository
public class CiudadRepositoryImpl implements CiudadRepositoryCustom {
	
	@PersistenceContext
	 EntityManager entityManager;
	private static Logger  Log = LoggerFactory.getLogger(HotelSpringBootApplication.class);

	@SuppressWarnings("unchecked")
	@Override
	
	public List<CiudadEntity> BuscarByName(String name) {
		List<CiudadEntity> ciudades = entityManager.createNativeQuery("SELECT * FROM ciudad WHERE ciu_nom LIKE :nombre", CiudadEntity.class)
	    .setParameter("nombre", "'%"+name+"%'")
	    .getResultList();
		Log.info("");
		return ciudades;
	}

}
