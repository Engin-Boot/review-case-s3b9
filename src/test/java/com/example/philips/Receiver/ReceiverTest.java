package Receiver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Before;
import org.junit.Test;

public class ReceiverTest {
	    private PriorityQueue<String> myqueue= new PriorityQueue<String>();
		private Map<String,Integer> mymap=new HashMap<String,Integer>();
		private String mystring= "the quick brown fox jumps over the lazy dog";
		private String repetitionString="a horse is a horse of course but my horse is awesome";
		//private String csvString="Word,Count\n"+"a,2\n"+"awesome,1\n"+"but,1\n"+"course,1\n"+"horse,3\n"
									//+"is,2\n"+"my,1\n" +"of,1\n";
		private String csvString="Word,Count\n"+"awesome,1\n"+"course,1\n"+"horse,3\n";
		
		private boolean isFunctionCalled=true;
	@Before
	public void init() {
		myqueue.add("the");
		myqueue.add("quick");
		myqueue.add("brown");
		myqueue.add("fox");
		myqueue.add("jumps");
		myqueue.add("over");
		myqueue.add("the");
		myqueue.add("lazy");
		myqueue.add("dog");
		
		mymap.put("a",2);
		mymap.put("horse",3);
		mymap.put("is",2);
		mymap.put("of",1);
		mymap.put("course",1);
		mymap.put("but",1);
		mymap.put("my",1);
		mymap.put("awesome",1);
	}

	@Test
	public void ReadInputFromConsoleThenCheckIfInputIsNotNull(){
		
		BufferedReader reader = ConsoleReader.readInputFromConsole(System.in);
		assertNotNull("should be not null",reader);
	}
	@Test
	public void ReadInputFromConsoleThenCheckIfInputIsNull(){
		
		BufferedReader reader = ConsoleReader.readInputFromConsole(null);
		assertNull("should be null",reader);
	}
	@Test
	public void whenStringContainingMultipleWordsIsPassedToTokenizerCheckStringIsTokenized()
	{
		PriorityQueue<String> tempQueue=new PriorityQueue<String>();
		tempQueue=WordCount.Tokenizer(mystring);
		String str1=tempQueue.toString();
		String str2=myqueue.toString();
		assertEquals(str1,str2);
	}
	
	@Test 
	public void whenStringIsPassedThenCheckWordCountForTheGivenString()
	{
		WordCount.wordCount.clear();
		WordCount.countOccuranceOfWord(repetitionString);
		assertEquals(WordCount.wordCount,mymap);
	}
	
	@Test
	public void givenWordCountInMapThenCheckCorrectOutputIsWrittenToCSV() throws IOException
	{
		WriteToCSV.writeWordCountToCSV(mymap);
		assertEquals(WriteToCSV.str,csvString);
	}
	
	@Test
	public void writeWordCountToCSVTest2() throws FileNotFoundException
	{
		File file=new File("//");
		WriteToCSV.createFileAndWrite(csvString, file);
	}


	@Test
	public void parseLineFromCSVTestForNull() throws IOException{
		BufferedReader reader = null;
		CSVParser.parseLineFromCSV(reader);
		assertEquals(CSVParser.parseLineFromCSVIsCalled,isFunctionCalled);
	}
	
	@Test 
	public void parseLineFromCSVTestTest(){
		String data = "Hello World";
		InputStream stdin = System.in;
		try {
		  System.setIn(new ByteArrayInputStream(data.getBytes()));
		  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		  CSVParser.parseLineFromCSV(reader);
		} finally {
		  System.setIn(stdin);
		  assertEquals(CSVParser.parseLineFromCSVIsCalled,isFunctionCalled);
		}
	}
	@Test 
	public void parseLineFromCSVTestTest2() throws IOException{
		String data = "Hello World";
		InputStream stdin = System.in;
		try {
		  System.setIn(new ByteArrayInputStream(data.getBytes()));
		  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		  reader.close();
		  CSVParser.parseLineFromCSV(reader);
		} finally {
		  System.setIn(stdin);
		  assertEquals(CSVParser.parseLineFromCSVIsCalled,isFunctionCalled);
		}
	}
	
	@Test
	public void testMain() {
		String data = "";
	    String[] args = null;
	    InputStream stdin = System.in;
	    System.setIn(new ByteArrayInputStream(data.getBytes()));
		Main.main(args);
		System.setIn(stdin);
		assertEquals(Main.isMainFunctionCalled,isFunctionCalled);
	}
	
	@Test
	public void readStopWordsFromTextFileTest() throws Exception{
		String filePath=StopWordsFetcher.readStopWordsFileNameFromProperties();
		BufferedReader reader = StopWordsFetcher.getFileReader(filePath);
		assertNotNull("should be not null",reader);
	}
	
	@Test//(expected=IOException.class)
	public void readStopWordsFromTextFileTest2() throws IOException{
		String filePath=StopWordsFetcher.readStopWordsFileNameFromProperties();
		BufferedReader reader = StopWordsFetcher.getFileReader(filePath);
		reader.close();
		StopWordsFetcher.readStopWordsFromTextFile(reader);
	}
	
	@Test//(expected=FileNotFoundException.class)
	public void getFileReaderTest() throws IOException {
		String filePath= "//";
		StopWordsFetcher.getFileReader(filePath);
	}
}
