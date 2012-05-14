package com.ericsson.javatraining.addressbook;


public class Server {

	private static Server instance = new Server();

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
		Process.getInstance().process();
	}

}
