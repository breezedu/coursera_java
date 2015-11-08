package coursera_java_duke;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

public class Week03_ExportCSV {
	
	
	//write a method tester, to create a CSV parser from reading in a local CSV file
	public void tester(){
		
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		
		
		/*******************************/
		for(CSVRecord record : parser){
			
			String export = record.get("Exports");
			
			if(export.contains("coffee"))
				System.out.println(record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)"));
				
			
		}//end for loop;
		
		
		//For part 2:
		//Reset CSV-Parser each time before call a new method();
		parser = fr.getCSVParser();
		countryInfo(parser, "Germany");
		
		
		
		
		//For part 3:
		//Write a void method named listExportersTwoProducts that has three parameters,
		parser = fr.getCSVParser();
		listExportersTwoProducts(parser, "gold", "diamond");
		
		
		//return the parser
		//return parser;
	}//end tester() method;
	
	
	
	
	private void listExportersTwoProducts(CSVParser parser, String element1, String element2) {
		// TODO Auto-generated method stub
		
		for(CSVRecord record : parser){
			
			String Exports = record.get("Exports");
			if(Exports.contains(element1) && Exports.contains(element2)){
				
				System.out.println("Part II hit: " + record.get("Country") + " " + record.get("Exports"));
			}
			
		}//end for loop;
		
		
	}//end listExportersTwoProducts() method;




	//a method named countryInfo that has two parameters, parser is a CSVParser and country is a String. 
	//This method returns a string of information about the country or returns “NOT FOUND” 
	public void countryInfo(CSVParser parser, String country){
		
		for(CSVRecord record : parser){
			
			String currCountry = record.get("Country");
			
			//System.out.println("country: " + currCountry);
			
			if(currCountry.contains(country)){
				
				System.out.println("\n One hit: " + record.get("Country") + " " + record.get("Exports") +" " + record.get("Value (dollars)") );
			}//end if condition
			
		}//end for loop;
		
	}//end countryInfo() method;
	
	
	
	
	/*************
	 * main()
	 * @param args
	 */
	public static void main(String[] args){
		
		Week03_ExportCSV W03 = new Week03_ExportCSV();
		W03.tester();
		
		//W03.countryInfo(parser,  "Germany");
		
		
	}//end main()
	

}
