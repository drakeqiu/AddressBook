package com.ericsson.javatraining.addressbook.bo;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	private static ArrayList<AddressItem> addressList = new ArrayList<AddressItem>();

	private AddressBook() {

	}

	public static ArrayList<AddressItem> getAddressList() {
		return addressList;
	}

	public static void setAddressList(ArrayList<AddressItem> addressList) {
		AddressBook.addressList = addressList;
	}

	public static synchronized List<AddressItem> getAddressBook() {
		if (addressList == null) {
			addressList = new ArrayList<AddressItem>();
		}

		return addressList;
	}
}
