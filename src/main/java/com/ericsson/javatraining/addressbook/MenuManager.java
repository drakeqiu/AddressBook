package com.ericsson.javatraining.addressbook;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ericsson.javatraining.addressbook.action.AbstractAddressAction;
import com.ericsson.javatraining.addressbook.util.DomUtil;

public class MenuManager {

	

	private MenuManager() {
		super();
	}

	// load menu settings from config file
	private static List loadConfig() {
		List list = new ArrayList();
		List elementList = DomUtil.load(ServerDef.CONFIGPATH).getRootElement().elements();
		for (Object obj : elementList) {
			Element element = (Element) obj;
			MenuItem menu = new MenuItem();
			menu.setName(element.elementTextTrim(ServerDef.MENUNAME));
			menu.setIndex(Integer.parseInt(element.elementTextTrim(ServerDef.MENUINDEX)));
			menu.setHandleOption(element.elementTextTrim(ServerDef.MENUHANDLEOPTION));
			menu.setContent(element.elementTextTrim(ServerDef.MENUCONTENT));
			menu.setMenuQuit(Boolean.parseBoolean(element
					.elementTextTrim(ServerDef.MENUQUIT)));
			try {
				menu.setAction((AbstractAddressAction) Class.forName(
						element.elementTextTrim(ServerDef.MENUHANDLECLASS)).newInstance());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(menu);
		}
		Collections.sort(list);
		return list;
	}

	public static List getMenuList() {
		return loadConfig();
	}

}
