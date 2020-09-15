package Receiver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleReader {	
	public static BufferedReader readInputFromConsole(InputStream in) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		return reader;
	}
}
