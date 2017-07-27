package com.capgemini.chess.service.unittests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.dataaccess.dao.ChallengeDAO;
import com.capgemini.chess.enums.ChallengeStatus;
import com.capgemini.chess.service.challenge.ChallengeCreationService;
import com.capgemini.chess.service.challenge.impl.ChallengeCreationServiceImpl;
import com.capgemini.chess.service.challenge.impl.ChallengesSearchServiceImpl;
import com.capgemini.chess.service.to.ChallengeTO;

@RunWith(MockitoJUnitRunner.class)
public class ChallengeServiecesTests {
	
	private Long senderID;
	private Long recieverID;
	private ChallengeTO tO;
	private ChallengeCreationService challengeCreation;
	private ChallengeTO challenge1;
	private ChallengeTO challenge2;
	private ChallengeTO challenge3;
	private ChallengeTO challenge4;
	private ChallengeTO challenge5;
	private List<ChallengeTO> list;
	
	@Mock
	private ChallengeDAO challengeDAO;
	
	@Before
	public void setup() {
		challenge1 = new ChallengeTO();
		challenge1.setChallengeID(1L);
		challenge1.setSenderID(8L);
		challenge1.setRecieverID(20L);
		challenge1.setChallengeStatus(ChallengeStatus.REJECTED);
		
		challenge2 = new ChallengeTO();
		challenge2.setChallengeID(2L);
		challenge2.setSenderID(20L);
		challenge2.setRecieverID(9L);
		challenge2.setChallengeStatus(ChallengeStatus.ACCEPTED);
		
		challenge3 = new ChallengeTO();
		challenge3.setChallengeID(3L);
		challenge3.setSenderID(20L);
		challenge3.setRecieverID(1L);
		challenge3.setChallengeStatus(ChallengeStatus.AWAITING);
		
		challenge4 = new ChallengeTO();
		challenge4.setChallengeID(4L);
		challenge4.setSenderID(10L);
		challenge4.setRecieverID(20L);
		challenge4.setChallengeStatus(ChallengeStatus.REJECTED);
		
		challenge5 = new ChallengeTO();
		challenge5.setChallengeID(5L);
		challenge5.setSenderID(5L);
		challenge5.setRecieverID(20L);
		challenge5.setChallengeStatus(ChallengeStatus.AWAITING);
		
		List<ChallengeTO> list = new ArrayList<>();
		list.add(challenge1);
		list.add(challenge2);
		list.add(challenge3);
		list.add(challenge4);
		list.add(challenge5);
	}

	@Test
	public void shouldCreateNewChallengeWithoutAnID() {
		//given
		challengeCreation = new ChallengeCreationServiceImpl();
		senderID = new Long(1);
		recieverID = new Long(2);
		
		//when
		tO = challengeCreation.create(senderID, recieverID);

		//then
		Assert.assertEquals(new Long(1), tO.getSenderID());
		Assert.assertEquals(new Long(2), tO.getRecieverID());
		Assert.assertEquals(ChallengeStatus.AWAITING, tO.getChallengeStatus());
		Assert.assertEquals(null, tO.getChallengeID());
	}
	
	@Test
	public void shouldReturnListOfAwaitingChallanges() {
		
		//given
		Long searcherID = 20L;

		//when
		Mockito.when(challengeDAO.findByOneOfUsersID(searcherID)).thenReturn(list);
		ChallengesSearchServiceImpl challengeSearch = new ChallengesSearchServiceImpl();
		
		List<ChallengeTO> expectedList = new ArrayList<>();
		expectedList.add(challenge3);
		expectedList.add(challenge5);
		
		//then
		Assert.assertEquals(expectedList, challengeSearch.findAwaitingChallenges(searcherID));
	}

}
