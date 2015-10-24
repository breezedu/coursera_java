package coursera_java_duke;

import java.io.File;

import edu.duke.DirectoryResource;

public class Week01_DirReader {
	
	public void checkDir(){
		DirectoryResource dr = new DirectoryResource();
		
		for(File f : dr.selectedFiles()){
			System.out.println("name:" + f);
			
			String routine = f.getParent() ;// f.getAbsolutePath();
			System.out.println(routine);
		}//end for loop;
	}//end checkDir() method;
	
	public static void main(String[] args){
		
		Week01_DirReader reader = new Week01_DirReader();
		reader.checkDir();
	}

}//ee
