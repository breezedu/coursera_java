package coursera_java_duke;

import java.util.ArrayList;

/**************
 * 
 * Can I say, THIS ALGORITHM DOES NOT WORK WELL???
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

public class Week2_FindMultiGenes {
	
	//findGenes() method to find all genes
	public ArrayList<String> findGenes(String dnaOri){
		
		//init an arrayList to store all the genes
		ArrayList<String> geneAL = new ArrayList<String>();
		
		//transfer the original dna sequence into Upper case letters
		String DNA = dnaOri.toUpperCase();
		
		//get the start codons and their positions
		int start = -1;
		while(true){
			
			//get next start codon
			start = DNA.indexOf("ATG", start+1);
			
			//if there's no more start codon, break out the while loop
			if(start == -1) 
				break;
			
			//find the stop codon from current start codon
			int stop = findStopCodon(DNA, start);
			
			//get the gene between start and stop codons, add the gene to arrayList 
			if(stop > start){
				
				//get the current gene
				String currGene = dnaOri.substring(start, stop+3);
				
				//add the current gene to gene-ArrayList, and print out the gene sequence
				geneAL.add( currGene );			
				System.out.println("From: " + start + " to " + stop + " Gene: " + currGene );
				
			} //end if stop > start condition
			
		}//end while loop;
		
		
		//return the gene ArrayList;
		return geneAL;
		
		
	}//end findGenes() method
	
	
	
	/*********
	 * Pass one start codon position to the method
	 * Find out the first stop codon after that start codon, then return it's position
	 * Algorithm: 
	 * 1 once the start codon is located
	 * 2 divide all bases following the start codon into 3-base codons
	 * 3 check each codon to see if any codon is equal to "TAG", "TGA", or "TAA"
	 * 4 if we get any hit, then that first hit is the stop codon
	 * 5 return the index position of that stop codon
	 * 6 if no stop codon exist in this "frame", then return -1 as the stop codon position
	 * 
	 * example: GAATGACTGATAGATATGCTTGTA
	 * 1 locate the start codon ATG at index 2
	 * 2 divide and formate the frame: GA-ATG-ACT-GAT-AGA-TAT-GCT-TGA-A
	 * 3 the TGA in the end is the stop codon
	 * 4 return the index of TGA: 20
	 * 5 the gene: from 2 to 20+3;
	 * 
	 * @param DNA
	 * @param start
	 * @return
	 */
	private int findStopCodon(String DNA, int start) {
		// TODO Auto-generated method stub
		
		//once the start codon is located, the 'FRAME' of each 3-base codon is formated.
		for(int i = start + 3; i<DNA.length()-3; i += 3){
			
			//if current 3-base subString is equal to any of three stop codon, return curren index;
			String currFrameString = DNA.substring(i, i+3);
			
			if(currFrameString.equals("TAG")){
				return i;
				
			} else if( currFrameString.equals("TGA")){
				return i;
				
			} else if( currFrameString.equals("TAA")){
				return i;
				
			}//end if-else conditions
			
		}//end for loop;
		
		//if there's no stop codon follow this 'start' codon, return -1 as the false index;
		return -1;
	
	}//end findStopCodon() method;


	
	/************
	 * the main() 
	 * @param args
	 */
	public static void main(String[] args){
		
		
		Week2_FindMultiGenes FMG = new Week2_FindMultiGenes();
		
		String dna = "CATGTAATAGATGAATGACTGATAGATATGCTTGTATGCTATGAAAATGTGAAATGACCCA";
		
		ArrayList<String> geneArrayList = FMG.findGenes(dna);
		
		
		System.out.println("\n There are " + geneArrayList.size() + " genes. ");
		
		for(int i=0; i<geneArrayList.size(); i++){
			System.out.println( geneArrayList.get(i));
		}
		
	}//end main();
	

}//ee
