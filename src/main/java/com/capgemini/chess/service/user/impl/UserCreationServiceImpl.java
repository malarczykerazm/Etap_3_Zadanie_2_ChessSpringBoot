package com.capgemini.chess.service.user.impl;

import com.capgemini.chess.service.to.ProfileTO;
import com.capgemini.chess.service.to.RegistrationTO;
import com.capgemini.chess.service.to.UserTO;
import com.capgemini.chess.service.user.UserCreationService;

public class UserCreationServiceImpl implements UserCreationService {

	@Override
	public UserTO create(RegistrationTO registration) {
		UserTO tO = new UserTO();
		tO.setEmail(registration.getEmail());
		tO.setPassword(registration.getPassword());
		tO.setProfile(new ProfileTO());
		return tO;
	}
}
