package com.microservice.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.microservice.users.entity.UserEntity;

public interface IUserRepo extends JpaRepository<UserEntity, Long> {
	
	@Query("SELECT U FROM USER U WHERE U.NAME LIKE ?1%")
	public List<UserEntity> searchByName(String name);

}
