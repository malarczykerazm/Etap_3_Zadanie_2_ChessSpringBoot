package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.capgemini.chess.service.UserSaveService;
import com.capgemini.chess.service.access.UserDAO;
import com.capgemini.chess.service.to.UserTO;

@Service
@Scope("singleton")
public class UserSaveServiceImpl implements UserSaveService {

	@Autowired
	private UserDAO userDao;

	@Override
	public UserTO save(UserTO to) {
		return userDao.save(to);
	}
}
