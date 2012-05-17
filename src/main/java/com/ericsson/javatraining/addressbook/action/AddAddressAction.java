package com.ericsson.javatraining.addressbook.action;

import java.io.IOException;
import java.util.List;

import com.ericsson.javatraining.addressbook.AddressItem;
import com.ericsson.javatraining.addressbook.util.StringUtil;

public class AddAddressAction extends AbstractAddressAction{

	@Override
	public void action() {
		// TODO Auto-generated method stub
		try {
			AddressItem item = getItemFromConsole();
			addAddress(item);
			StringUtil.output("Successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private AddressItem getItemFromConsole() throws IOException{
		String name = StringUtil.prompt("Please Enter name for address book");
		String address = StringUtil.prompt("Please enter address for address book");
		String phoneNum = StringUtil.prompt("Please Enter phoneNum for book");	
		
		return new AddressItem(name, address, phoneNum);
	}
	
	private synchronized void addAddress(AddressItem item) {
		// TODO Auto-generated method stub
		getAddressBook().add(item);
	}
	
}
