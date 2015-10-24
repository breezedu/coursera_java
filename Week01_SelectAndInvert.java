package coursera_java_duke;

import java.io.File;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;

/**************
 * Select some images from one folder
 * then transfer these images into inverted color
 * save them to the project folder, with a "inver-" in front of the original names
 * 
 * @author Jeff
 *
 */
public class Week01_SelectAndInvert {
	
	/*******
	 * SelectAndInvert() method
	 * Let the user to select the folder and images inside that folder
	 */
	public void selectAndInvert(){
		
		//select the folder with images
		DirectoryResource dr = new DirectoryResource();
		
		//for loop iterate all selected files/images
		for(File inFile : dr.selectedFiles()){
			
			//turn the selected file into image
			ImageResource inImage = new ImageResource(inFile);
			
			//pick the original name add "inver-" in front, which is the new name
			String oriName = inImage.getFileName();
			String newName = "Inver-" + oriName;
			
			//call Week01_ImageInversion class to create an object imageInvert
			//use the method imageInvert.invertPixels() to transfer the image color into invert color
			Week01_ImageInversion imageInvert = new Week01_ImageInversion();
			ImageResource outImage = imageInvert.invertPixels(inImage);
			
			//set new name, draw the new image, and save
			outImage.setFileName(newName);
			outImage.draw();
			
			outImage.save();
			//outImage.saveAs();
			
		}//end for loop;
		
	}//end selectAndInvert() method;
	
	
	/*********
	 * the main() method
	 * @param args
	 */
	public static void main(String[] args){
		
		Week01_SelectAndInvert SAI = new Week01_SelectAndInvert();
		SAI.selectAndInvert();
		
	}//end main();

}//ee
