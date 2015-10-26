package coursera_java_duke;

import java.util.ArrayList;

import edu.duke.FileResource;
import edu.duke.StorageResource;

/**************
 * 
 * Can I say, THE ORIGINAL ALGORITHM DOES NOT WORK WELL???
 * 
 * Algorithm to identify multiple genes in a strand of DNA
 * 
 * This code could not give the 'correct' answers to the quiz
 * 
 * but I believe this code would provide the correct answers!
 * 
 * @author Jeff
 *
 */

public class Week2_FindMultiGenesFile {
	
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
				if( !geneAL.contains(currGene))
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

	
	/*****************
	 * Read DNA string from a file;
	 * @return
	 */
	public String readStrFromFile(){
		
		FileResource readFile = new FileResource();
		
		String DNA = readFile.asString();
		
		//System.out.println("DNA: " + DNA);
		
		return DNA;
		
	}//end readStrFromFile() method;
	
	public float calCGRatio(String gene){
		
		gene = gene.toUpperCase();	
		int len = gene.length();
		int CGCount = 0;
		
		for(int i=0; i<len; i++){
						
			if(gene.charAt(i) == 'C' || gene.charAt(i) == 'G')
				CGCount++;
			
		}//end for loop
		
		System.out.println("CGCount " + CGCount + " Length: " + len + " Ratio: " + (float)CGCount/len);
		return (float)CGCount/len;
	}//end of calCGRatio() method;

	
	/************
	 * the main() 
	 * @param args
	 */
	public static void main(String[] args){
		
		//create a FindMultiGenesFile object FMG
		Week2_FindMultiGenesFile FMG = new Week2_FindMultiGenesFile();
		
		//read a DNA sequence from file
		String dna = FMG.readStrFromFile();
		
		//call FMG.findGenes() method to get all genes, and store all genes in an ArrayList
		ArrayList<String> geneArrayList = FMG.findGenes(dna);
		
		//store all genes into a document
		StorageResource dnaStore = new StorageResource();
		
		System.out.println("\n There are " + geneArrayList.size() + " genes. ");
		
		int longerthan60 = 0;
		int CGGreaterthan35 = 0;
		for(int i=0; i<geneArrayList.size(); i++){
			
			if(!dnaStore.contains(geneArrayList.get(i)))
				dnaStore.add(geneArrayList.get(i));
			
			if(geneArrayList.get(i).length() > 60) longerthan60++;
			if(FMG.calCGRatio(geneArrayList.get(i)) > 0.35) CGGreaterthan35++;
			
		}
		
		System.out.println("dnaStore.size: " + dnaStore.size());
		
		System.out.println("\n There are " + geneArrayList.size() + " genes. ");
		System.out.println("There are " + longerthan60 + " genes longer than 60.");
		System.out.println("There are " + CGGreaterthan35 + " genes with CG ratio greater than 0.35.");
	}//end main();
	

}//ee
