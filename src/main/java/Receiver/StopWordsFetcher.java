package Receiver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StopWordsFetcher {
	private StopWordsFetcher() {}
	public static ResourceBundle rb=ResourceBundle.getBundle("filepath");
	public static List<String> stopWordsList=new ArrayList<String>();
	
	public static String readStopWordsFileNameFromProperties() {
		String path=rb.getString("stopwordslist");
		return path;
	}
	public static BufferedReader getFileReader(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			return reader;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void readStopWordsFromTextFile(BufferedReader reader) throws IOException{
		try {
			String name = reader.readLine();
            while(name!=null)
            {
                stopWordsList.add(name);
                name=reader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		reader.close();
	}
}