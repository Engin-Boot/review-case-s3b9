package Sender;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadReviewsCsv {
	public static List<String> reviewCsvReader(String filename) throws IOException{
		List<String>  Reviews=new ArrayList<String>();
		String row="";
		BufferedReader csvReader=new BufferedReader(new FileReader(filename));
		while((row = csvReader.readLine())!=null) {
			String[] data=row.split(",");
			if(data.length>1)
				Reviews.add(data[1]);
			/*for(String s:data) {
				Reviews.add(s);
			}*/
		}
		csvReader.close();
		return Reviews;
	}

}
