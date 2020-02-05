package com.microservice.users.repository;

import java.util.List;

import com.microservice.users.entity.UserEntity;

public interface IUserRepoCustom {
	public List<UserEntity> findAll();
	public int save(UserEntity user);
	public int saveInBlock(List<UserEntity> users);
	public int update(UserEntity user);
	public UserEntity findById(Long Id);
	public int delete(Long Id);
}
