package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.service.UserSaveService;
import com.capgemini.chess.service.access.UserDao;
import com.capgemini.chess.service.to.UserTo;

@Service
public class UserSaveServiceImpl implements UserSaveService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserTo save(UserTo to) {
		return userDao.save(to);
	}
}
