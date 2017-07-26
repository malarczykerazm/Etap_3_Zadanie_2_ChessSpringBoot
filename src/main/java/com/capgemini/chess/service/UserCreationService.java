package com.capgemini.chess.service;

import com.capgemini.chess.service.to.RegistrationTo;
import com.capgemini.chess.service.to.UserTo;

public interface UserCreationService {
	UserTo create(RegistrationTo user);
}
