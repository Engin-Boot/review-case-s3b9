package Sender;
import java.io.IOException;
import java.util.List;

public class Main {
	

	public static void main(String[] args){
		
		
		List<String> reviewsList = null;
		
		try {
			reviewsList = ReadReviewsCsv.reviewCsvReader(FileFetcher.readCsvfileNameFromProperties(), args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConsoleWriter.writeReviewsOnConsole(reviewsList);
		
	}

}
