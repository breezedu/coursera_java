package coursera_java_duke;

public class Week2_FindAGene {
	
	/********
	 * Find a gene in a dna string;
	 * 1st, get the start codon
	 * 2nd, figure if the next TAG is 3x base away from the start codon, if yes, then get a gene
	 * 3rd, if TAG is not the ideal stop codon, try TGA
	 * 4th, if TGA does not work, try TAA
	 * 5th, return the gene sequence;
	 * 
	 * @param inString
	 * @return
	 */
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
	
	
	/*******
	 * find the stop codon of a gene
	 * 1st, if it is an empty string, return "";
	 * else, return the last three letters of that gene;
	 * @param gene
	 * @return
	 */
	public String findStopCodon(String gene){
			
		if(gene.length() == 0) return "";		
		else return gene.substring(gene.length() - 3);
		
		//return stopCodon;
		
	}//end findStopCodon() method;
	
	
	/********
	 * the main() method;
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		//create a new FindAGene object;
		Week2_FindAGene FAG = new Week2_FindAGene();
		
		
		//init the original DNA string;
		String dna_string = "AATGCTAGTttAAATCTGAGGCCTT";
		
		//call FAG.findGene() method to locate a gene inside that DNA string;
		String gene = FAG.findGene(dna_string);
		
		//after locating the gene, call FAG.findStopCodon() method to ge the stop codon of that gene
		String stopCodon = FAG.findStopCodon(gene);
		
		
		//printout the gene and the stop codon;
		if(gene.length() == 0) System.out.println("There's no gene found in the dna string.");
		else System.out.println("The gene: " + gene);
		
		System.out.println("The stop codon: " + stopCodon);
		
	}//end main();
	

}//ee
