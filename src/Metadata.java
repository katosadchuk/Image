import java.io.File;
import java.io.IOException;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.lang.GeoLocation;
import com.drew.metadata.exif.GpsDirectory;

public class Metadata {

	
	public static void readInfo(File file){
		String name = file.getName();
		try {
			com.drew.metadata.Metadata metadata = ImageMetadataReader.readMetadata(file);
			System.out.println(metadata);
		} catch (ImageProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
