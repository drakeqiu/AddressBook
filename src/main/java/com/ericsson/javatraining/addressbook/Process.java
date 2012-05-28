package com.ericsson.javatraining.addressbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.javatraining.addressbook.util.StringUtil;

public class Process {
	private static Process instance = new Process();
	
	private static final Logger logger = LoggerFactory.getLogger(Process.class);
	private ProcessHandler handler;
	private ExecutorService executorService;
	
	private List menuList;
	private Map actionMap = new HashMap<String, MenuItem>();
	private List addressBook;

	private void init() {
		addressBook = initiateAddressList();
		
		handler = new ProcessHandler();
		handler.setActionMap(actionMap);
		executorService = Executors.newSingleThreadScheduledExecutor();
		menuList = MenuManager.getMenuList();
		for (Object obj : menuList) {
			MenuItem menu = (MenuItem) obj;
			menu.getAction().setAddressBook(addressBook);
			actionMap.put(menu.getHandleOption(), menu);
		}
	}

	private List initiateAddressList(){
		List list = new ArrayList();
		File file = new File(ServerDef.ADDRESSSTOREPATH);
		try {
			if(!file.exists()){
				file.createNewFile();
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			
			while(true){
				String addressStr = null;
				addressStr = reader.readLine();
				if(addressStr == null){
					break;
				} else{
					list.add(new AddressItem(addressStr));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	public List getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(List addressBook) {
		this.addressBook = addressBook;
	}

	public void process() throws Exception {
//		logger.info("Start to do process");
		executorService.execute(handler);
		executorService.shutdown();
		processMenu();
	}

	/**
	 * process menu operation
	 * @throws Exception 
	 */
	private void processMenu() throws Exception {
		while (true) {
			printMenu();
			String option = StringUtil.prompt(ServerDef.MENU_PROMPT);
			if (processOption(option)) {
				return;
			}

		}

	}

	private boolean processOption(String option) throws Exception {
//		MenuItem menu = null;
//		boolean isMenuQuit = false;
//		for (Object obj : menuList) {
//			MenuItem menuItem = (MenuItem) obj;
//			if (option.equals(menuItem.getHandleOption())) {
//				menu = menuItem;
//				menu.getAction().action();
//				isMenuQuit = menu.isMenuQuit();
//			}
//		}
		MenuItem menu = (MenuItem) actionMap.get(option);
		if(menu!=null){
			menu.getAction().action();
			return menu.isMenuQuit();
		}else{
			return false;
		}
		
		
	}

	/**
	 * just print all menu
	 */
	private void printMenu() {
		StringUtil.outputLine("================================");
		for (Object obj : menuList) {
			MenuItem menu = (MenuItem) obj;
			StringUtil.outputLine(menu.toString());
		}
		StringUtil.outputLine("================================");
	}

	private Process() {
		super();
		init();

	}

	public static Process getInstance() {
		return instance;
	}

	public static void main(String args[]) {
		Process process = Process.getInstance();
		process.getAddressBook();
	}
}
