package com.ericsson.javatraining.addressbook.action;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.ericsson.javatraining.addressbook.util.StringUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest({StringUtil.class})
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
		List addressBook = new ArrayList();
		action.setAddressBook(addressBook);
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
	public void testAbstractAddressAction() throws Exception {
		PowerMock.mockStatic(StringUtil.class);
		Mockito.when(StringUtil.prompt("Please Enter name for address book")).thenReturn("James");
		Mockito.when(StringUtil.prompt("Please enter address for address book")).thenReturn("Shanghai");
		Mockito.when(StringUtil.prompt("Please Enter phoneNum for book")).thenReturn("119");
//		EasyMock.expect(StringUtil.prompt("Please Enter name for address book")).andReturn("James");
//		EasyMock.expect(StringUtil.prompt("Please enter address for address book")).andReturn("Shanghai");
//		EasyMock.expect(StringUtil.prompt("Please Enter phoneNum for book")).andReturn("110");
		PowerMockito.doNothing().when(StringUtil.class,"output");
//		EasyMock.expect(StringUtil.output("Successfully"));
//		EasyMock.expect(StringUtil.output("Successfully"));
//		PowerMock.replayAll();
		//EasyMock.verify(AddAddressAction.class);
		action.action();
	}

	

}
