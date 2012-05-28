package com.ericsson.javatraining.addressbook.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.javatraining.addressbook.action.AddAddressAction;

public final class StringUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);
	
	public static boolean regmatch(String regex, String string) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		return matcher.matches();
	}

	public static String prompt(String info){
		output(info);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String result = "";
		try{
			result = reader.readLine();
			while(result == null || "".equals(result.trim())){
				output(info);
				result = reader.readLine();
			}
		}catch (IOException e) {
			logger.error("I/O exception");
		}
		
		return result.trim();
	}

	public static void output(String info, PrintStream out) {
		out.print(info);
	}
	
	public static void outputLine(String info, PrintStream out) {
		out.println(info);
	}

	public static void output(String info) {
		output(info, System.out);
	}
	
	public static void outputLine(String info) {
		outputLine(info, System.out);
	}
	
	public static String input(String info, BufferedReader reader) throws IOException{
		return reader.readLine();
	}
		
}
