package com.capgemini.chess.service.access;

import com.capgemini.chess.service.to.UserTo;

public interface UserDao {

	UserTo save(UserTo entity);

	UserTo findByEmail(String email);

}