package com.akseli.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class StrUtils {
	private StrUtils() {}
	
	public static class NewLine {
		
		private NewLine() {}
		
		public static String addNewLines(String text) {
			BufferedReader reader = new BufferedReader(new StringReader(text));
			
			String formattedText = "";
			try {
				for (String line = null; (line = reader.readLine()) != null;) {
					formattedText += "<p>" + line + "</p>";
				}
			} catch (IOException e) {}
			
			return formattedText;
		}
	}
}
