package com.capgemini.chess.dataaccess.dao;

import com.capgemini.chess.service.to.ProfileTO;
import com.capgemini.chess.service.to.UserTO;

public interface UserDAO {

	UserTO save(UserTO entity);

	UserTO findByEmail(String email);
	
	ProfileTO findByID(Long iD);
	
}