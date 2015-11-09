package coursera_java_duke;

import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class Week03_FindColdestDay {
	
	
	//Part 1
	//This method returns the CSVRecord with the coldest temperature in the file and 
	//thus all the information about the coldest temperature, such as the hour of the coldest temperature.
	public CSVRecord coldestHourInFile(CSVParser parser){
		
		CSVRecord codestR = null;
		
		for(CSVRecord record : parser){
			
			
			
			double currTemp = Double.parseDouble(record.get("TemperatureF"));
			
			if(currTemp < -100){
				//do nothing
				
			} else if (codestR == null || Double.parseDouble(codestR.get("TemperatureF")) > currTemp ){
				
				codestR = record;
				
			}//end if-else conditions
			
		}
		
		
		return codestR;
	}//end coldestHourInFile() method;
	
	
	
	//Part 2
	//test the method of coldestHourInFile()
	public void testColdestHourInFile(){
		
		//get the file
		FileResource file = new FileResource();
		
		//get the CSV table
		CSVParser parse = file.getCSVParser();
		
		
		CSVRecord coldestR = coldestHourInFile(parse);
		
		System.out.println("The coldest hour is: " + coldestR.get("TimeEST") + ", " + coldestR.get("TemperatureF"));
		
	}//end testCodestDay()
	
	
	
	
	//Part 3: This method should return a string that is the name of the file from selected files that has the coldest temperature. 
	//You should also write a void method named testFileWithColdestTemperature() to test this method. 
	//Note that after determining the filename, you could call the method coldestHourInFile to determine the coldest temperature on that day.
	public void fileWithColdestTemperature (){
		
		//select the CSV file
		DirectoryResource dr = new DirectoryResource();

		CSVRecord codestR = null;
		File codestF = null;
		
		for( File f : dr.selectedFiles()){
			
			
		//	System.out.println("The codest temperature in file: " + f.getName());
			
			FileResource fr = new FileResource(f);
			CSVParser parse = fr.getCSVParser();
			
			CSVRecord currRecord = coldestHourInFile(parse);
			
			if(codestR == null || Double.parseDouble( currRecord.get("TemperatureF") ) < Double.parseDouble( codestR.get("TemperatureF") )){
				
				codestR = currRecord;
				codestF = f;
			}
			
		}//end for loop;
		
		
		//Printout the name of the File contains the codes temperature, and the temperature.
		System.out.println("\n The codest hour is in File: " + codestF.getName() + ". \nThe temperature is: " + codestR.get("TemperatureF"));
		
		
		//Printout all the temperatures in that file:
		System.out.println("\nAll the Temperatures on the coldest day were: ");
		
		FileResource fr = new FileResource(codestF);
		CSVParser parse = fr.getCSVParser();
		
		for(CSVRecord R : parse){
			
			System.out.println(codestF.getName() + " " + R.get("TimeEST") + "  " + R.get("TemperatureF") );
		}
		
		//String file_name = f;
		//get the CSV data table
		//
		
		
	}//end fileWithColdestTemperature() method;
	
	
	
	public static void main(String[] args){
		
		Week03_FindColdestDay W3_FCD = new Week03_FindColdestDay(); 
		
		W3_FCD.testColdestHourInFile();
		
		W3_FCD.fileWithColdestTemperature();
		
	}
	

}//ee
