package com.ericsson.javatraining.addressbook;

public final class ServerDef {
	public static final String CONFIGPATH = ClassLoader.getSystemResource(
			"menu_action.xml").getPath();
	public static final String MENUHANDLEOPTION = "handle-option";
	public static final String MENUCONTENT = "content";
	public static final String MENUNAME = "name";
	public static final String MENUHANDLECLASS = "handle-class";
	public static final String MENUQUIT = "menu-quit";
	public static final String MENUINDEX = "index";
	public static final String ADDRESSSTOREPATH = ClassLoader.getSystemResource("AddressList").getPath();
}
