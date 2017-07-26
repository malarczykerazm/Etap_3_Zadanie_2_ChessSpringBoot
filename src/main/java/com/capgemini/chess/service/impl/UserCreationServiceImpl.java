package com.capgemini.chess.service.impl;

import org.springframework.stereotype.Service;

import com.capgemini.chess.service.UserCreationService;
import com.capgemini.chess.service.to.ProfileTo;
import com.capgemini.chess.service.to.RegistrationTo;
import com.capgemini.chess.service.to.UserTo;

@Service
public class UserCreationServiceImpl implements UserCreationService {

	@Override
	public UserTo create(RegistrationTo registration) {
		UserTo to = new UserTo();
		to.setEmail(registration.getEmail());
		to.setPassword(registration.getPassword());
		// TODO delegate to ProfileCreationService
		to.setProfile(new ProfileTo());
		return to;
	}
}
