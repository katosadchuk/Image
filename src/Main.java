import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.imaging.ImageReadException;

public class Main {
	protected static ArrayList<ArrayList<Object>> allData = new ArrayList<ArrayList<Object>>();

	protected static void parseFiles(File file) throws ImageReadException, IOException {
		if (file.isDirectory()) {
			File[] listOfFiles = file.listFiles();

			for (File f : listOfFiles) {
				if (f.isFile() && !f.isHidden()) {
					ArrayList<Object> list = Metadata.getInfo(f);
					allData.add(list);
				} else if (f.isDirectory()) {
					parseFiles(f);
				}
			}
		} else {
			ArrayList<Object> list = Metadata.getInfo(file);
			allData.add(list);
		}
	}
	
	protected static void addToDB(){
		//method that will iterate through list of lists and add entries to DB
	}

	public static void main(String[] args) throws ImageReadException, IOException {
		FileIndicator fi = new FileIndicator();
		
		parseFiles(fi.selectedFile);
		
		DBConnector conn = new DBConnector();
		conn.createTable("ImageData");
		addToDB();

	}

}
