package com.capgemini.chess.service.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.capgemini.chess.service.challenge.ChallengeInitiationService;
import com.capgemini.chess.service.challenge.ChallengesSearchService;
import com.capgemini.chess.service.challenge.FindOpponentsService;
import com.capgemini.chess.service.facade.MultiPlayerGameSetupAndPointsFacade;
import com.capgemini.chess.service.profile.ProfileCheckingService;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.ProfileTO;

@Service
@Scope("singleton")
public class MultiPlayerGameSetupAndPointsFacadeImpl implements MultiPlayerGameSetupAndPointsFacade {

	@Autowired
	private FindOpponentsService findOpponents;
	
	@Autowired
	private ChallengeInitiationService challengeInitiation;
	
	@Autowired
	private ChallengesSearchService challengesSearch;
	
	@Autowired
	private ProfileCheckingService profileChecking;
	
	@Override
	public List<ProfileTO> findPotentialOpponents(ProfileTO tO, int range) {
		return findOpponents.findPotentialOpponents(tO, range);			
	}

	@Override
	public ChallengeTO initNewChallenge(Long senderID, Long recieverID) {
		return challengeInitiation.init(senderID, recieverID);
	}

	@Override
	public List<ChallengeTO> findAwaitingChallenges(Long searcherID) {
		return challengesSearch.findAwaitingChallenges(searcherID);
	}
	
	@Override
	public ProfileTO checkProfile(Long iD) {
		return profileChecking.checkProfile(iD);
	}

}
