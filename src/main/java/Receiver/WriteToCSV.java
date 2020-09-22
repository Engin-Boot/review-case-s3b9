package Receiver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteToCSV {
	private WriteToCSV(){}
	public static String str="Word,Count\n";
	public static boolean createFileAndWriteIsCalled=false;
	public static void createStringForWritingInCSV(Map<String,Integer> wordCount)
	{
		StopWordsRemover.removeStopWords(wordCount);
		Set<String> wordSet=new HashSet<String>(); 
		wordSet=wordCount.keySet();
		List<String> wordList=new ArrayList<String>(wordSet);
		Collections.sort(wordList);
		for(String word:wordList){
			System.out.println(word +" : "+ wordCount.get(word));
			str=str+word+","+Integer.toString(wordCount.get(word))+"\n";
		}
	}
	public static void createFileAndWrite(String mystr,File file) {
		PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
        	e.getMessage();
            e.printStackTrace();
        }
        pw.println(mystr);
        pw.flush();
        pw.close();
        createFileAndWriteIsCalled=true;
	}
	public static void writeWordCountToCSV(Map<String,Integer> wordCount) {
		createStringForWritingInCSV(wordCount);
		createFileAndWrite(str,new File("Word-Count.csv"));
	}
}
