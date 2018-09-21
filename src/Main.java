import java.io.File;
import java.io.IOException;
import org.apache.commons.imaging.ImageReadException;

public class Main {
	
   

	public static void parseFiles(File file) throws ImageReadException, IOException {

		if (file.isDirectory()) {
			File[] listOfFiles = file.listFiles();

			for (File f : listOfFiles) {
				if (f.isFile() && !f.isHidden()) {
					Metadata.getInfo(f);
				} else if (f.isDirectory()) {
					parseFiles(f);
				}
			}
		} else {
			Metadata.getInfo(file);
		}
	}

	public static void main(String[] args) throws ImageReadException, IOException {
		FileIndicator fi = new FileIndicator();
		parseFiles(fi.selectedFile);

	}

}
