package Sender;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * This class reads the csv file and adds the 
 * data  from user input column into a list and returns the list
 * @author Arunim Roy
 *
 */
public class ReadReviewsCsv {
	
	public static Integer MatchcolumnLoop(String[] columns,String col, Integer primecolumn) throws NullPointerException, ColumnNameNotFoundException {
		
		
		for(Integer i=0;i<columns.length;i++)
		{
			if(columns[i].equals(col))
			{
				primecolumn=i;
				break;
			}
			
		}
		
		return primecolumn;
	}
	
	/**
	 * This function return the index of the column String
	 * 
	 * @param firstrow
	 * @param col
	 * @return
	 */
	public static Integer Columnfilter(String firstrow, String col) throws ColumnNameNotFoundException {
		String[] columns=firstrow.split(",");
		Integer primecolumn=(Integer) null; 
		primecolumn=MatchcolumnLoop(columns, col, primecolumn);
		if(primecolumn==null)
		{
			throw new ColumnNameNotFoundException("Column Name not Found");
		}
		return primecolumn;
	}
	
	public static void addReviewstoList(String row, List<String> Reviews,Integer primecolumn) {
		String[] data=row.split(",");
		if(data.length>1)// this part of code excludes empty rows of csv file
				Reviews.add(data[primecolumn]);
	}
	/**
	 * This function returns the list of reviews
	 * present under column entered by user
	 * 
	 * @param filename
	 * @param col
	 * @return
	 * @throws IOException
	 */
	public static List<String> reviewCsvFile_ParsesLinesAndAddsToList(String filename, String col) throws IOException,ColumnNameNotFoundException{
		List<String>  Reviews=new ArrayList<String>();
		String row="";
		BufferedReader csvReader;
		
		try {
		
		csvReader = new BufferedReader(new FileReader(filename));
		String firstrow=csvReader.readLine();
		
		Integer primecolumn;// Datatype is Integer Object since it has to initialized null
		primecolumn = Columnfilter(firstrow, col);//used to find the index of column provided in arguments by User
			
		while((row = csvReader.readLine())!=null) {
		addReviewstoList(row, Reviews, primecolumn);
				
			}
		csvReader.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		
		return Reviews;
}

	
	

}
