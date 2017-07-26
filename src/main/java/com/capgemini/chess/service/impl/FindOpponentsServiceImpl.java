package com.capgemini.chess.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.ChallengeValidationService;
import com.capgemini.chess.service.FindOpponentsService;
import com.capgemini.chess.service.UserValidationService;
import com.capgemini.chess.service.access.ProfileDAO;
import com.capgemini.chess.service.access.UserDAO;
import com.capgemini.chess.service.to.ProfileTO;

@Service
@Scope("singleton")
public class FindOpponentsServiceImpl implements FindOpponentsService {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ProfileDAO profileDAO;

	@Autowired
	UserValidationService userValidationService;

	@Autowired
	ChallengeValidationService challengeValidationService;

	@Override
	public List<ProfileTO> findPotentialOpponents(ProfileTO tO, int assumedLevelRange) {
		try {
			userValidationService.validateID(tO.getID());			
		} catch(UserValidationException e) {
			System.out.println(e.getMessage());
		}
		return profileDAO.findProfilesWithinLevelRange(tO.getLevel(), assumedLevelRange).stream()
				.filter(p -> (p.getID() != tO.getID()
					&& challengeValidationService.isPotentialChallengeUnique(tO.getID(), p.getID())))
				.limit(5)
				.collect(Collectors.toList());
	}
	
	//TODO Wywalić z całego kodu co niepotrzebne.

}
