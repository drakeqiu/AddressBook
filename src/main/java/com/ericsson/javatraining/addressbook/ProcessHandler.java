package com.ericsson.javatraining.addressbook;

import com.ericsson.javatraining.addressbook.action.AbstractAddressionAction;

public class ProcessHandler {
	public ProcessHandler(AbstractAddressionAction concretAction) {
		super();
		this.concretAction = concretAction;
	}

	private AbstractAddressionAction concretAction;

	public AbstractAddressionAction getConcretAction() {
		return concretAction;
	}

	public void setConcretAction(AbstractAddressionAction concretAction) {
		this.concretAction = concretAction;
	}
	
	public void run() {
		concretAction.action();
	}
}
