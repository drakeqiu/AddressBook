package com.ericsson.javatraining.addressbook.app;

import com.ericsson.javatraining.addressbook.client.ClientImpl;

/**
 * @author alfred
 *
 */
public class MainApp {

	public static void main(String[] args) {
		ClientImpl client = new ClientImpl();
		client.start();

	}
}
