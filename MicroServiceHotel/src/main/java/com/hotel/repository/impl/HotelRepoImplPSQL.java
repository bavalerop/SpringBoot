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

@Repository("PSQL")
public class HotelRepoImplPSQL implements IHotelRepoCustom{
	
	@PersistenceContext
	EntityManager entityManager;
	private static Logger  Log = LoggerFactory.getLogger(MicroServiceHotelApplication.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HotelEntity> BuscarByName(String name) {
		List<HotelEntity> lista = new ArrayList<HotelEntity>();
		Query q = entityManager.createNativeQuery("SELECT * FROM hotel WHERE UPPER(hot_nom) LIKE '%" + name.toUpperCase() + "%'", HotelEntity.class);
	    lista=q.getResultList();
		Log.info("");
		return lista;
	}
	
	@Override
	public int idSig() {
		int res = 0;
		Query q = entityManager.createNativeQuery("SELECT max(hot_nit) FROM hotel");
	    res=Integer.parseInt(q.getResultList().get(0).toString());
		//Log.info("-->:"+res);
		if(res>0) {
			res++;
		}
		return res;
	}
	
	public void Logg(String data) {
		Log.info("---> "+data+" <----");
	}

}
