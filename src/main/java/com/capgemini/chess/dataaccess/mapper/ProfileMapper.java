package com.capgemini.chess.dataaccess.mapper;

import com.capgemini.chess.dataaccess.entities.ProfileEntity;
import com.capgemini.chess.service.to.ProfileTo;

public class ProfileMapper {

	public static ProfileEntity map(ProfileTo to) {
		ProfileEntity entity = new ProfileEntity();
		entity.setId(to.getId());
		entity.setName(to.getName());
		entity.setSurname(to.getSurname());
		entity.setAboutMe(to.getAboutMe());
		return entity;
	}

	public static ProfileTo map(ProfileEntity entity) {
		ProfileTo to = new ProfileTo();
		to.setId(entity.getId());
		to.setName(entity.getName());
		to.setSurname(entity.getSurname());
		to.setAboutMe(entity.getAboutMe());
		return to;
	}

}
