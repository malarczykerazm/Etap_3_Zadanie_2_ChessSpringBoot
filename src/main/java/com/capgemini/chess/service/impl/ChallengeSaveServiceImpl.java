package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.capgemini.chess.service.ChallengeSaveService;
import com.capgemini.chess.service.access.ChallengeDAO;
import com.capgemini.chess.service.to.ChallengeTO;

@Service
@Scope("singleton")
public class ChallengeSaveServiceImpl implements ChallengeSaveService {
	
	@Autowired
	private ChallengeDAO challengeDAO;

	@Override
	public ChallengeTO save(ChallengeTO tO) {
		return challengeDAO.save(tO);
	}

	
	
}
