package com.capgemini.chess.service;

import com.capgemini.chess.service.to.UserTO;

public interface UserSaveService {
	
	UserTO save(UserTO to);
	
}
