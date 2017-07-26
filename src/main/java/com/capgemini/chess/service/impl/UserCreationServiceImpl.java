package com.capgemini.chess.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.capgemini.chess.service.UserCreationService;
import com.capgemini.chess.service.to.ProfileTO;
import com.capgemini.chess.service.to.RegistrationTO;
import com.capgemini.chess.service.to.UserTO;

@Service
@Scope("singleton")
public class UserCreationServiceImpl implements UserCreationService {

	@Override
	public UserTO create(RegistrationTO registration) {
		UserTO tO = new UserTO();
		tO.setEmail(registration.getEmail());
		tO.setPassword(registration.getPassword());
		// TODO delegate to ProfileCreationService
		tO.setProfile(new ProfileTO());
		return tO;
	}
}
