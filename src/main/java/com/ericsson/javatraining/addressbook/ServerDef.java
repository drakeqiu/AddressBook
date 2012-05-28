package com.ericsson.javatraining.addressbook;

public final class ServerDef {
	public static final String MENU_CONFIG_PATH = ClassLoader.getSystemResource(ServerDef.MENU_CONFIG_FILE).getPath();
	public static final String MENU_CONFIG_FILE = "menu_action.xml";
	public static final String MENUHANDLEOPTION = "handle-option";
	public static final String MENUCONTENT = "content";
	public static final String MENUNAME = "name";
	public static final String MENUHANDLECLASS = "handle-class";
	public static final String MENUQUIT = "menu-quit";
	public static final String MENUINDEX = "index";
	public static final String ADDRESSSTOREPATH = ClassLoader.getSystemResource("AddressList").getPath();

	public static final String PROMPT_ADD_NAME ="name: ";
	public static final String PROMPT_ADD_MOBILE ="mobile: ";
	public static final String PROMPT_ADD_ADDRESS ="address: ";
	
	public static final String OUTPUT_ADD_SUCCEED = "address entry added";
	
	public static final String MENU_PROMPT = "ab> ";
	
	public static final String PROMPT_SELECT_PROPERTY = "by (name|mobile|address)";
	
	public enum PropertyEnum {
		Name,PhoneNum,Address
	}
}
