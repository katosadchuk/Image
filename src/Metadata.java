import java.io.File;
import java.io.IOException;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.common.ImageMetadata;
import org.apache.commons.imaging.*;

public class Metadata {
	
	public static void getInfo(File file) throws ImageReadException, IOException{
		ImageInfo imageInfo = Imaging.getImageInfo(file);
		imageInfo.dump();
	}
	
	public static void main(String args[]) throws ImageReadException, IOException{
		FileIndicator fi = new FileIndicator();
		File file = fi.selectedFile;
		getInfo(file);
	}
}