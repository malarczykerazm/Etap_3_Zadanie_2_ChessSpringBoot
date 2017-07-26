package com.capgemini.chess.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.entities.ProfileEntity;
import com.capgemini.chess.dataaccess.mapper.ProfileMapper;
import com.capgemini.chess.service.access.ProfileDAO;
import com.capgemini.chess.service.to.ProfileTO;

@Repository
public class ProfileDAOImpl implements ProfileDAO {
	
	private final List<ProfileEntity> profiles = new ArrayList<>();

	@Override
	public ProfileTO save(ProfileTO tO) {
		ProfileEntity profile = ProfileMapper.map(tO);
		profiles.add(profile);
		return tO;
	}

	@Override
	public ProfileTO findByID(Long iD) {
		return profiles.stream()
				.map(p -> ProfileMapper.map(p))
				.filter(p -> p.getID().equals(iD)).findFirst()
				.orElse(null);
	}

}
