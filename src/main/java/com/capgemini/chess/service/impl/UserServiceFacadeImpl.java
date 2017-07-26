package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.UserRegistrationService;
import com.capgemini.chess.service.UserServiceFacade;
import com.capgemini.chess.service.to.RegistrationTo;
import com.capgemini.chess.service.to.UserTo;

@Service
public class UserServiceFacadeImpl implements UserServiceFacade {

	@Autowired
	private UserRegistrationService registrationService;

	@Override
	public UserTo register(RegistrationTo to) throws UserValidationException {
		return registrationService.register(to);
	}

}
