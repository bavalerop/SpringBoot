package com.hotel.repository.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.hotel.MicroServiceHotelApplication;
import com.hotel.entity.HotelEntity;
import com.hotel.repository.IHotelRepoCustom;

@Repository("MMSQL")
public class HotelRepoImplMMSQL implements IHotelRepoCustom{
	
	@PersistenceContext
	EntityManager entityManager;
	private static Logger  Log = LoggerFactory.getLogger(MicroServiceHotelApplication.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HotelEntity> BuscarByName(String name) {
		List<HotelEntity> lista = new ArrayList<HotelEntity>();
		Query q = entityManager.createNativeQuery("SELECT * FROM hotel WHERE hot_nom LIKE '%" + name + "%'", HotelEntity.class);
	    lista=q.getResultList();
		Log.info("");
		return lista;
	}
	

	public void Logg(String data) {
		Log.info("---> "+data+" <----");
	}
}
