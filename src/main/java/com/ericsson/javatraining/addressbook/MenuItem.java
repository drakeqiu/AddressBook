package com.ericsson.javatraining.addressbook;

import com.ericsson.javatraining.addressbook.action.AbstractAddressAction;

public class MenuItem implements Comparable<MenuItem> {

	private String name;

	private String content;

	private int index;

	private String handleOption;

	private AbstractAddressAction action;

	private boolean menuQuit;

	public MenuItem() {
		super();
	}

	public MenuItem(String name, String content, int index,
			String handleOption, AbstractAddressAction action,
			boolean menuQuit) {
		super();
		this.name = name;
		this.content = content;
		this.index = index;
		this.handleOption = handleOption;
		this.action = action;
		this.menuQuit = menuQuit;
	}

	@Override
	public int compareTo(MenuItem o) {
		return Integer.valueOf(this.getIndex()).compareTo(o.getIndex());
	}

	public AbstractAddressAction getAction() {
		return action;
	}

	public String getContent() {
		return content;
	}

	public String getHandleOption() {
		return handleOption;
	}

	public int getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}

	public boolean isMenuQuit() {
		return menuQuit;
	}

	public void setAction(AbstractAddressAction action) {
		this.action = action;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setHandleOption(String handleOption) {
		this.handleOption = handleOption;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setMenuQuit(boolean menuQuit) {
		this.menuQuit = menuQuit;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[" + handleOption + "] " + content;
	}

}
