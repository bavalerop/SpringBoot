package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.entity.CiudadEntity;
import com.hotel.repository.custom.CiudadRepositoryCustom;

public interface CiudadRepository extends JpaRepository<CiudadEntity, Integer>, CiudadRepositoryCustom {

}
   