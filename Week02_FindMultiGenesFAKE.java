package week02;

import java.util.ArrayList;

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
public class Week02_FindMultiGenesFAKE {
	
	//find the genes: 1st find start codon, then find the stop codon after that
	public void findGenes(String dna){
		
		//transfer all lower case letter into upper case;
		String DNA = dna.toUpperCase();
		ArrayList<String> dnaAL = new ArrayList<String>();
		
		int start = -1;
		while(true){
			
			int loc = DNA.indexOf("ATG", start);
			
			if (loc == -1) break;			
			
			int stop = findStopCodon(DNA, loc);
			
			if(stop < DNA.length()){
				
				dnaAL.add( dna.substring(loc, stop+3));
				System.out.println("GENE: from " + loc + " to " + stop +": " + 
									dna.substring(loc, stop+3));
			
				//find next gene after this gene, what a joke! again!
				loc = stop;
			}//end if
			
			start = loc + 3;
		}//end while
		
	}//end findGenes() method;

	
	//find stop codons: TAG, TGA, and TAA
	private int findStopCodon(String DNA, int start) {
		// TODO Auto-generated method stub
		int stop1 = DNA.indexOf("TAG", start + 3);
		int stop2 = DNA.indexOf("TGA", start + 3);
		int stop3 = DNA.indexOf("TAA", start + 3);
		
		//return the minimum stop which is not -1;
		if (stop1 == -1 || (stop1 - start)%3 != 0) stop1 = DNA.length();
		if (stop2 == -1 || (stop2 - start)%3 != 0) stop2 = DNA.length();
		if (stop3 == -1 || (stop3 - start)%3 != 0) stop3 = DNA.length();
		
		return Math.min(stop1, Math.min(stop2, stop3));
	}//end findStopCodon() method;
	
	
	public static void main(String[] args){
		
		Week02_FindMultiGenesFAKE FMGFake = new Week02_FindMultiGenesFAKE();
		String dna = "CATGTAATAGATGAATGACTGATAGATATGCTTGTATGCTATGAAAATGTGAAATGACCCA";
		
		FMGFake.findGenes(dna);
		
	}//end main()

}//ee
