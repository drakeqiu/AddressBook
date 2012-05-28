package com.ericsson.javatraining.addressbook.action;

import java.util.List;

import com.ericsson.javatraining.addressbook.ServerDef;
import com.ericsson.javatraining.addressbook.ServerDef.PropertyEnum;
import com.ericsson.javatraining.addressbook.util.StringUtil;

public abstract class AbstractAddressAction {

	protected List addressBook;
	

	public List getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(List addressBook) {
		this.addressBook = addressBook;
	}

	public AbstractAddressAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public abstract void action ();
	
	protected PropertyEnum selectPropty(){
		String select = StringUtil.prompt(ServerDef.PROMPT_SELECT_PROPERTY);
		return PropertyEnum.Address;
	}
	
	protected List findByName(List list,String string) {
		return null;
	}
	
	protected List findByPhoneNum(List list, String string){
		return null;
	}
	
	protected List findByAddress(){
		return null;
	}
	
}
