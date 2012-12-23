package com.ericsson.javatraining.addressbook.action;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.ericsson.javatraining.addressbook.AddressItem;
import com.ericsson.javatraining.addressbook.ServerDef;
import com.ericsson.javatraining.addressbook.util.StringUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ StringUtil.class })
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
		assertEquals(list, action.getAddressBook());
	}

	@Test
	public void testSetAddressBook() {
		List list = new ArrayList();
		action.setAddressBook(list);
		assertEquals(list, action.getAddressBook());
	}

	@Test
	public void testAbstractAddressAction() throws Exception {
		PowerMockito.mockStatic(StringUtil.class);
		PowerMockito.doReturn("James").when(StringUtil.class, "prompt",
				ServerDef.PROMPT_ADD_NAME);
		PowerMockito.doReturn("Shanghai").when(StringUtil.class, "prompt",
				ServerDef.PROMPT_ADD_ADDRESS);
		PowerMockito.doReturn("119").when(StringUtil.class, "prompt",
				ServerDef.PROMPT_ADD_MOBILE);
		PowerMockito.doNothing().when(StringUtil.class, "outputLine",
				ServerDef.OUTPUT_ADD_SUCCEED);

		action.action();
		AddressItem item = (AddressItem) action.getAddressBook().get(0);
		assertEquals(item.getName(), "James");
		assertEquals(item.getAddress(), "Shanghai");
		assertEquals(item.getPhoneNum(), "119");
	}

	public void testAbstractAddressActionWithIOException() throws Exception {
		PowerMockito.mockStatic(StringUtil.class);
		PowerMockito.doNothing().when(StringUtil.class,
				"prompt", ServerDef.PROMPT_ADD_NAME);
		PowerMockito.doThrow(new IOException()).when(BufferedReader.class,
				"readLine");
		action.action();

	}

}
