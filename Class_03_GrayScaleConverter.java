package coursera_java_duke;

import edu.duke.ImageResource;
import edu.duke.Pixel;

/*******
 * 
 * @author Jeff
 *
 */
public class Class_03_GrayScaleConverter {
	
	//start with the image I wanted (inImage)
	public ImageResource makeGray(ImageResource inImage){
		
		//make a black image of the same size as inImage
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
	
	/***
	 * main() function;
	 * @param args
	 */
	public static void main(String[] args){
		
		Class_03_GrayScaleConverter grayCon = new Class_03_GrayScaleConverter();
		grayCon.testGray();
		
		
	}//end main()

}//ee
