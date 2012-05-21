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
		try {
			Process.getInstance().process();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
