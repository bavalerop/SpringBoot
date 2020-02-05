package com.microservice.users.service;

import java.util.List;

import com.microservice.users.entity.UserEntity;

public interface IUserService {
	
	public List<UserEntity> findAll();
	public int save(UserEntity user);
	public int saveInBlock(List<UserEntity> users);
	public int update(UserEntity user);
	public UserEntity findById(Long Id);
	public List<UserEntity> searchByName(String name);
	public int delete(Long Id);
}
