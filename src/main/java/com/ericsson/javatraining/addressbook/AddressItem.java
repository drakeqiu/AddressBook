package com.ericsson.javatraining.addressbook;

public class AddressItem {
	private String name;
	private String address;
	private String phoneNum;

	public String getName() {
		return name;
	}

	public AddressItem(String name, String address, String phoneNum) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}
