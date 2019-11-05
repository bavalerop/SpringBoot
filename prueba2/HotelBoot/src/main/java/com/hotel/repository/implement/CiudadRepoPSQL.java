package com.hotel.repository.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hotel.entity.CiudadEntity;
import com.hotel.repository.interfaces.ICiudadRepoCustom;

@Repository
@Qualifier("postgresql")
public class CiudadRepoPSQL implements ICiudadRepoCustom{
	
	 @PersistenceContext
	 EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<CiudadEntity> BuscarByName(String name) {
		 Query QR = entityManager.createNativeQuery("SELECT * FROM ciudad WHERE ciu_name LIKE '%?%'", CiudadEntity.class);
	     QR.setParameter(1, name);
	     return (List<CiudadEntity>) QR.getResultList();
	}

}
