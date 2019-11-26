package com.hotel.repository.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Repository;
import com.hotel.HotelSpringBootApplication;
import com.hotel.entity.CiudadEntity;
import com.hotel.repository.CiudadRepoCustom;



@Repository("MMSQL")
public class CiudadRepoImplMMSQL implements CiudadRepoCustom {
	

	@PersistenceContext
	EntityManager entityManager;
	private static Logger  Log = LoggerFactory.getLogger(HotelSpringBootApplication.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<CiudadEntity> BuscarByName(String name) {
		List<CiudadEntity> lista = new ArrayList<CiudadEntity>();
		Query q = entityManager.createNativeQuery("SELECT * FROM ciudad WHERE ciu_nom LIKE :nombre", CiudadEntity.class);
	    q.setParameter("nombre", name);
	    lista=q.getResultList();
		Log.info("mmsql");
		return lista;
	}

}
