package coursera_java_duke;

import java.io.File;

import edu.duke.DirectoryResource;

public class Class_02_DirReader {
	
	public void checkDir(){
		DirectoryResource dr = new DirectoryResource();
		
		for(File f : dr.selectedFiles()){
			System.out.println(f);
			
			String routine = f.getAbsolutePath();
			System.out.println(routine);
		}//end for loop;
	}//end checkDir() method;
	
	public static void main(String[] args){
		
		Class_02_DirReader reader = new Class_02_DirReader();
		reader.checkDir();
	}

}//ee
