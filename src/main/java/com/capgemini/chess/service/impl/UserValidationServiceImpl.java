package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.UserValidationService;
import com.capgemini.chess.service.access.UserDAO;
import com.capgemini.chess.service.to.RegistrationTO;

@Service
@Scope("singleton")
public class UserValidationServiceImpl implements UserValidationService {

	@Autowired
	private UserDAO userDao;

	@Override
	public void validate(RegistrationTO tO) throws UserValidationException {
		validateEmail(tO);
		validatePassword(tO);
	}
	
	@Override
	public void validateID(Long iD) throws UserValidationException {
		if (null != userDao.findByID(iD)) {
			throw new UserValidationException("User with given ID does not exist.");
		}
	}

	private void validateEmail(RegistrationTO tO) throws UserValidationException {
		if (null != userDao.findByEmail(tO.getEmail())) {
			throw new UserValidationException("User with given email already exists.");
		}
	}

	private void validatePassword(RegistrationTO to) throws UserValidationException {
		if (null != to.getPassword() && to.getPassword().length() < 8) {
			throw new UserValidationException("Password should be at least 8 characters long.");
		}
	}
}
