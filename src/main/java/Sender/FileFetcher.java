package Sender;
import java.io.IOException;
import java.util.ResourceBundle;

public class FileFetcher {
	public static ResourceBundle rb=ResourceBundle.getBundle("filepath");
	public static String path=rb.getString("filename");// creating static variable path for accessing it for test cases
	public static String readCsvfileNameFromProperties() throws IOException {
		
		
		if(path.endsWith(".csv")==false)// file format has to be csv
			return ("file format not supported");
		return path;
	}

}
