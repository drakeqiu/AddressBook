package com.ericsson.javatraining.addressbook.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import com.ericsson.javatraining.addressbook.AddressItem;

public final class FileUtil {
	public static void save(String fileName,List list) throws IOException{
		File file = new File(fileName);
		if(file.createNewFile()){
			return;
		}
		PrintStream ps = new PrintStream(file);
		for (Object obj : list) {
			AddressItem address= (AddressItem) obj;
			StringUtil.output(address.toString(), ps);
		}
	}
}
