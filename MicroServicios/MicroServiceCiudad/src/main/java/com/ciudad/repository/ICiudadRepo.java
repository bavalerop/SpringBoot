package com.ciudad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ciudad.entity.CiudadEntity;

public interface ICiudadRepo extends JpaRepository<CiudadEntity, Integer>{

}
