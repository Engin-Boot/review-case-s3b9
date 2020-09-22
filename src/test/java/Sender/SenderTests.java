package Sender;
import Sender.ColumnNameNotFoundException;

import Sender.ConsoleWriter;

import Sender.FileFetcher;
import Sender.Main;
import Sender.ReadReviewsCsv;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * This class contains the test scenarios for 
 * Sender classes and their functionalities
 * @author Arunim Roy
 *
 */

public class SenderTests {
	
	
	/**
	 * This test ensures that the column filter returns
	 * a correct index for the column string added as the argument
	 * @param rows of the csv file being parsed
	 * @param column name
	 * @throws ColumnNameNotFoundException 

	 * 
	 */
	@Test
	public void whenCorrectColumnNameGiven_columnFilterTest_Success_Returns_Column_Number() throws ColumnNameNotFoundException {
		String firstrow="Calcutta,Bombay,Chennai"; 
		String col="Bombay";
		Integer primecolumn=ReadReviewsCsv.Columnfilter(firstrow, col);
		Assert.assertEquals(Integer.valueOf(1), primecolumn);
		
		
	}
	
	
	/**
	 * this test is a negative case
	 * were assertion is made for wrong column being returned
	 * @param rows of the csv file being parsed
	 * @param column name
	 * @throws ColumnNameNotFoundException 
	 */
	
	
	
	@Test(expected=ColumnNameNotFoundException.class)
	public void whenInvalidColumnNameGiven_ColumnFilterTestthrowsColumnNameNotfoundException() throws ColumnNameNotFoundException {
		String firstrow="Calcutta,Bombay,Chennai";
		String col="Chandigarh";
		Integer primecolumn=ReadReviewsCsv.Columnfilter(firstrow, col);
	}
	
	@Test(expected=ColumnNameNotFoundException.class)
	public void reviewCsvParser_ReturnsColumnNameNotfoundException() throws IOException, ColumnNameNotFoundException {
		List<String> expectedReviews=new ArrayList<String>();
		expectedReviews.add("Calcutta is nice");
		
	    BufferedReader bufferedReader = org.mockito.Mockito.mock(BufferedReader.class);
	    String path="src/main/resources/sample.csv";
	    Mockito.when(bufferedReader.readLine()).thenReturn(path);
	    List<String> reviews=ReadReviewsCsv.reviewCsvFile_ParsesLinesAndAddsToList(path, "Challenges");
	  
	    
		
	}
	
	/**
	 * This functions returns review list after parsing the lines and testing for success
	 * @throws IOException
	 * @throws ColumnNameNotFoundException 
	 */
	
	@Test
	public void reviewCsvReader_ReturnsReviewsList() throws IOException, ColumnNameNotFoundException {
		
		List<String> expectedReviews=new ArrayList<String>();
		expectedReviews.add("Calcutta is nice");
		
	    BufferedReader bufferedReader = org.mockito.Mockito.mock(BufferedReader.class);
	    String path="src/main/resources/sample.csv";
	    Mockito.when(bufferedReader.readLine()).thenReturn(path);
	    List<String> reviews=ReadReviewsCsv.reviewCsvFile_ParsesLinesAndAddsToList(path, "Comments");
	  
	    
	    Assert.assertEquals(expectedReviews, reviews);
	        
	    
	}
	
	/**
	 * Negative test for file format not being supported
	 * @throws IOException
	 */
	@Test
	public void fileFetcher_Failure() throws IOException {
		 ResourceBundle rb=ResourceBundle.getBundle("filepath");
		 FileFetcher.path=rb.getString("filename3");
		 String result=FileFetcher.readCsvfileNameFromProperties();
		 Assert.assertEquals("file format not supported", result);
		
	}
	
	/**
	 * FileFetcher successful execution for valid file format and names
	 * @throws IOException
	 */
	@Test
	public void fileFetcher_Success() throws IOException {
		 ResourceBundle rb=ResourceBundle.getBundle("filepath");
		 FileFetcher.path=rb.getString("filename2");
		 String result=FileFetcher.readCsvfileNameFromProperties();
		 Assert.assertEquals("C:\\Users\\Dell\\eclipse-workspace\\com.example.philips\\src\\main\\resources\\sample.csv", result);
		
	}
	
	@Test
	public void testMainFunction_MainFunctionCalled() {//COMING WRONG
		String[] args={"Comments"}; 
		InputStream stdin=System.in;
		
		Main.main(args);
		System.setIn(stdin);
		Assert.assertEquals(Main.isMainFunctionCalled, true);
		
	}
	
	/**
	 * Main method test for ColumnNotFoundException
	 * @throws ColumnNameNotFoundException
	 */
	@Test(expected=ColumnNameNotFoundException.class)
	public void whenWrongColumnNameGivenInMainArguments_ColumnNameotFoundExceptionThrown() throws ColumnNameNotFoundException{
		String[] args={"Changes"}; 
		InputStream stdin=System .in;
		Main.main(args);
		System.setIn(stdin);
		
		
	}
	
	/**
	 * This test is for checking console writer
	 */
	@Test
	public void TestConsoleWriter() {
		List<String> listConsole=new ArrayList<>();
		listConsole.add("Calcutta,Bombay");
		ConsoleWriter.writeReviewsOnConsole(listConsole);
			    
	}

	

	
	
	
	
	

}
