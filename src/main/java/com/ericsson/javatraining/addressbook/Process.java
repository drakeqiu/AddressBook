package com.ericsson.javatraining.addressbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ericsson.javatraining.addressbook.action.AbstractAddressionAction;
import com.ericsson.javatraining.addressbook.action.AddAddressAction;
import com.ericsson.javatraining.addressbook.action.SearchAddressAction;
import com.ericsson.javatraining.addressbook.util.StringUtil;

public class Process {
	private static Process instance = new Process();
	private Map<String, AbstractAddressionAction> handleMap = new HashMap();
	private ProcessionManager manager;

	private List menuList;

	private List addressBook;

	private void init() {
		addressBook = new ArrayList();

		menuList = MenuManager.getMenuList();
		for (Object obj : menuList) {
			MenuItem menu = (MenuItem) obj;
			menu.getAction().setAddressBook(addressBook);
		}
	}

	public List getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(List addressBook) {
		this.addressBook = addressBook;
	}

	public ProcessionManager getManager() {
		return manager;
	}

	public void setManager(ProcessionManager manager) {
		this.manager = manager;
	}

	public void process() throws IOException {
		System.out.println("********************************");
		System.out.println("Welcome to address book");
		System.out.println("********************************");
		processMenu();
	}

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
			MenuItem  menuItem= (MenuItem) obj;
			if (option.equals(menuItem.getHandleOption())) {
				menu = menuItem;
				menu.getAction().action();
				isMenuQuit = menu.isMenuQuit();
			}
		}
		return isMenuQuit;
	}

	private void printMenu() {
		StringUtil.output("================================");
		for (Object obj : menuList) {
			MenuItem menu = (MenuItem) obj;
			StringUtil.output(menu.toString());
		}
		StringUtil.output("================================");
	}

	public void getRequestion() {

	}

	private Process() {
		super();
		init();

	}

	public static Process getInstance() {
		return instance;
	}
}
