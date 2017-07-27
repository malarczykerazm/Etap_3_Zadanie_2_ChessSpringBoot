package com.capgemini.chess.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.capgemini.chess.exceptions.UserValidationException;
import com.capgemini.chess.service.to.RegistrationTO;
import com.capgemini.chess.service.to.UserTO;
import com.capgemini.chess.service.user.UserCreationService;
import com.capgemini.chess.service.user.UserRegistrationService;
import com.capgemini.chess.service.user.UserSaveService;
import com.capgemini.chess.service.user.UserValidationService;

@Service
@Scope("singleton")
public class UserRegistrationServiceImpl implements UserRegistrationService {
	
	@Autowired
	private UserSaveService saveService;

	@Autowired
	private UserCreationService creationService;

	@Autowired
	private UserValidationService validationService;

	@Override
	public UserTO register(RegistrationTO to) throws UserValidationException {
		validationService.validate(to);
		UserTO user = creationService.create(to);
		return saveService.save(user);
	}
}
