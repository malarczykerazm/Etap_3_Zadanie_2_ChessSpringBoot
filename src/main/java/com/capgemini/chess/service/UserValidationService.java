package com.capgemini.chess.service;

import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.to.RegistrationTo;

public interface UserValidationService {

	void validate(RegistrationTo to) throws UserValidationException;

}
