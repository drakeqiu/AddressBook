package com.ericsson.javatraining.addressbook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Process {
	private static Process instance = new Process();
	private Map handleMap = new HashMap();
	private ProcessionManager manager;

	public static final String SEARCHACTION = "SearchAction";
	public static final String ADDACTION = "AddAction";
	public static final String QUIT = "Quit";
	
	private void init() {
		// handleMap = ;
	}

	private List addressBook;

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
		
		while(true){
			String menuValue = processMenu();
			if(QUIT.equals(menuValue)){
				return;
			}else{
				ProcessHandlerFactory.getInstance((AbstractAddressionAction)handleMap.get(menuValue)).run();
			}
			
		}
	}
	
	private String processMenu(){
		return QUIT;
	}

	public void getRequestion() {

	}

	private Process() {
		super();
		AbstractAddressionAction addAction = new AddAddressAction();
		AbstractAddressionAction searchAction = new SearchAddressAction();
		handleMap.put(SEARCHACTION, addAction);
		handleMap.put(ADDACTION, searchAction);
	}

	public static Process getInstance() {
		return instance;
	}
}
