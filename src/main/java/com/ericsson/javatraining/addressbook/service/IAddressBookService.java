package com.ericsson.javatraining.addressbook.service;

import java.util.List;

import com.ericsson.javatraining.addressbook.AddressItem;

public interface IAddressBookService {
	public List searchAddress(List addressBookList, String phoneNumber);
	
	public void addAddress(List addressBookList,AddressItem item);
	
}
