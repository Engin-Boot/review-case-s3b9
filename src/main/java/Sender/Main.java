package Sender;
import java.io.IOException;
import java.util.List;

public class Main {
	
	public static void WriteReviews(List<String> reviews) {
		ConsoleWriter.writeReviewsOnConsole(reviews);
	}
	public static void main(String[] args) throws IOException{
		
		
		List<String> reviewsList = null;
		
		reviewsList = ReadReviewsCsv.reviewCsvReader(FileFetcher.readCsvfileNameFromProperties(), args[0]);
		
		WriteReviews(reviewsList);
		
	}

}
