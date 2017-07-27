package com.capgemini.chess.service.user;

import com.capgemini.chess.exceptions.UserValidationException;
import com.capgemini.chess.service.to.RegistrationTO;
import com.capgemini.chess.service.to.UserTO;

public interface UserRegistrationService {
	
	UserTO register(RegistrationTO user) throws UserValidationException;
	
}
