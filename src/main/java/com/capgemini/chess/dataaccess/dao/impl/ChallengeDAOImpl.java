package com.capgemini.chess.dataaccess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.mapper.ChallengeMapper;
import com.capgemini.chess.service.access.ChallengeDAO;
import com.capgemini.chess.service.to.ChallengeTO;

@Repository
@Scope("singleton")
public class ChallengeDAOImpl implements ChallengeDAO {
	
	private final Map<Long, ChallengeEntity> challenges = new HashMap<>();
	
	@Override
	public ChallengeTO save(ChallengeTO tO) {
		Long iD = generateID();
		tO.setChallengeID(iD);
		ChallengeEntity challenge = ChallengeMapper.map(tO);
		challenges.put(iD, challenge);
		return ChallengeMapper.map(challenge);
	}

	@Override
	public ChallengeTO findByUserIDs(Long senderID, Long recieverID) {
		return challenges
				.values()
				.stream()
				.map(ch -> ChallengeMapper.map(ch))
				.filter(ch -> (ch.getSenderID().equals(senderID) && ch.getRecieverID().equals(recieverID))
						|| (ch.getSenderID().equals(recieverID) && ch.getRecieverID().equals(senderID)))
				.findFirst()
				.orElse(null);
	}
	
	@Override
	public List<ChallengeTO> findByOneOfUsersID(Long iD) {
		return challenges
				.values()
				.stream()
				.map(ch -> ChallengeMapper.map(ch))
				.filter(ch -> ch.getSenderID().equals(iD) || ch.getRecieverID().equals(iD))
				.collect(Collectors.toList());
	}
	
	private Long generateID() {
		return challenges.keySet().stream().max((i1, i2) -> i1.compareTo(i2)).orElse(0L) + 1;
	}

}
