package com.capgemini.chess.service.user;

import com.capgemini.chess.exceptions.UserValidationException;
import com.capgemini.chess.service.to.RegistrationTO;
import com.capgemini.chess.service.to.UserTO;

public interface UserServiceFacade {
	
	UserTO register(RegistrationTO to) throws UserValidationException;
	
}
