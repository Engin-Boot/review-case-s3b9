package Receiver;

import java.io.BufferedReader;
public class Main {

	public static void main(String[] args) {
		BufferedReader reader=ConsoleReader.readInputFromConsole(System.in);
		CSVParser.parseLineFromCSV(reader);
        try {
        WriteToCSV.writeWordCountToCSV(WordCount.wordCount);
        }catch(Exception e){
        	e.getMessage();
        }
	}
}

