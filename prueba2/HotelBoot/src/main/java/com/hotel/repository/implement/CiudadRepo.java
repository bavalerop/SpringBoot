package com.hotel.repository.implement;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.CiudadEntity;
import com.hotel.repository.interfaces.ICiudadRepo;

@Repository
@Qualifier("postgresql")
public class CiudadRepo extends SimpleJpaRepository<CiudadEntity, Integer> implements ICiudadRepo{

	public CiudadRepo(JpaEntityInformation<CiudadEntity, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Calcular(int a) {
		// TODO Auto-generated method stub
		
	}

	
}
