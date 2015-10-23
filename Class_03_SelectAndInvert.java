package coursera_java_duke;

import java.io.File;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;

public class Class_03_SelectAndInvert {
	
	public void selectAndInvert(){
		DirectoryResource dr = new DirectoryResource();
		
		for(File inFile : dr.selectedFiles()){
			
			ImageResource inImage = new ImageResource(inFile);
			
			String oriName = inImage.getFileName();
			String newName = "Inver-" + oriName;
			
			Class_03_ImageInversion imageInvert = new Class_03_ImageInversion();
			ImageResource outImage = imageInvert.invertPixels(inImage);
			
			outImage.setFileName(newName);
			outImage.draw();
			outImage.save();
		}//end for loop;
		
	}//end selectAndInvert() method;
	
	public static void main(String[] args){
		
		Class_03_SelectAndInvert SAI = new Class_03_SelectAndInvert();
		SAI.selectAndInvert();
		
	}//end main();

}//ee
