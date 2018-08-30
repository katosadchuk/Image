import java.io.File;
import java.io.IOException;

import org.apache.commons.imaging.ImageReadException;

public class Main {

	//error when selecting directory
	
	public static void parseFiles(File file) throws ImageReadException, IOException{
		
		if(file.isDirectory()){
			File dir = new File(file.getAbsolutePath());
			File[] listOfFiles = dir.listFiles();
			
			for(File f : listOfFiles){
				if(f.isFile()){
					Metadata.getInfo(f);
					System.out.println(f.getName());
				} else {
					parseFiles(f);
				}
			}
		} else {
			Metadata.getInfo(file);
			System.out.println(file.getName());
		}
	}
	
	
	public static void main(String[] args) throws ImageReadException, IOException {
		FileIndicator fi = new FileIndicator();
		parseFiles(fi.selectedFile);
		
		
	}

}
