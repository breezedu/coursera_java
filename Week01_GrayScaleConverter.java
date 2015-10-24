package coursera_java_duke;

import java.io.File;
import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

/*******
 * 
 * @author Jeff
 *
 */
public class Week01_GrayScaleConverter {
	
	//start with the image I wanted (inImage)
	public ImageResource makeGray(ImageResource inImage){
		
		//make a blank image of the same size as inImage
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		
		//for each pixel in outImage
		for(Pixel pixel: outImage.pixels()){
			
			//look at the corresponding pixel in inImage
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			
			//calculate the inPixel's RGB parameters: inPixel.getRed() ...
			//divide by 3, get the average pixel parameter for outImage
			int average = (inPixel.getRed() + inPixel.getGreen() + inPixel.getBlue())/3;
			
			pixel.setRed(average); // = average;
			pixel.setGreen(average);
			pixel.setBlue(average);
			
					
		}//end for pixel loop;
		
		return outImage;
	}//end make gray method;
	
	public void testGray(){
		
		ImageResource ir = new ImageResource();
		ImageResource gray = makeGray(ir);
		gray.draw();
		gray.saveAs();
		
		
	}//end testGray() method;
	
	
	/***********
	 * Call DirectoryResource method to let user to select image files
	 * convert all images to gray images
	 */
	public void selectAndCovert(){
		
		DirectoryResource dr = new DirectoryResource();
		
		for(File fimage : dr.selectedFiles()){
			
			ImageResource ir = new ImageResource(fimage);
			
			String oriname = ir.getFileName();
			String newName = "gray-" + oriname;
			System.out.println(newName + ". ");
			
			ImageResource gray = makeGray(ir);
			gray.setFileName(newName);
			
			gray.draw();
			gray.save();
		}
		
	}//end selectAndCovert() method; 
	
	/***
	 * main() function;
	 * @param args
	 */
	public static void main(String[] args){
		
		Week01_GrayScaleConverter grayCon = new Week01_GrayScaleConverter();
		//grayCon.testGray();
		
		grayCon.selectAndCovert();
		
	}//end main()

}//ee
