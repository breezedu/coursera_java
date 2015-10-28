package week02;

import java.util.ArrayList;

import edu.duke.FileResource;

/**************
 * 
 * THIS ALGORITHM IS A FAKE ONE!
 * 
 * Algorithm to identify multiple genes in a strand of DNA
 * 
 * To find the first gene, find the start codon ATG.
 * Next look immediately past ATG for the first occurrence of each of the three stop codons TAG, TGA, and TAA.
 * If the length of the substring between ATG and any of these three stop codons is a multiple of three, 
 * then a candidate for a gene is the start codon through the end of the stop codon.
 * If there is more than one valid candidate, the smallest such string is the gene. 
 * The gene includes the start and stop codon.
 * If no start codon was found, then you are done.
 * If a start codon was found, but no gene was found, 
 * then start searching for another gene via the next occurrence of a start codon 
 * starting immediately after the start codon that didn't yield a gene.
 * If a gene was found, then start searching for the next gene immediately after this found gene.
 * 
 * @author Jeff
 *
 */
public class Week02_FindMultiGenesFileFAKE {
	
	//find the genes: 1st find start codon, then find the stop codon after that
	public void findGenes(String dna){
		
		//transfer all lower case letter into upper case;
		String DNA = dna.toUpperCase();
		
		int CTGCount = countCTG(DNA);
		System.out.println("There are " + CTGCount + " CTGs in the DNA.");
		
		ArrayList<String> dnaAL = new ArrayList<String>();
		
		int start = 0;
		while(true){
			
			int loc = DNA.indexOf("ATG", start);
			
			//if there's no start codon, stop checking, jump out of while loop;
			if (loc == -1) break;			
			
			//find the index of stop codon to current start codon;
			int stop = findStopCodon(DNA, loc);
			
			
			if(stop < DNA.length()){
				
				
				String currGene = dna.substring(loc, stop+3);
				
			/********
			 * Once again, this is really a joke!
			 * of all the 89 genes found by this FAKE algorithm
			 * 8 are duplicated genes!
			 * and, I spent almost a whole night trying to figure out
			 * where is the "bug" of my code.
			 * turned out, there's no bug!!!	
			 */
			//	if(!dnaAL.contains( currGene )){
					
					dnaAL.add( currGene );
				
					System.out.println("GENE: from " + loc + " to " + stop +": " + currGene);
				
					loc = stop;
				
			//	}//end if dnaAL.contain( currGene ) conditon; 
				
			}//end if stop < DNA.length condition;
			
			start = loc + 3;
			
		}//end while
		
		System.out.println("There are " + dnaAL.size() + " genes.");
		
		
		
		//check how many genes in the dnaAL longer than 60;
		int longerthan60 = 0;
		int ratio35 = 0; 
		int longGene = 0;
		
		for(String gene : dnaAL){
			
			if(gene.length() > longGene) longGene = gene.length();
			
			if(gene.length() > 60) longerthan60++;
			
			if(ratioGreaterthan35(gene)) ratio35++;
		
		}//end for loop;
		
		System.out.println("The longest gene's length is: " + longGene);
		System.out.println("\nThere are " + longerthan60 + " genes longer than 60");
		System.out.println("There are " + ratio35 + " genes with CG ratio > 0.35");
		
	}//end findGenes() method;

	
	private int countCTG(String dna) {
		// TODO Auto-generated method stub
		
		int len = dna.length()-3;
		int count = 0;
		for(int i=0; i<len; i++){
			
			if( dna.substring(i, i+3).equals("CTG"))
				count++;
		}
		
		return count;
	}//end countCTG() method;


	private boolean ratioGreaterthan35(String gene) {
		// TODO Auto-generated method stub
		
		String DNA = gene.toUpperCase();
		
		int cgCount = 0;
		for(int i=0; i< gene.length(); i++){
			if(DNA.charAt(i) == 'C' || DNA.charAt(i) == 'G')
				cgCount++;
		}
		
		//System.out.print(" " + cgCount + "/" + DNA.length());
		
		if(cgCount > DNA.length() *0.35) return true;
		
		
		return false;
	}


	//find stop codons: TAG, TGA, and TAA
	private int findStopCodon(String DNA, int start) {
		// TODO Auto-generated method stub
		
		int stop1 = DNA.indexOf("TAG", start + 3);
		int stop2 = DNA.indexOf("TGA", start + 3);
		int stop3 = DNA.indexOf("TAA", start + 3);
		
		//return the minimum stop which is not -1, also distance to start %3 gives 0;
		if (stop1 == -1 || (stop1 - start)%3 != 0) stop1 = DNA.length();
		if (stop2 == -1 || (stop2 - start)%3 != 0) stop2 = DNA.length();
		if (stop3 == -1 || (stop3 - start)%3 != 0) stop3 = DNA.length();
		
		return Math.min(stop1, Math.min(stop2, stop3));
		
	}//end findStopCodon() method;
	
	
	//read a DNA string from a file
	private static String readStringFromFile() {
		// TODO Auto-generated method stub
		FileResource FR = new FileResource();
		String dna = FR.asString();
		
		return dna;
		
	}//end readStringFromfile() method;
	
	
	/************
	 * main() method
	 * @param args
	 */
	public static void main(String[] args){
		
		Week02_FindMultiGenesFileFAKE FMGFake = new Week02_FindMultiGenesFileFAKE();
		
		String dna = readStringFromFile();
		
		FMGFake.findGenes(dna);
		
	}//end main()




}//ee
