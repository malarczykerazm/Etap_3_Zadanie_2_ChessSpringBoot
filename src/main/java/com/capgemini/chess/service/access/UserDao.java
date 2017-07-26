package com.capgemini.chess.service.access;

import java.util.List;

import com.capgemini.chess.service.to.ProfileTO;
import com.capgemini.chess.service.to.UserTO;

public interface UserDAO {

	UserTO save(UserTO entity);

	UserTO findByEmail(String email);
	
	ProfileTO findByID(Long iD);
	
	List<ProfileTO> findUsersWithinLevelRange(int level, int assumedLevelRange);

}