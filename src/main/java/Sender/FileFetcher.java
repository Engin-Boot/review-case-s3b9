package Sender;
import java.io.IOException;
import java.util.ResourceBundle;

public class FileFetcher {
	public static ResourceBundle rb=ResourceBundle.getBundle("filepath");
	public static String path=rb.getString("filename");
	public static String readCsvfileNameFromProperties() throws IOException {
		
		
		if(path.endsWith(".csv")==false)
			return ("file format not supported");
		return path;
	}

}
