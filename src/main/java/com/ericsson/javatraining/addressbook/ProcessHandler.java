package com.ericsson.javatraining.addressbook;

import com.ericsson.javatraining.addressbook.action.AbstractAddressAction;

public class ProcessHandler {
	public ProcessHandler(AbstractAddressAction concretAction) {
		super();
		this.concretAction = concretAction;
	}

	private AbstractAddressAction concretAction;

	public AbstractAddressAction getConcretAction() {
		return concretAction;
	}

	public void setConcretAction(AbstractAddressAction concretAction) {
		this.concretAction = concretAction;
	}
	
	public void run() {
		concretAction.action();
	}
}
