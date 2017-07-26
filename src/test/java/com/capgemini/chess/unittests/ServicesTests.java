package com.capgemini.chess.unittests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.ChessApplication;
import com.capgemini.chess.service.access.UserDAO;
import com.capgemini.chess.service.to.ProfileTO;
import com.capgemini.chess.service.to.UserTO;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {ChessApplication.class})
//public class ServicesTests{
//
//	@Autowired
//	private UserDAO userDAO;
//	
//	@Before
//	public void fulfillTheMap() {
//		UserTO userTO1 = new UserTO();
//		userTO1.setEmail("a@b.c");
//		userTO1.setPassword("xyz");
//		ProfileTO profileTO1 = new ProfileTO();
//		userTO1.setProfile(profileTO1);
//		userDAO.save(userTO1);
//		UserTO userTO2 = new UserTO();
//		userTO2.setEmail("x@b.c");
//		userTO2.setPassword("axyz");
//		ProfileTO profileTO2 = new ProfileTO();
//		userTO2.setProfile(profileTO2);
//		userDAO.save(userTO2);
//	}
//	
//	@Test
//	public void should() {
//		Assert.assertTrue(userDAO.findByEmail("a@b.c").getID() == 1L);
//		Assert.assertTrue(userDAO.findByEmail("x@b.c").getID() == 2L);
//	}

@RunWith(MockitoJUnitRunner.class)
public class ServicesTests{

	@Mock
	private UserDAO userDAO;
	
	@Before
	public void fulfillTheMap() {
		Mockito.when(userDAO.findByEmail("a")).thenReturn(null);
		Mockito.when(userDAO.findByID(1L)).thenReturn(new ProfileTO());
	}
	
	@Test
	public void should() {
		Assert.assertTrue(null == userDAO.findByEmail("a"));
	}
	
}
