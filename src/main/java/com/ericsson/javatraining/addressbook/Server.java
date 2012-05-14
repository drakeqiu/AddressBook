package com.ericsson.javatraining.addressbook;

import java.io.IOException;


public class Server {

	private static Server instance = new Server();
	
	public static final String ADDRESSPATH = ClassLoader.getSystemResource("AddressList").toString();
	
	private Process process;

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public static Server getInstance() {
		return instance;
	}

	private Server() {
		super();
	}

	public void start() {
		// while(processor);
		try {
			Process.getInstance().process();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
