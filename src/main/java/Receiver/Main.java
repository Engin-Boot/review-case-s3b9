package Receiver;

import java.io.BufferedReader;
import java.io.IOException;
public class Main {
	public static boolean isMainFunctionCalled=false;
	public static void main(String[] args) {	
		BufferedReader reader=ConsoleReader.readInputFromConsole(System.in);
		CSVParser.parseLineFromCSV(reader);
		String stopWordsFilePath=StopWordsFetcher.readStopWordsFileNameFromProperties();
		BufferedReader fileReader=StopWordsFetcher.getFileReader(stopWordsFilePath);
		try {
			StopWordsFetcher.readStopWordsFromTextFile(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		WriteToCSV.writeWordCountToCSV(WordCount.wordCount);
		isMainFunctionCalled=true;
	}
}

