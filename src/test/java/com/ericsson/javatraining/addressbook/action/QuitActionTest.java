package com.ericsson.javatraining.addressbook.action;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuitActionTest {
	private AbstractAddressAction action;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		action = new QuitAction();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAction() {
		try {
			action.action();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}