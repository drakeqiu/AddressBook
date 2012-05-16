package com.ericsson.javatraining.addressbook;

public class MenuItem implements Comparable<MenuItem>{
	
	private String id;
	
	private String content;
	
	private int handleOption;
	
	private AbstractAddressionAction action;
	
	public MenuItem() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHandleOption() {
		return handleOption;
	}

	public void setHandleOption(int handleOption) {
		this.handleOption = handleOption;
	}

	public AbstractAddressionAction getAction() {
		return action;
	}

	public void setAction(AbstractAddressionAction action) {
		this.action = action;
	}

	public MenuItem(String id, String content, int handleOption,
			AbstractAddressionAction action) {
		super();
		this.id = id;
		this.content = content;
		this.handleOption = handleOption;
		this.action = action;
	}


	@Override
	public int compareTo(MenuItem o) {
		return Integer.valueOf(this.getHandleOption()).compareTo(o.getHandleOption());
	}

	@Override
	public String toString() {
		return "[" + handleOption + "] " + content ; 
	}
	
	
}
