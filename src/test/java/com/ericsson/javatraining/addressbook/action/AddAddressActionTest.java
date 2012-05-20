package com.ericsson.javatraining.addressbook.action;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class AddAddressActionTest {
	
	private AbstractAddressAction action;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		action = new AddAddressAction();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAction() {
	}

	@Test
	public void testGetAddressBook() {
		List list = new ArrayList();
		action.setAddressBook(list);
		assertEquals(list,action.getAddressBook());
	}

	@Test
	public void testSetAddressBook() {
		List list = new ArrayList();
		action.setAddressBook(list);
		assertEquals(list,action.getAddressBook());
	}

	@Test
	public void testAbstractAddressAction() {
	}

	@Test
	public void testObject() {
	}

	@Test
	public void testGetClass() {
	}


	@Test
	public void testEquals() {
	}

	@Test
	public void testClone() {
		fail("Not yet implemented"); // TODO
	}

}
