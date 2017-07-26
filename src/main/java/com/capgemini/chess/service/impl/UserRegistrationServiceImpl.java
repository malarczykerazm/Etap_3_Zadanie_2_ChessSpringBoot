package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.UserCreationService;
import com.capgemini.chess.service.UserRegistrationService;
import com.capgemini.chess.service.UserSaveService;
import com.capgemini.chess.service.UserValidationService;
import com.capgemini.chess.service.to.RegistrationTo;
import com.capgemini.chess.service.to.UserTo;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	@Autowired
	private UserSaveService saveService;

	@Autowired
	private UserCreationService creationService;

	@Autowired
	private UserValidationService validationService;

	@Override
	public UserTo register(RegistrationTo to) throws UserValidationException {
		validationService.validate(to);
		UserTo user = creationService.create(to);
		return saveService.save(user);
	}
}
