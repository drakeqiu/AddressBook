package com.ericsson.javatraining.addressbook;

public class AddressItem {
	private String name;

	private String address;
	private String phoneNum;
	public AddressItem(String string) {
		super();
		String subString = string.substring(AddressItem.class.getSimpleName().length()).trim();
		String itemArray[] = null;
		if(subString.length()>2){
			itemArray = subString.substring(1, subString.length()-1).split(",");
			this.name = itemArray[0].toString().split("=")[1];
			this.address = itemArray[1].toString().split("=")[1];
			this.phoneNum = itemArray[2].toString().split("=")[1];
		}
	}
	
	public AddressItem() {
		super();
	}

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
