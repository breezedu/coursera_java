package coursera_java_duke;

import java.io.File;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class Week03_FindColdestAndLowHumidityDay {
	
	
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
	
	

	
	
	
	//Part 3: This method should return a string that is the name of the file from selected files that has the coldest temperature. 
	//You should also write a void method named testFileWithColdestTemperature() to test this method. 
	//Note that after determining the filename, you could call the method coldestHourInFile to determine the coldest temperature on that day.
	public void fileWithColdestTemperature (){
		
		System.out.println("\n\n\n");
		System.out.println("****************************************************");
		System.out.println("Part Two: ");
		
		System.out.println("Select the files to find out the codest temperature:");
		
		System.out.println("****************************************************");		
		
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
	
	
	
	//a method named lowestHumidityInFile that has one parameter, a CSVParser named parser. 
	//This method returns the CSVRecord that has the lowest humidity.
	public CSVRecord lowestHumidityInFile (CSVParser parser){
		
		//generate a null lowHumid CSV record
		CSVRecord lowHumid = null;
		
		for(CSVRecord record : parser){
			
			String currHumid = record.get("Humidity");
			
			if(!currHumid.equals("N/A")){

				double numHumid = Double.parseDouble( record.get("Humidity") );
				
				if(lowHumid == null || numHumid < Double.parseDouble( lowHumid.get("Humidity") ) )
					lowHumid = record;
			}
			
			
		}//end for CSVRecord loop;
		
		
		return lowHumid;
	}//end lowestHumidityInFile() method
	
	
	
	
	
	/************************
	 * the main()
	 * @param args
	 */
	public static void main(String[] args){
		
		Week03_FindColdestAndLowHumidityDay W3_FCD = new Week03_FindColdestAndLowHumidityDay(); 
		
		W3_FCD.testColdestHourInFile();
		
		W3_FCD.fileWithColdestTemperature();
		
		W3_FCD.testLowestHumidityInFile();
		
	}//end main();


	
	//teset lowest humidity in File() method;
	private void testLowestHumidityInFile() {
		// TODO Auto-generated method stub
		System.out.println("\n\n");
		System.out.println("****************************************************");
		System.out.println("Part Three: ");
		
		System.out.println("Select one file to find out the lowest humidity:");
		
		System.out.println("****************************************************");		
		
		
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		CSVRecord csv = lowestHumidityInFile(parser);
		
		System.out.println("The lowest humidity in File is: " + csv.get("Humidity") +" at " + csv.get("DateUTC") );
		
	}//end testLowestHumidityInFile();
	
	
	
	
	//Part 2
	//test the method of coldestHourInFile()
	public void testColdestHourInFile(){
		
		System.out.println("****************************************************");
		System.out.println("Part One: ");
		
		System.out.println("Select one file to find out the codest temperature:");
		
		System.out.println("****************************************************");		
		//get the file
		FileResource file = new FileResource();
		
		//get the CSV table
		CSVParser parse = file.getCSVParser();
		
		
		CSVRecord coldestR = coldestHourInFile(parse);
		
		System.out.println("The coldest hour is: " + coldestR.get("TimeEST") + ", " + coldestR.get("TemperatureF"));
		
	}//end testCodestDay()
	

}//ee
