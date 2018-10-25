import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.sql.Connection;
import java.util.ArrayList;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.common.GenericImageMetadata;
import org.apache.commons.imaging.*;
import org.apache.commons.imaging.ImageInfo.ColorType;

public class Metadata {
	

	
	public static ArrayList<Object> getInfo(File file) throws ImageReadException, IOException{
		//gets info
		ImageInfo imageInfo = Imaging.getImageInfo(file);
		
		String format = imageInfo.getFormatName();
		Integer height = imageInfo.getHeight();
		Integer width = imageInfo.getWidth();
		Integer bitsPerPixel = imageInfo.getBitsPerPixel();
		ColorType colorType = imageInfo.getColorType();
		
		Path filePath = file.toPath();
		BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
		FileTime lastAccess = attr.lastAccessTime();
		FileTime lastMod = attr.lastModifiedTime();
		FileTime creation = attr.creationTime();
		long size = attr.size();
		
		
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(format);
		list.add(height);
		list.add(width);
		list.add(bitsPerPixel);
		list.add(colorType);
		list.add(lastAccess);
		list.add(lastMod);
		list.add(creation);
		list.add(size);
		
		return list;
	}

	
	
}