package com.capgemini.chess.service.facade;

import java.util.List;

import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.ProfileTO;

public interface MultiPlayerGameSetupAndPointsFacade {

	List<ProfileTO> findPotentialOpponents(ProfileTO tO, int range);
	
	ChallengeTO initNewChallenge(Long senderID, Long recieverID);
	
	List<ChallengeTO> findAwaitingChallenges(Long searcherID);
	
	ProfileTO checkProfile(Long iD);
	
}
