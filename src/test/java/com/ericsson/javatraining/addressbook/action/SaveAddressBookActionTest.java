package com.ericsson.javatraining.addressbook.action;

import static org.junit.Assert.*;

import java.io.File;
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
import com.ericsson.javatraining.addressbook.util.FileUtil;
import com.ericsson.javatraining.addressbook.util.StringUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ FileUtil.class })
public class SaveAddressBookActionTest {

	private AbstractAddressAction action;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		action = new SaveAddressBookAction();
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
		PowerMockito.mockStatic(FileUtil.class);
		PowerMockito.doNothing().when(FileUtil.class,"save",ServerDef.ADDRESSSTOREPATH,action.getAddressBook());
		action.action();
	}

}
