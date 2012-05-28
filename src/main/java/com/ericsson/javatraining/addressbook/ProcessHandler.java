package com.ericsson.javatraining.addressbook;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.javatraining.addressbook.util.StringUtil;

public class ProcessHandler implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(Process.class);
	private Map actionMap;

	public void setActionMap(Map actionMap) {
		this.actionMap = actionMap;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		handleAction();
	}

	private void handleAction() {
		while (true) {
			printHelper();
			String option;
			option = StringUtil.prompt(ServerDef.MENU_PROMPT);
			if (processSelection(option)) {
				return;
			}
		}
	}

	private void printHelper() {

	}

	private boolean processSelection(String select) {
		MenuItem menu = (MenuItem) actionMap.get(select);
		if (menu != null) {
			menu.getAction().action();

			return menu.isMenuQuit();
		} else {
			return false;
		}
	}
}
