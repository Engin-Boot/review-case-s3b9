package Receiver;

import java.io.BufferedReader;

public class CSVParser {
	private CSVParser() {}
	public static boolean parseLineFromCSVIsCalled=false;
	public static void parseLineFromCSV(BufferedReader reader)
	{
		try {
			String reviewComment = reader.readLine();
            while(reviewComment!=null)
            {
                WordCount.countOccuranceOfWord(reviewComment);
                reviewComment=reader.readLine();
            }
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
		parseLineFromCSVIsCalled=true;
	}
}
