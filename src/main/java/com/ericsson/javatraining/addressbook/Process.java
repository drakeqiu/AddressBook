package com.ericsson.javatraining.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ericsson.javatraining.addressbook.util.StringUtil;

public class Process {
	private static Process instance = new Process();
	private Map<String, AbstractAddressionAction> handleMap = new HashMap();
	private ProcessionManager manager;

	public static final String SEARCHACTION = "SearchAction";
	public static final String ADDACTION = "AddAction";
	public static final String QUIT = "Quit";

	private List addressBook;

	private void init() {
		addressBook = new ArrayList();
		AbstractAddressionAction addAction = new AddAddressAction();
		AbstractAddressionAction searchAction = new SearchAddressAction();

		searchAction.setAddressBook(addressBook);
		addAction.setAddressBook(addressBook);

		handleMap.put(SEARCHACTION, addAction);
		handleMap.put(ADDACTION, searchAction);
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

	public void process() {
		// IAction action = getRequestion();
		System.out.println("********************************");
		System.out.println("Welcome to address book");
		System.out.println("********************************");
		while (true) {
			String menuValue = processMenu();
			if (QUIT.equals(menuValue)) {
				return;
			} else {
				ProcessHandlerFactory.getInstance(
						(AbstractAddressionAction) handleMap.get(menuValue))
						.run();
			}

		}
	}

	private String processMenu() {
		printMenu();
		return QUIT;
	}

	private void printMenu(){
		StringUtil.output("[1] Add an address Item");
		StringUtil.output("[2] Search an address Item");
		StringUtil.output("[3] Save all");
		StringUtil.output("[q] Quit");
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
