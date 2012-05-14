package com.ericsson.javatraining.addressbook;

import java.util.List;

public abstract class AbstractAddressionAction {

	protected List AddressionBook;
	
	protected List getAddressionBook() {
		return AddressionBook;
	}

	public void setAddressionBook(List addressionBook) {
		AddressionBook = addressionBook;
	}

	public AbstractAddressionAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public abstract void action();
}
