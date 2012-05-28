package com.ericsson.javatraining.addressbook.action;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.javatraining.addressbook.ServerDef;
import com.ericsson.javatraining.addressbook.util.FileUtil;

public class SaveAddressBookAction extends AbstractAddressAction {
	private static final Logger logger = LoggerFactory.getLogger(AddAddressAction.class);
	@Override
	public void action(){
		// TODO Auto-generated method stub
		List list = getAddressBook();
		try {
			FileUtil.save(ServerDef.ADDRESSSTOREPATH, getAddressBook());
		} catch (IOException e) {
			logger.error("save address failed");
		}

	}

}
