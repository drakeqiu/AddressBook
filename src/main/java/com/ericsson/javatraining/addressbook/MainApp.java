package com.ericsson.javatraining.addressbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * @author alfred
 *
 */
public class MainApp {
	
    private static final Logger logger = LoggerFactory.getLogger(MainApp.class);
	public MainApp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			Process.getInstance().process();
		} catch (Exception e) {
			logger.error("unknown error, programme halt.");
			e.printStackTrace();
		}
	}
}
