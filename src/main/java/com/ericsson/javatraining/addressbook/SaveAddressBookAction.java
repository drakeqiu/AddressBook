package com.ericsson.javatraining.addressbook;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class SaveAddressBookAction extends AbstractAddressionAction{

	@Override
	public void action() {
		// TODO Auto-generated method stub
		List list = getAddressBook();
		File file = new File(Server.ADDRESSPATH);
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
