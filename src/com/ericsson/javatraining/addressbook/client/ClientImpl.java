package com.ericsson.javatraining.addressbook.client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ericsson.javatraining.addressbook.service.AddressBookServiceImpl;
import com.ericsson.javatraining.addressbook.service.IAddressBookService;

public class ClientImpl implements IClient{
	
	private IAddressBookService addressService;
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		addressService = new AddressBookServiceImpl();
		String op = null;
		displayWelcome();
		try {
			prompt("Press any key to continue");
			displayMenu();

			op = prompt("Please select");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	private void displayMenu(){
		System.out.println(STARLINE);
		System.out.println("\nMENU");
		System.out.println("\n[1] add address");
		System.out.println("\n[2] search address");
		System.out.println("\n[q] quit");
		System.out.println();
		System.out.println(STARLINE);
	}
}
