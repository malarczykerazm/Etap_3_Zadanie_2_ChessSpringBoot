package com.capgemini.chess.service.user;

import com.capgemini.chess.service.to.RegistrationTO;
import com.capgemini.chess.service.to.UserTO;

public interface UserCreationService {
	
	UserTO create(RegistrationTO user);
	
}
