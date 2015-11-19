package week04;

import java.io.File;

import org.apache.commons.csv.CSVRecord;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

/**********************
 * providing data on baby names from the United States and 
 * you will answer questions about this data. 
 * The data files give information on the first names of people born 
 * in a particular year. We have data from 1880 through 2014 on both boys and girls names.
 *  
 * @author Jeff
 *
 */
public class Week04_miniProject {

		
	/************
	 * main()
	 * @param args
	 */
	public static void main(String[] args){
		
		Week04_miniProject miniP = new Week04_miniProject();
		
		
		//1st Modify the method totalBirths, print out number of girls/boys and total
		System.out.println("\n Question 1:" );
		miniP.totalBirths();
		
		
		
		//2nd method named getRank that has three parameters: 
		//an integer named year, a string named name, and a string named gender 
		//(F for female and M for male). 
		//This method returns the rank of the name in the file for the given gender
		System.out.println("\n Question 2:" );
		
		int year = 2012;
		String name = "Isabella";
		String gender = "F";
		int rank = miniP.getRank(year, name, gender);
		System.out.println("The name " + name + " ranks " + rank + " at year " + year);
		
		
		
		//3rd Write the method named getName that has three parameters: 
		//an integer named year, an integer named rank, and a string named gender 
		//(F for female and M for male). 
		//This method returns the name of the person in the file at this rank, for the given gender.
		System.out.println("\n question 3: ");
		
		year = 2012;
		rank = 2;
		gender = "M";
		String rankName = miniP.getName(year, rank, gender);
		System.out.println("The " + gender + " name ranked " + rank + " is: " + rankName +". " );
		
		
		
		//4th What would your name be if you were born in a different year? 
		//Write the void method named whatIsNameInYear that has four parameters: 
		//a string name, an integer named year representing the year that name was born, 
		//an integer named newYear and a string named gender (F for female and M for male).
		//This method determines what name would have been named if they were born in a different year, 
		//based on the same popularity.
		System.out.println("\n question 4:" );
		
		int year1 = 2012;
		int year2 = 2014;
		gender = "F";
		name = "Isabella";
		miniP.whatIsNameInYear(name, year1, year2, gender);
		
		
		
		//5th method yearOfHighestRank that has two parameters: 
		//a string name, and a string named gender (F for female and M for male). 
		//This method selects a range of files to process and returns an integer, 
		//the year with the highest rank for the name and gender.
		System.out.println("\n question 5: ");
		name = "Mason"; 
		gender = "M";
		int highestRank = miniP.yearOfHighestRank(name, gender);
		System.out.println("The highest rank for the name " + name + " gender " + gender + " is at year " + highestRank );
		
		
		
	}//end of main();

	/**********
	 * 5th question:
	 * @param name
	 * @param gender
	 * @return
	 */
	private int yearOfHighestRank(String name, String gender) {
		// TODO Auto-generated method stub
		
		//initial year and rank;
		int rank = 1000000;
		int yearHigh = 0;
		
		//get the directory:
		DirectoryResource dr = new DirectoryResource();
		
		//get the files
		for(File fi : dr.selectedFiles()){
			
			//get the name of the file, which contains the year
			String fileName = fi.getName();
			
			//get the year integer from the name of the file
			int year = Integer.parseInt(fileName.replaceAll("[\\D]", ""));
			
			//get the FileResource
			FileResource fr = new FileResource(fi);
			
			int currRank = 0;
			for(CSVRecord record : fr.getCSVParser(false)){
				
				if(record.get(1).equals(gender)) currRank++;
				
				if(record.get(0).equals(name)) break;
			}//end for loop;
			
			//int currRank = getRank(year, name, gender);
			System.out.println("  At year " + year + " name " + name + " ranks " + currRank + ". ");
			
			if(currRank != -1 && currRank < rank){
				rank = currRank;
				yearHigh = year;
			}//end if condition;
		
		}//end for File fi loop;
		
		return yearHigh;
	}


	/*************
	 * 4th question;
	 * get the name of the same popularity in another year, give the same gender;
	 * @param name
	 * @param year
	 * @param year2 
	 * @param gender
	 */
	private void whatIsNameInYear(String name, int year1, int year2, String gender) {
		// TODO Auto-generated method stub

		
		int rank = getRank(year1, name, gender);
		//System.out.println(name + " ranks " + rank + " at year " + year1);
		String equalName = getName(year2, rank, gender);
		
		//Isabella born in 2012 would be Sophia if she was born in 2014.
		System.out.println( name + " born in " + year1 + " would be " + equalName + " if she was born in " + year2);
		
	}//end whatIsNameInYear() method;


	/***********
	 * 3rd question;
	 * given the rank and gender, return a name in a certain file;
	 * @param year
	 * @param rank
	 * @param gender
	 * @return
	 */
	private String getName(int year, int rank, String gender) {
		// TODO Auto-generated method stub
		
		//get the file
		FileResource fr = new FileResource();
		
		int pivot = 0;
		//get the CSV file
		for(CSVRecord record : fr.getCSVParser(false)){
			
			if(record.get(1).equals(gender)) pivot ++;
			
			if(pivot == rank) return record.get(0);
			
		}//end for CSV record loop;
		
		
		return "NO NMAE";
		
	}//end getName() method;



	/******
	 * 2nd question:
	 * get the rank of a certain name in a file, give the gender;
	 * @param year
	 * @param name
	 * @param gender
	 * @return
	 */
	private int getRank(int year, String name, String gender) {
		// TODO Auto-generated method stub

		//get the file
		FileResource fr = new FileResource();
				
		int pivotF = 0;
		int pivotM = 0;
		
		for(CSVRecord record : fr.getCSVParser(false)){
			
			//for female records
			if(record.get(1).equals("F")) {
				
				//the pivot of Female ++
				pivotF++;
				if(record.get(0).equals(name)) return pivotF;
			}
			
			//for male reocrds
			if(record.get(1).equals("M")) {
				
				//the pivot of Male ++
				pivotM++;
				if(record.get(0).equals(name)) return pivotM;
			} 
			
		}//end for CSV record loop;
			
		return -1;
			
	}//end getRank() method;



	/***************
	 * 1st question:
	 * Modify the method totalBirths, print out number of girls/boys and total
	 */
	private void totalBirths() {
		// TODO Auto-generated method stub

		//get the file, 
		FileResource fr = new FileResource();
		
		//get the CSV, parser the CSV
		int numGirl = 0;
		int numBoy = 0;
		int sum = 0;
		for(CSVRecord record : fr.getCSVParser(false)){
			String gender = record.get(1);
			int num = Integer.parseInt(record.get(2));
			
			if(gender.equals("F")) numGirl += num;
			else numBoy += num;
			
			sum += num;
			
		}//end for csvrecord loop;
		
		
		//printout num of girls, boys, and total
		System.out.println("Girls: " + numGirl +", Boys: " + numBoy +", Total: " + sum);
		
	}//end of totalBirths() method;
	
	
}//ee
