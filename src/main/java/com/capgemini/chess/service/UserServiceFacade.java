package com.capgemini.chess.service;

import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.to.RegistrationTo;
import com.capgemini.chess.service.to.UserTo;

public interface UserServiceFacade {
	UserTo register(RegistrationTo to) throws UserValidationException;
}
