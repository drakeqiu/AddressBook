package com.ericsson.javatraining.addressbook.action;

import java.io.IOException;
import java.util.List;

import com.ericsson.javatraining.addressbook.AddressItem;
import com.ericsson.javatraining.addressbook.ServerDef;
import com.ericsson.javatraining.addressbook.util.StringUtil;

public class AddAddressAction extends AbstractAddressAction{

	@Override
	public void action() throws Exception {
		// TODO Auto-generated method stub
		try {
			AddressItem item = getItemFromConsole();
			addAddress(item);
			StringUtil.outputLine(ServerDef.OUTPUT_ADD_SUCCEED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("IO exception");
			throw e;
		}
	}
	
	private AddressItem getItemFromConsole() throws IOException{
		String name = StringUtil.prompt(ServerDef.PROMPT_ADD_NAME);
		String phoneNum = StringUtil.prompt(ServerDef.PROMPT_ADD_MOBILE);
		String address = StringUtil.prompt(ServerDef.PROMPT_ADD_ADDRESS);
		
		return new AddressItem(name, address, phoneNum);
	}
	
	private synchronized void addAddress(AddressItem item) {
		// TODO Auto-generated method stub
		getAddressBook().add(item);
	}
	
}
