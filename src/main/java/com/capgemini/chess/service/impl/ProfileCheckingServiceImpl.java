package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.capgemini.chess.exception.ProfileValidationException;
import com.capgemini.chess.service.ProfileCheckingService;
import com.capgemini.chess.service.ProfileValidationService;
import com.capgemini.chess.service.access.ProfileDAO;
import com.capgemini.chess.service.to.ProfileTO;

@Service
@Scope("singleton")
public class ProfileCheckingServiceImpl implements ProfileCheckingService {

	@Autowired
	ProfileDAO profileDAO;
	
	@Autowired
	ProfileValidationService profileValidation;
	
	@Override
	public ProfileTO checkProfile(Long iD) {
		try {
			profileValidation.validateProfile(iD);
		} catch(ProfileValidationException e) {
			System.out.println(e.getMessage());
		}
		return profileDAO.findByID(iD);
	}
	
	

}
