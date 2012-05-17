package com.ericsson.javatraining.addressbook.util;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DomUtil {
	public static Document load(String filename) {
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();

			// read xml file, and get document object
			document = saxReader.read(new File(filename));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return document;

	}

	public static Element getRoot(Document document) {
		return document.getRootElement();
	}
}
