package com.ericsson.javatraining.addressbook.action;

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
import com.ericsson.javatraining.addressbook.util.StringUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ StringUtil.class })
public class SearchAddressActionTest {
	private AbstractAddressAction action;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		action = new SearchAddressAction();
		List addressBook = new ArrayList();
		AddressItem addressForJames = new AddressItem("James", "Shanghai",
				"110");
		AddressItem addressForDavid = new AddressItem("David", "Beijing", "999");
		addressBook.add(addressForDavid);
		addressBook.add(addressForJames);
		action.setAddressBook(addressBook);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAction() throws Exception {
		PowerMockito.mockStatic(StringUtil.class);
		PowerMockito.doReturn("James").when(StringUtil.class, "prompt",
				"Please enter a phoneNum for search");
		PowerMockito.doReturn("Shanghai").when(StringUtil.class, "prompt",
				"Please enter address for address book");
		PowerMockito.doReturn("119").when(StringUtil.class, "prompt",
				"Please Enter phoneNum for book");
		PowerMockito.doNothing().when(StringUtil.class, "output",
				"Successfully");

		action.action();
	}

}
