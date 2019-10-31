package com.hotel.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.hotel.entity.CiudadEntity;

@NoRepositoryBean
public interface ICiudadRepo extends JpaRepository<CiudadEntity, Integer>{
	
	public void Calcular(int a);

}
