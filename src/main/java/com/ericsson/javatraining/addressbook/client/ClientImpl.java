package com.ericsson.javatraining.addressbook.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.ericsson.javatraining.addressbook.service.AddressBookServiceImpl;
import com.ericsson.javatraining.addressbook.service.IAddressBookService;

public class ClientImpl implements IClient{
	
	private IAddressBookService addressService;
	
	private ArrayList<String> optionList;
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		addressService = new AddressBookServiceImpl();
		initOpt();
		
		String op = null;
		displayWelcome();
		try {
			prompt("Press any key to continue");
			
			op = displayMenu();
			
			
			
			//op = prompt("Please select");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initOpt(){
		optionList = new ArrayList<String>();
		optionList.add("1");
		optionList.add("2");
		optionList.add("q");
		
		
	}
	
	private void displayWelcome(){
		System.out.println(STARLINE);
		System.out.println("\nWeclome to Address Book\n");
		System.out.println(STARLINE);
	}
	
	private String prompt(String info) throws IOException{
		System.out.println(info);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		return reader.readLine();
	}
	
	private String displayMenu() throws IOException{
		String op = null;
		while(op==null || "".equals(op.trim()) || !checkOption(op)){
			System.out.println(STARLINE);
			System.out.println("\nMENU");
			System.out.println("\n[1] add address");
			System.out.println("\n[2] search address");
			System.out.println("\n[q] quit");
			System.out.println();
			System.out.println(STARLINE);
			op = prompt("Please select");
		}
		
		return op;
	}
	
	private boolean checkOption(String op){
		for(Object o : optionList){
			if(((String)o).equals(op)){
				return true;
			}
		}
		return false;
	}
	
}
