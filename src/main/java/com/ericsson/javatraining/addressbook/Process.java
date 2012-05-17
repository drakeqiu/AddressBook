package com.ericsson.javatraining.addressbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import com.ericsson.javatraining.addressbook.util.StringUtil;

public class Process {
	private static Process instance = new Process();

	private List menuList;

	private List addressBook;

	private void init() {
		addressBook = initiateAddressList();

		menuList = MenuManager.getMenuList();
		for (Object obj : menuList) {
			MenuItem menu = (MenuItem) obj;
			menu.getAction().setAddressBook(addressBook);
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

	public void process() throws IOException {
		System.out.println("********************************");
		System.out.println("Welcome to address book");
		System.out.println("********************************");
		processMenu();
	}

	/**
	 * process menu operation
	 * 
	 * @throws IOException
	 */
	private void processMenu() throws IOException {
		while (true) {
			printMenu();
			String option = StringUtil.prompt("Please select");
			if (processOption(option)) {
				return;
			}

		}

	}

	private boolean processOption(String option) {
		MenuItem menu = null;
		boolean isMenuQuit = false;
		for (Object obj : menuList) {
			MenuItem menuItem = (MenuItem) obj;
			if (option.equals(menuItem.getHandleOption())) {
				menu = menuItem;
				menu.getAction().action();
				isMenuQuit = menu.isMenuQuit();
			}
		}
		return isMenuQuit;
	}

	/**
	 * just print all menu
	 */
	private void printMenu() {
		StringUtil.output("================================");
		for (Object obj : menuList) {
			MenuItem menu = (MenuItem) obj;
			StringUtil.output(menu.toString());
		}
		StringUtil.output("================================");
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
