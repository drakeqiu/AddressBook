package com.ericsson.javatraining.addressbook;

import com.ericsson.javatraining.addressbook.action.AbstractAddressAction;


/**
 * class for generate ProcessHandler
 * @author alfred
 *
 */
public class ProcessHandlerFactory {

	public ProcessHandlerFactory() {
		super();
	}
	
	public static ProcessHandler getInstance(AbstractAddressAction concretAction){
		return new ProcessHandler(concretAction);
	}

}
