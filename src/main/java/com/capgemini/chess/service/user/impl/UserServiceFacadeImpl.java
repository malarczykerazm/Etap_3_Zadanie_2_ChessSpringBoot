package com.capgemini.chess.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.capgemini.chess.exceptions.UserValidationException;
import com.capgemini.chess.service.to.RegistrationTO;
import com.capgemini.chess.service.to.UserTO;
import com.capgemini.chess.service.user.UserRegistrationService;
import com.capgemini.chess.service.user.UserServiceFacade;

@Service
@Scope("singleton")
public class UserServiceFacadeImpl implements UserServiceFacade {

	@Autowired
	private UserRegistrationService registrationService;

	@Override
	public UserTO register(RegistrationTO to) throws UserValidationException {
		return registrationService.register(to);
	}

}
