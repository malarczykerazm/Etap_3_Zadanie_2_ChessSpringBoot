package com.capgemini.chess.service.challenge;

import java.util.List;

import com.capgemini.chess.service.to.ChallengeTO;

public interface ChallengesSearchService {

	List<ChallengeTO> findAwaitingChallenges(Long searcherID);
	
}
