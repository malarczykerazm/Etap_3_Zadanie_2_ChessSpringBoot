package com.capgemini.chess.unittests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.service.access.UserDAO;

@RunWith(MockitoJUnitRunner.class)
public class MockTests {

	@Mock
	private UserDAO userDAO;
	
	@Test
	public void test() {
		Mockito.when(userDAO.findByEmail("a")).thenReturn(null);
		Mockito.when(userDAO.findByID(1L)).thenReturn(null);
		
	}

}
