package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.capgemini.chess.exception.ProfileValidationException;
import com.capgemini.chess.service.ProfileValidationService;
import com.capgemini.chess.service.access.ProfileDAO;

@Service
@Scope("singleton")
public class ProfileValidationServiceImpl implements ProfileValidationService {
	
	@Autowired
	ProfileDAO profileDAO;

	@Override
	public void validateProfile(Long iD) throws ProfileValidationException {
		if(null == profileDAO.findByID(iD)) {
			throw new ProfileValidationException("No such profile was found.");
		}
	}
	
}
