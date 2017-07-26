package com.capgemini.chess.service;

import com.capgemini.chess.service.to.ChallengeTO;

public interface ChallengeInitiationService {

	ChallengeTO init(Long senderID, Long recieverID);
	
}
