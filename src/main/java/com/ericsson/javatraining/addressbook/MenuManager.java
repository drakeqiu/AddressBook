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

	private static final String CONFIGPATH = ClassLoader.getSystemResource(
			"menu_action.xml").getPath();
	private static final String MENUHANDLEOPTION = "handle-option";
	private static final String MENUCONTENT = "content";
	private static final String MENUNAME = "name";
	private static final String MENUHANDLECLASS = "handle-class";
	private static final String MENUQUIT = "menu-quit";
	private static final String MENUINDEX = "index";

	private MenuManager() {
		super();
	}

	private static List loadConfig() {
		List list = new ArrayList();
		List elementList = DomUtil.load(CONFIGPATH).getRootElement().elements();
		for (Object obj : elementList) {
			Element element = (Element) obj;
			MenuItem menu = new MenuItem();
			menu.setName(element.elementTextTrim(MENUNAME));
			menu.setIndex(Integer.parseInt(element.elementTextTrim(MENUINDEX)));
			menu.setHandleOption(element.elementTextTrim(MENUHANDLEOPTION));
			menu.setContent(element.elementTextTrim(MENUCONTENT));
			menu.setMenuQuit(Boolean.parseBoolean(element
					.elementTextTrim(MENUQUIT)));
			try {
				menu.setAction((AbstractAddressAction) Class.forName(
						element.elementTextTrim(MENUHANDLECLASS)).newInstance());
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
