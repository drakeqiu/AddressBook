package com.ericsson.javatraining.addressbook.action;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Method;
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
		PowerMockito.doReturn("110").when(StringUtil.class, "prompt",
				"Please enter a phoneNum for search");
		PowerMockito.doReturn(true).when(StringUtil.class,"regmatch","\\d+","110");
		action.action();
	}

	@Test
	public void testActionWithAll() throws Exception {
		PowerMockito.mockStatic(StringUtil.class);
		PowerMockito.doReturn("all").when(StringUtil.class, "prompt",
				"Please enter a phoneNum for search");

		action.action();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testActionWithInvalidArguments() throws Exception {
		PowerMockito.mockStatic(StringUtil.class);
		PowerMockito.doReturn("James").when(StringUtil.class, "prompt",
				"Please enter a phoneNum for search");
		PowerMockito.doReturn(false).when(StringUtil.class,"regmatch","\\d+","James");

		action.action();
	}

	@Test
	public void testSearchAddress() throws Exception {
		Class[] parameterTypes = new Class[1];
		parameterTypes[0] = String.class;
		List list = null;
		Method method = action.getClass().getDeclaredMethod("searchAddress",
				String.class);
		Object[] args = new Object[1];
		method.setAccessible(true);
		list = (List) method.invoke(action, new Object[] { new String("110") });
		method.setAccessible(false);
		assertEquals("James", ((AddressItem) list.get(0)).getName());
	}
	
	@Test(expected=IOException.class)
	public void testActionWithThrowIOException() throws Exception {
		PowerMockito.mockStatic(StringUtil.class);
		PowerMockito.doReturn("110").when(StringUtil.class, "prompt",
				"Please enter a phoneNum for search");
		PowerMockito.doThrow(new IOException()).when(StringUtil.class, "prompt",
				"Please enter a phoneNum for search");

		action.action();
	}

}
