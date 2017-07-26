package com.capgemini.chess.service.access;

import com.capgemini.chess.service.to.ProfileTO;

public interface ProfileDAO {

	ProfileTO findByID(Long iD);
	
	ProfileTO save(ProfileTO tO);
	
}