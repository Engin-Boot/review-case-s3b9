package Sender;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
	public static boolean isMainFunctionCalled=false;
	 
	public static void main(String[] args)  {
		
	
		List<String> reviewsList = null;
		
		try {
			reviewsList = ReadReviewsCsv.reviewCsvFile_ParsesLinesAndAddsToList(FileFetcher.readCsvfileNameFromProperties(), args[0]);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		ConsoleWriter.writeReviewsOnConsole(reviewsList);
		isMainFunctionCalled=true;
		
	}

}
