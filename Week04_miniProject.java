package week04;

import org.apache.commons.csv.CSVRecord;

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
		miniP.totalBirths();
		
		
		
		//2nd method named getRank that has three parameters: 
		//an integer named year, a string named name, and a string named gender 
		//(F for female and M for male). 
		//This method returns the rank of the name in the file for the given gender
		int year = 2012;
		String name = "Mason";
		String gender = "M";
		int rank = miniP.getRank(year, name, gender);
		System.out.println("The name " + name + " ranks " + rank + " at year " + year);
		
		
		
		//3rd Write the method named getName that has three parameters: 
		//an integer named year, an integer named rank, and a string named gender 
		//(F for female and M for male). 
		//This method returns the name of the person in the file at this rank, for the given gender.
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
		
		
		
	}//end of main();

	
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
		System.out.println("\n question 3: ");
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
		System.out.println("\n Question 2:" );
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
		System.out.println("\n Question 1:" );
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
