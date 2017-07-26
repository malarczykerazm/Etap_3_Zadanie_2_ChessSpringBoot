package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.capgemini.chess.service.ChallengesSearchService;
import com.capgemini.chess.service.access.ChallengeDAO;
import com.capgemini.chess.service.to.ChallengeTO;

@Service
@Scope("singleton")
public class ChallengesSearchServiceImpl implements ChallengesSearchService {
	
	@Autowired
	ChallengeDAO challengeDAO;
	
	@Override
	public List<ChallengeTO> findAwaitingChallenges(Long searcherID) {
		return challengeDAO.findByOneOfUsersID(searcherID);
	}

}
