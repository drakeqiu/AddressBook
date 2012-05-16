package com.ericsson.javatraining.addressbook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MenuManager {

	private static final String CONFIGPAT = ClassLoader.getSystemResource("menu_action.xml").getPath();
	
	private MenuManager() {
		super();
	}
	
	private List configLoader(){
		List list = new ArrayList();
		
		return null;
	}

	public static List getMenuList() {
		List list = new ArrayList();
		Collections.sort(list);
		return null;
	}

	public static void main(String[] args) {
		MenuItem item2 = new MenuItem();
		item2.setHandleOption(2);
		MenuItem item3 = new MenuItem();
		item3.setHandleOption(3);
		MenuItem item4 = new MenuItem();
		item4.setHandleOption(4);
		MenuItem item1 = new MenuItem();
		item1.setHandleOption(1);
		List list = new ArrayList();
		list.add(item1);
		list.add(item2);
		list.add(item3);
		list.add(item4);

		Collections.sort(list);
		for (Object o : list) {
			MenuItem item = (MenuItem) o;
			System.out.println(item.getHandleOption());
		}
	}
}
