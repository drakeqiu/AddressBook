package com.ericsson.javatraining.addressbook.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil {
	public static boolean regmatch(String regex, String string){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		return matcher.matches();
	}
}
