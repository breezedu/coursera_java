package coursera_java_duke;

public class Week2_FindAGene {
	
	public String findGene(String inString){
		
		//Transfer lower letters into upper letters
		String dna = low2Up(inString);
		
		//get the start codon
		int start = dna.indexOf("ATG");
		
		if (start == -1) {
			System.out.println("There's not start codon.");
		}
		
		//get the stop codon, tag, tga, taa, pick the first one appear after start codon
		int stop = -1;
		int stop1 = dna.indexOf("TAG", start + 3 );
		
		if((stop1 - start) % 3 == 0) {
			stop = stop1;
		
		} else {
			int stop2 = dna.indexOf("TGA", start + 3 );
			
			if((stop2 - start) % 3 == 0) stop = stop2;
			
			else {
				int stop3 = dna.indexOf("TAA", start + 3);
				
				if((stop3 - start) % 3 == 0) stop = stop3; 
				else stop = -1;
			
			}//end else 2
			
		}//end else 1
		
		
		//return the gene string;
		if(stop == -1) return "";
		else return dna.substring(start, stop+3);		
		
	}//end findGene() method;
	
	
	
	/**********
	 * Transfer every lower case letter in the string into upper case;
	 * @param inString
	 * @return
	 */
	public String low2Up(String inString){
		
		//if the string is empty, return "";
		if(inString.length() == 0) return "";
				
		//init a new out string "";
		String outString = "";
		
		//check every character in the inString, if it is lower case, transfer into upper case;
		for(int i=0; i<inString.length(); i++){
			
			char currChar = inString.charAt(i);
			
			if(Character.isLowerCase(currChar)){
				
				outString += Character.toUpperCase(currChar);
				
			} else {
				
				outString += currChar;
			}
			
		}//end for loop;
		
		
		//return the new string, with upper case letters only.
		return outString;
	}//end low2Up() method; 
	
	
	public static void main(String[] args){
		
		Week2_FindAGene FAG = new Week2_FindAGene();
		String dna_string = "AATGCTAGTttAAATCTGA";
		
		String gene = FAG.findGene(dna_string);
		
		if(gene.length() == 0) System.out.println("There's no gene found in the dna string.");
		else System.out.println("The gene: " + gene);
		
	}//end main();
	

}//ee
