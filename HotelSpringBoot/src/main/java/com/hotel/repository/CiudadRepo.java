package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.hotel.entity.CiudadEntity;


public interface CiudadRepo extends JpaRepository<CiudadEntity, Integer>{
	
}
   