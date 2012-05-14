package com.ericsson.javatraining.addressbook.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil {
	public static boolean regmatch(String regex, String string) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		return matcher.matches();
	}

	public static String prompt(String info) throws IOException {
		output(info);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String result = reader.readLine();
		while(result == null || "".equals(result.trim())){
			output(info);
			result = reader.readLine();
		}
		return result.trim();
	}

	public static void output(String info, PrintStream out) {
		out.println(info);
	}

	public static void output(String info) {
		output(info, System.out);
	}
		
}
