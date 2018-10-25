import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileIndicator {

	public String filePath;
	public File selectedFile;
	
	public FileIndicator(){
		
		//makes file selection window
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		//restricts file types
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG, JPEG, & PNG Images", "jpg", "png", "jpeg");
		jfc.setFileFilter(filter);
		//displays window
		int returnValue = jfc.showOpenDialog(null);
		//if selects a file, gets the file name and prints path
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = jfc.getSelectedFile();
			filePath = selectedFile.getAbsolutePath();
			System.out.println(selectedFile.getAbsolutePath());
		}

	}
}
