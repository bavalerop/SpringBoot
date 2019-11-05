package com.hotel.repository.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hotel.HotelSpringBootApplication;
import com.hotel.entity.CiudadEntity;
import com.hotel.repository.interfaces.ICiudadRepoCustom;


@Repository
public class CiudadRepoPSQL implements ICiudadRepoCustom {
	
	@PersistenceContext
	 EntityManager entityManager;
	private static Logger  Log = LoggerFactory.getLogger(HotelSpringBootApplication.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<CiudadEntity> BuscarByName(String name) {
		// Query QR = entityManager.createNativeQuery("SELECT * FROM ciudad WHERE ciu_nom LIKE '%?%'", CiudadEntity.class);
	    // QR.setParameter(1, name);
	     Log.info("===> "+"PRUEBA"+ "<====");
	     //return (List<CiudadEntity>) QR.getResultList();
	     return null;
	}

}
