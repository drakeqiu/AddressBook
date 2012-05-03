package com.ericsson.javatraining.addressbook.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ericsson.javatraining.addressbook.bo.AddressItem;
import com.ericsson.javatraining.addressbook.util.StringUtil;

public class AddressBookServiceImpl implements IAddressBookService {

	@Override
	public List searchAddress(List addressBookList, String number) {
		// TODO Auto-generated method stub
		if (addressBookList == null) {
			return null;
		}
		ArrayList resultList = new ArrayList();
		Iterator it = addressBookList.iterator();
		while (it.hasNext()) {
			AddressItem item = (AddressItem) it.next();
			String phoneNum = item.getPhoneNum();
			if (phoneNum != null && !("".equals(phoneNum))
					&& phoneNum.contains(number)) {
				resultList.add(item);
			}
		}
		return resultList;
	}

	@Override
	public void addAddress(List addressBookList, AddressItem item) {
		// TODO Auto-generated method stub
		if (item != null) {
			addressBookList.add(item);
		}
	}

}
