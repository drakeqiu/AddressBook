package com.ericsson.javatraining.addressbook;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddressItemTest {
	private AddressItem item;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		item = new AddressItem();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddressItemString() {
		item = new AddressItem("AddressItem [name=David, address=Beijing, phoneNum=999]");
		assertEquals("David", item.getName());
		assertEquals("Beijing", item.getAddress());
		assertEquals("999", item.getPhoneNum());
	}

	@Test
	public void testAddressItemStringStringString() {
		item = new AddressItem("James","Shanghai","110");
		assertEquals("James", item.getName());
		assertEquals("Shanghai", item.getAddress());
		assertEquals("110", item.getPhoneNum());
	}

	@Test
	public void testSetAddress() {
		item.setAddress("Shanghai");
		assertEquals("Shanghai", item.getAddress());
	}

	@Test
	public void testSetName() {
		item.setName("James");
		assertEquals("James", item.getName());
	}

	@Test
	public void testSetPhoneNum() {
		item.setPhoneNum("110");
		assertEquals("110", item.getPhoneNum());
	}

}
