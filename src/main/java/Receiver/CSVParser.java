package Receiver;

import java.io.BufferedReader;
import java.io.IOException;

public class CSVParser {
	public static void parseLineFromCSV(BufferedReader reader)
	{
		try {
            String name = reader.readLine();
            while(name!=null)
            {
                WordCount.countOccuranceOfWord(name);
                name=reader.readLine();
            }
        } catch (IOException e) {
            e.getMessage();
        }
	}
}
