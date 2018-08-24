import java.io.File;

public class Main {

	
	
	public static void parseFiles(File file){
		if(file.isDirectory()){
			File dir = new File(file.getAbsolutePath());
			File[] listOfFiles = dir.listFiles();
			for(File f : listOfFiles){
				if(f.isFile()){
					Metadata.readInfo(f);
				} else {
					parseFiles(f);
				}
			}
		} else {
			Metadata.readInfo(file);
		}
	}
	
	
	public static void main(String[] args) {
		FileIndicator fi = new FileIndicator();
		parseFiles(fi.selectedFile);
		
		
	}

}
