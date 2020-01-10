package com.ciudad.repository.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.ciudad.MicroServiceCiudadApplication;
import com.ciudad.entity.CiudadEntity;
import com.ciudad.repository.ICiudadRepoCustom;

@Repository("PSQL")
public class CiudadRepoImplPSQL implements ICiudadRepoCustom{
	
	@PersistenceContext
	EntityManager entityManager;
	private static Logger  Log = LoggerFactory.getLogger(MicroServiceCiudadApplication.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CiudadEntity> BuscarByName(String name) {
		List<CiudadEntity> lista = new ArrayList<CiudadEntity>();
		Query q = entityManager.createNativeQuery("SELECT * FROM ciudad WHERE UPPER(ciu_nom) LIKE '%" + name.toUpperCase() + "%'", CiudadEntity.class);
	    lista=q.getResultList();
		Log.info("");
		return lista;
	}
	
	public void Logg(String data) {
		Log.info("---> "+data+" <----");
	}

	@Override
	public int idSig() {
		int res = 0;
		Query q = entityManager.createNativeQuery("SELECT max(ciu_id) FROM ciudad");
	    res=Integer.parseInt(q.getResultList().get(0).toString());
		//Log.info("-->:"+res);
		if(res>0) {
			res++;
		}
		return res;
	}

}
