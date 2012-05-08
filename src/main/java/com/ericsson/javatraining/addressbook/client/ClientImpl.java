package com.ericsson.javatraining.addressbook.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ericsson.javatraining.addressbook.bo.AddressBook;
import com.ericsson.javatraining.addressbook.bo.AddressItem;
import com.ericsson.javatraining.addressbook.service.AddressBookServiceImpl;
import com.ericsson.javatraining.addressbook.service.IAddressBookService;
import com.ericsson.javatraining.addressbook.util.StringUtil;

public class ClientImpl implements IClient {

	private IAddressBookService addressService;

	private ArrayList<String> optionList;
	private final String addressReg = "\\w+ .+ tel:\\d+";
	private List book = AddressBook.getAddressBook();
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		//if (StringUtil.regmatch(addressReg, "drake aaa tel:119"))
		//	return;
		addressService = new AddressBookServiceImpl();
		initOpt();

		String op = null;
		displayWelcome();
		try {
			prompt("Press any key to continue");
			
			
			operation();
			// op = prompt("Please select");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initOpt() {
		optionList = new ArrayList<String>();
		optionList.add("1");
		optionList.add("2");
		optionList.add("q");

	}

	private void displayWelcome() {
		System.out.println(STARLINE);
		System.out.println("\nWeclome to Address Book\n");
		System.out.println(STARLINE);
	}

	private String prompt(String info) throws IOException {
		System.out.println(info);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		return reader.readLine();
	}

	private String displayMenu() throws IOException {
		String op = null;
		while (op == null || "".equals(op.trim()) || !checkOption(op.trim())) {
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

	private boolean checkOption(String op) {
		for (Object o : optionList) {
			if (((String) o).equals(op)) {
				return true;
			}
		}
		return false;
	}

	private void addOP() throws IOException {
		
		// addressService.addAddress(addressBookList, null);
		while(true){
			String rtValue = prompt("\nPlease enter an address.\nq to return \n[sample Name Address tel:phoneNum]\n");
			if(rtValue != null && "q".equals(rtValue.trim())){
				return ;
			}
			if(StringUtil.regmatch(addressReg, rtValue)){
				String[] itemArray= rtValue.split(" ");
				AddressItem item = new AddressItem();
				item.setName(itemArray[0]);
				item.setAddress(itemArray[1]);
				item.setPhoneNum(itemArray[2]);
				addressService.addAddress(book, item);
				System.out.println("\n[Succeed!]");
			}else{
				System.out.println("\n[Wrong address format]");
			}
		}
	}
	
	private void searchOP() throws IOException {
		while(true){
			String rtValue = prompt("\nPlease enter an phoneNum for search.\nq to return");
			if(rtValue != null && "q".equals(rtValue.trim())){
				return ;
			}
			
			List rtList = addressService.searchAddress(book, rtValue);
			displayAddress(rtList);
			
		}
	}
	private void operation() throws IOException {
		
		String op = null;
		while (true) {
			op = displayMenu();
			if(op!=null && "q".equals(op.trim())){
				return ;
			}
			if ("1".equals(op)) {
				addOP();
			}
			if ("2".equals(op)) {
				searchOP();
			}
		}
	}
	
	private void displayAddress(List addressList){
		if(addressList==null || addressList.size() == 0){
			System.out.println("Address Book is null");
		}else{
			Iterator it = addressList.iterator();
			
			//print item
			System.out.println("================");
			while(it.hasNext()){
				AddressItem item = (AddressItem) it.next();
				System.out.println("Name: " + item.getName());
				System.out.println("Address: " + item.getAddress());
				System.out.println("PhoneNum: " + item.getPhoneNum());
				
				System.out.print("\n\n");
			}
			System.out.println("================");
		}
		
	}
}
