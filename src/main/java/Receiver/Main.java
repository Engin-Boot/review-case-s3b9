package Receiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String name = reader.readLine();
            while(name!=null)
            {
                WordCount.countOccuranceOfWord(name);
                name=reader.readLine();
            }
        } catch (IOException e) {
            e.getMessage();
        }
        try {
        WriteToCSV.writeWordCountToCSV(WordCount.wordCount);
        }catch(Exception e){
        	e.getMessage();
        }
	}
}

