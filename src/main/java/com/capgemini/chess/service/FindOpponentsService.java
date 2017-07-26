package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.service.to.ProfileTO;

public interface FindOpponentsService {
	
	List<ProfileTO> findPotentialOpponents(ProfileTO tO, int range);
}
