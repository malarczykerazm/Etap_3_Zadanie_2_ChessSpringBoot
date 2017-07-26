package com.capgemini.chess.dataaccess.mapper;

import com.capgemini.chess.dataaccess.entities.ProfileEntity;
import com.capgemini.chess.service.to.ProfileTO;

public class ProfileMapper {

	public static ProfileEntity map(ProfileTO to) {
		ProfileEntity entity = new ProfileEntity();
		entity.setID(to.getID());
		entity.setName(to.getName());
		entity.setSurname(to.getSurname());
		entity.setAboutMe(to.getAboutMe());
		return entity;
	}

	public static ProfileTO map(ProfileEntity entity) {
		ProfileTO to = new ProfileTO();
		to.setID(entity.getID());
		to.setName(entity.getName());
		to.setSurname(entity.getSurname());
		to.setAboutMe(entity.getAboutMe());
		return to;
	}

}
