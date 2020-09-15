package Sender;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadReviewsCsv {
	public static List<String> reviewCsvReader(String filename, String col) throws IOException{
		List<String>  Reviews=new ArrayList<String>();
		String row="";
		BufferedReader csvReader=new BufferedReader(new FileReader(filename));
		String firstrow=csvReader.readLine();
		String[] columns=firstrow.split(",");
		Integer primecolumn=(Integer) null; 
		for(Integer i=0;i<columns.length;i++)
		{
			if(columns[i].equals(col))
			{
				primecolumn=i;
				break;
			}
		}
		
		  
		while((row = csvReader.readLine())!=null) {
			String[] data=row.split(",");
			if(data.length>1)
				Reviews.add(data[primecolumn]);
			
			/*for(String s:data) {
				Reviews.add(s);
			}*/
		}
		csvReader.close();
		return Reviews;
	}


}
