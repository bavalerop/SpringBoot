package com.microservice.users.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.microservice.users.entity.UserEntity;
import com.microservice.users.repository.IUserRepoCustom;
import static com.microservice.users.repository.QueryConstants.QUERY_USERS;

public class UserRepoImpl implements IUserRepoCustom{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<UserEntity> findAll() {
		Query q=entityManager.createNativeQuery(QUERY_USERS,UserEntity.class);
		List<UserEntity> list= new ArrayList<UserEntity>();
		list=q.getResultList();
		return list;
	}

	@Override
	public int save(UserEntity user) {
		return 0;
	}

	@Override
	public int saveInBlock(List<UserEntity> users) {
		return 0;
	}

	@Override
	public int update(UserEntity user) {
		return 0;
	}

	@Override
	public UserEntity findById(Long Id) {
		return null;
	}

	@Override
	public int delete(Long Id) {
		return 0;
	}

}
