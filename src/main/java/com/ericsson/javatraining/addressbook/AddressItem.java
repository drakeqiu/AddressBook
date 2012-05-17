package com.ericsson.javatraining.addressbook;

public class AddressItem {
	private String name;

	private String address;
	private String phoneNum;
	public AddressItem(String name, String address, String phoneNum) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "AddressItem [name=" + name + ", address=" + address
				+ ", phoneNum=" + phoneNum + "]";
	}
}
