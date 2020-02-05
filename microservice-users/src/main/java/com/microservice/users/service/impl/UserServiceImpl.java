package com.microservice.users.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.users.entity.UserEntity;
import com.microservice.users.repository.IUserRepo;
import com.microservice.users.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepo userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<UserEntity> findAll() {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public int save(UserEntity user) {
		return 0;
	}

	@Override
	@Transactional(readOnly = true)
	public int saveInBlock(List<UserEntity> users) {
		return 0;
	}

	@Override
	@Transactional(readOnly = true)
	public int update(UserEntity user) {
		return 0;
	}

	@Override
	@Transactional(readOnly = true)
	public UserEntity findById(Long Id) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public int delete(Long Id) {
		return 0;
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserEntity> searchByName(String name) {
		return userRepository.searchByName(name);
	}

}
