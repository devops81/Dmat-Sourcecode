package com.devopps.portal.dao;

import java.util.List;

import com.devopps.portal.model.UserEntity;

public interface IUserDetailsDao {
	
	void save(UserEntity userEntity);
	List<UserEntity> listUser();
}
