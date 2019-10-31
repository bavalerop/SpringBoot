package com.hotel.repository.interfaces;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.CiudadEntity;

@Repository
public interface ICiudadRepo extends CrudRepository<CiudadEntity, Integer> {


}
