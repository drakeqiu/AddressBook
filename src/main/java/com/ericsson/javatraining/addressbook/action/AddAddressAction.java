package com.ericsson.javatraining.addressbook.action;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.javatraining.addressbook.AddressItem;
import com.ericsson.javatraining.addressbook.Process;
import com.ericsson.javatraining.addressbook.ServerDef;
import com.ericsson.javatraining.addressbook.util.StringUtil;

public class AddAddressAction extends AbstractAddressAction{
	private static final Logger logger = LoggerFactory.getLogger(AddAddressAction.class);
	@Override
	public void action(){
		// TODO Auto-generated method stub
		try {
			AddressItem item = getItemFromConsole();
			addAddress(item);
			StringUtil.outputLine(ServerDef.OUTPUT_ADD_SUCCEED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("I/O exception occors");
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
