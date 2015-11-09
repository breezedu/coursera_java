package coursera_java_duke;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import edu.duke.FileResource;

public class Week03_ExportCSV_HW {
	
	
	//write a method tester, to create a CSV parser from reading in a local CSV file
	public void tester(){
		
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		
		
		/*******************************
		for(CSVRecord record : parser){
			
			String export = record.get("Exports");
			
			if(export.contains("coffee"))
				System.out.println(record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)"));
				
			
		}//end for loop;
		*/
		
		//For part 2:
		//Reset CSV-Parser each time before call a new method();
		parser = fr.getCSVParser();
		countryInfo(parser, "Nauru");
		
		
		
		
		//For part 3:
		//Write a void method named listExportersTwoProducts that has three parameters,
		parser = fr.getCSVParser();
		listExportersTwoProducts(parser, "gold", "diamond");
		
		
		
		//For part 4:
		//Write a method named numberOfExporters, which has two parameters, 
		//parser is a CSVParser, and exportItem is a String. 
		//This method returns the number of countries that export exportItem. 
		parser = fr.getCSVParser();
		numberOfExporters(parser, "gold");
		
		
		
		//For part 5:
		//Write a void method named bigExporters that has two parameters, parser is a CSVParser, 
		//and amount is a String in the format of a dollar sign $999,999
		parser = fr.getCSVParser();
		bigExporters(parser, "$999,999,999,999");
		
		
		//return the parser
		//return parser;
	}//end tester() method;
	
	
	
	//Part 5:
	private void bigExporters(CSVParser parser, String money) {
		// TODO Auto-generated method stub
		System.out.println("\nPart V");
		
		for(CSVRecord record : parser){
			
			String currValue = record.get("Value (dollars)");
			
			if(currValue.length() > money.length()){
				
				System.out.println("Count: " + record.get("Country") + ", " + record.get("Value (dollars)") );
			}
			
		}//end for parser loop;
		
	}//end bigExporters() method;



	/*********
	 * Part 4
	 * @param parser
	 * @param element
	 */
	private void numberOfExporters(CSVParser parser, String element) {
		// TODO Auto-generated method stub
		int count = 0; //the count of countries with the exporting element
		
		for(CSVRecord record : parser){
			
			String exports = record.get("Exports");
			if(exports.contains(element))
				count ++;
			
		}//end for loop;
		
		
		System.out.println("\nPart IV:\n There are " + count + " countries export " + element + ". ");
		
	}//end numberOfExporters() method;




	/***********
	 * Part 3
	 * @param parser
	 * @param element1
	 * @param element2
	 */
	private void listExportersTwoProducts(CSVParser parser, String element1, String element2) {
		// TODO Auto-generated method stub
		System.out.println();
		
		for(CSVRecord record : parser){
			
			String Exports = record.get("Exports");
			if(Exports.contains(element1) && Exports.contains(element2)){
				
				System.out.println("Part III hit: " + record.get("Country") + " " + record.get("Exports"));
			}
			
		}//end for loop;
		
		
	}//end listExportersTwoProducts() method;




	//a method named countryInfo that has two parameters, parser is a CSVParser and country is a String. 
	//This method returns a string of information about the country or returns “NOT FOUND” 
	/**********
	 * Part 2
	 * @param parser
	 * @param country
	 */
	public void countryInfo(CSVParser parser, String country){
		
		System.out.println("Part II");
		
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
