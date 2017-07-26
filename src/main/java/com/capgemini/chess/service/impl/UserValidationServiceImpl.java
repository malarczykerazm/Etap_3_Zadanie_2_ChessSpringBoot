package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.UserValidationService;
import com.capgemini.chess.service.access.UserDao;
import com.capgemini.chess.service.to.RegistrationTo;
import com.capgemini.chess.service.to.UserTo;

@Service
public class UserValidationServiceImpl implements UserValidationService {

	@Autowired
	private UserDao userDao;

	@Override
	public void validate(RegistrationTo to) throws UserValidationException {
		validateEmail(to);
		validatePassword(to);
	}

	private void validateEmail(RegistrationTo to) throws UserValidationException {
		UserTo foundByEmail = userDao.findByEmail(to.getEmail());
		if (foundByEmail != null) {
			throw new UserValidationException("User with given email already exists");
		}
	}

	private void validatePassword(RegistrationTo to) throws UserValidationException {
		if (to.getPassword() != null && to.getPassword().length() < 8) {
			throw new UserValidationException("Password should be at least 8 characters long");
		}
	}
}
