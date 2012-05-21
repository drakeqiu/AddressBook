package com.ericsson.javatraining.addressbook.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ericsson.javatraining.addressbook.AddressItem;
import com.ericsson.javatraining.addressbook.util.StringUtil;

public class SearchAddressAction extends AbstractAddressAction{

	@Override
	public void action() throws Exception{
		// TODO Auto-generated method stub
		try {
			String phoneNum = getNumFromConsole();
			List addressList = searchAddress(phoneNum);
			displayAddress(addressList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getNumFromConsole() throws IOException{
		return StringUtil.prompt("Please enter a phoneNum for search");
	}
	
	private List searchAddress(String number){
		if("all".equals(number)){
			return getAddressBook();
		}
		List<AddressItem> resultList = new ArrayList();
		List addressBookList = getAddressBook();
		Iterator it = addressBookList.iterator();

		while (it.hasNext()) {
			AddressItem item = (AddressItem) it.next();
			String phoneNum = item.getPhoneNum();
			if (phoneNum.contains(number)) {
				resultList.add(item);
			}
		}

		return resultList;
	}
	
	private void displayAddress(List addressBook){
		Iterator it = addressBook.iterator();
		while(it.hasNext()){
			AddressItem item = (AddressItem) it.next();
			StringUtil.output(item.toString());
		}
	}

}
