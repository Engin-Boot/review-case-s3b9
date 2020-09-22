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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException f) {
			f.printStackTrace();
		}
		catch(ColumnNameNotFoundException col)
		{
			col.printStackTrace();
		}
		
		ConsoleWriter.writeReviewsOnConsole(reviewsList);
		isMainFunctionCalled=true;
		
	}

}
