package com.capgemini.chess.service;

import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.to.RegistrationTo;
import com.capgemini.chess.service.to.UserTo;

public interface UserRegistrationService {
	public UserTo register(RegistrationTo user) throws UserValidationException;
}
