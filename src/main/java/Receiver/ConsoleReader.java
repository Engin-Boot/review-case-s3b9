package Receiver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleReader {	
	private ConsoleReader() {}
	public static BufferedReader readInputFromConsole(InputStream in) {
		try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		return reader;
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
