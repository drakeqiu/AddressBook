package com.ericsson.javatraining.addressbook;


/**
 * @author alfred
 *
 */
public class MainApp {

	public MainApp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//		ClientImpl client = new ClientImpl();
//		client.start();
		Server.getInstance().start();

	}
}
