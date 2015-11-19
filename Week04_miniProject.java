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
		
	}//end of main();

	
	
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



	//1st Modify the method totalBirths, print out number of girls/boys and total
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
