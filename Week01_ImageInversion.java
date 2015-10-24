package coursera_java_duke;
import edu.duke.*;


public class Week01_ImageInversion{
	
	public ImageResource invertPixels(ImageResource inImage){
		
		//make a blank image the size of inImage
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		
		//for each pixel in the inImage, invert the RGB values 255-x
		
		for(Pixel pixel : outImage.pixels()){
			
			//check the corresponding pixel in inImage
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			
			pixel.setRed(255 - inPixel.getRed());
			pixel.setGreen(255 - inPixel.getGreen());
			pixel.setBlue(255 - inPixel.getBlue());
			
		}//end for pixel loop;
		
		return outImage;
		
	}//end invertPixels() method;
	
	
	public void testInvert(){
		
		//user pick the image 
		ImageResource oriImage = new ImageResource();
		ImageResource invImage = invertPixels(oriImage);
		
		invImage.draw();
		invImage.saveAs();
		
	}//end testInvert() method
	
	
	/**********
	 * main() method
	 * @param args
	 */
	public static void main(String[] args){
		
		Week01_ImageInversion II = new Week01_ImageInversion();
		
		II.testInvert();
		
	}//end main()

}//ee
