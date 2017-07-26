package com.capgemini.chess.dataaccess.mapper;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.UserTO;

public class UserMapper {

	public static UserEntity map(UserTO to) {
		UserEntity user = new UserEntity();
		user.setEmail(to.getEmail());
		user.setID(to.getID());
		user.setPassword(to.getPassword());
		user.setProfile(ProfileMapper.map(to.getProfile()));
		return user;
	}

	public static UserTO map(UserEntity entity) {
		UserTO to = new UserTO();
		to.setEmail(entity.getEmail());
		to.setID(entity.getID());
		to.setPassword(entity.getPassword());
		to.setProfile(ProfileMapper.map(entity.getProfile()));
		return to;
	}

}
