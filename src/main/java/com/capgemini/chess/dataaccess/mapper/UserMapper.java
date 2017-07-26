package com.capgemini.chess.dataaccess.mapper;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.UserTo;

public class UserMapper {

	public static UserEntity map(UserTo to) {
		UserEntity user = new UserEntity();
		user.setEmail(to.getEmail());
		user.setId(to.getId());
		user.setPassword(to.getPassword());
		user.setProfile(ProfileMapper.map(to.getProfile()));
		return user;
	}

	public static UserTo map(UserEntity entity) {
		UserTo to = new UserTo();
		to.setEmail(entity.getEmail());
		to.setId(entity.getId());
		to.setPassword(entity.getPassword());
		to.setProfile(ProfileMapper.map(entity.getProfile()));
		return to;
	}

}
