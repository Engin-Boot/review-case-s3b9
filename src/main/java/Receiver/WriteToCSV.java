package Receiver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToCSV {
	public static void writeWordCountToCSV(Map<String,Integer> wordCount) throws IOException{
		Set<String> wordSet=new TreeSet<String>();
		wordSet=wordCount.keySet();
		List<String[]> data=new ArrayList<String[]>();
		data.add(new String[] {"Word","Count"});
		for(String word:wordSet){
			System.out.println(word +" : "+ wordCount.get(word));
			data.add(new String[] {word,Integer.toString(wordCount.get(word))});
		}
		File file = new File("D:\\BootCamp\\review-case-s3b9\\target\\classes\\example.csv");
		FileWriter outputFile=new FileWriter(file);
		CSVWriter csvWriter=new CSVWriter(outputFile);
		csvWriter.writeAll(data);
		csvWriter.close();
	}
}
