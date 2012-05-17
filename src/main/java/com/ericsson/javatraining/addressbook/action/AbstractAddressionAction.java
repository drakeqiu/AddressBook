package com.ericsson.javatraining.addressbook.action;

import java.util.List;

public abstract class AbstractAddressionAction {

	protected List addressBook;
	

	public List getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(List addressBook) {
		this.addressBook = addressBook;
	}

	public AbstractAddressionAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public abstract void action();
}
