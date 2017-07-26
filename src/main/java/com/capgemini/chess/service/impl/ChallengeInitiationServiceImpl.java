package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.capgemini.chess.service.ChallengeCreationService;
import com.capgemini.chess.service.ChallengeInitiationService;
import com.capgemini.chess.service.access.ChallengeDAO;
import com.capgemini.chess.service.to.ChallengeTO;

@Service
@Scope("singleton")
public class ChallengeInitiationServiceImpl implements ChallengeInitiationService {

	@Autowired
	ChallengeCreationService challengeCreationService;
	
	@Autowired
	ChallengeDAO challengeDAO;
	
	@Override
	public ChallengeTO init(Long senderID, Long recieverID) {
		return challengeDAO.save(challengeCreationService.create(senderID, recieverID));
	}

	
}
