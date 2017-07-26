package com.capgemini.chess.service;

import com.capgemini.chess.exception.ProfileValidationException;

public interface ProfileValidationService {
	
	void validateProfile(Long iD) throws ProfileValidationException;

}
