package com.ericsson.javatraining.addressbook;


/**
 * class for generate ProcessHandler
 * @author alfred
 *
 */
public class ProcessHandlerFactory {

	public ProcessHandlerFactory() {
		super();
	}
	
	public static ProcessHandler getInstance(AbstractAddressionAction concretAction){
		return new ProcessHandler(concretAction);
	}

}
