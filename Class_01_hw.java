package coursera_java_duke;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

//import edu.duke.*;

public class Class_01_hw {

	/***
	 * What this tiny object hw do
	 * to printout "Hello Java Class!"
	 * @throws IOException 
	 */
	public void sayHello() throws IOException{
		System.out.println("Hello Java Class!");
		
		URL url = new URL("http://www.dukelearntoprogram.com/java/hello_unicode.txt");
		Scanner scanUrl = new Scanner(url.openStream());
		
		while(scanUrl.hasNext()){
			String line = scanUrl.nextLine();
			System.out.println(line);
		}
		
		scanUrl.close();
		//URLResource hello = new URLResource("http://www.dukelearntoprogram.com/java/hello_unicode.txt");
		/***
		 for(String line : hello.lines(){
		 	System.out.println(line);
		 	}
		 * 
		 */
	} //end of sayHello object
	
	
	/****
	 * the main() function
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		//create a new object Class_01_hw, name hw1
		Class_01_hw hw1 = new Class_01_hw();
		
		//call one method in hw1, sayHello to printout "Hello Java Class!".
		hw1.sayHello();
	}//end of main()
	
}//ee
