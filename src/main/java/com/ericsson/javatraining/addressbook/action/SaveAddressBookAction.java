package com.ericsson.javatraining.addressbook.action;

import java.util.List;

import com.ericsson.javatraining.addressbook.ServerDef;
import com.ericsson.javatraining.addressbook.util.FileUtil;

public class SaveAddressBookAction extends AbstractAddressAction {

	@Override
	public void action() throws Exception{
		// TODO Auto-generated method stub
		List list = getAddressBook();
		FileUtil.save(ServerDef.ADDRESSSTOREPATH, getAddressBook());

	}

}
