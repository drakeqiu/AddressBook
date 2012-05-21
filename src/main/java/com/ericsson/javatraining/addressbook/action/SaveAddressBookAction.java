package com.ericsson.javatraining.addressbook.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import com.ericsson.javatraining.addressbook.AddressItem;
import com.ericsson.javatraining.addressbook.Server;
import com.ericsson.javatraining.addressbook.ServerDef;
import com.ericsson.javatraining.addressbook.util.StringUtil;

public class SaveAddressBookAction extends AbstractAddressAction {

	@Override
	public void action() throws Exception{
		// TODO Auto-generated method stub
		List list = getAddressBook();

		try {
			File file = new File(ServerDef.ADDRESSSTOREPATH);
			file.createNewFile();
			PrintStream ps = new PrintStream(file);
			for (Object obj : list) {
				AddressItem address= (AddressItem) obj;
				StringUtil.output(address.toString(), ps);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
