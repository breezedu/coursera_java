package coursera_java_duke;

import java.util.ArrayList;

import edu.duke.URLResource;

/***************************
 * Write a program that reads the lines from the file at this URL location, 
 * http://www.dukelearntoprogram.com/course2/data/manylinks.html, 
 * and prints each URL on the page that is a link to youtube.com.
 * 
 * @author Jeff
 *
 */
public class Week2_FindWebLinks {
	
	public ArrayList<String> findURLs(String URL){
		
		ArrayList<String> urlArray = new ArrayList<String>();
		
		System.out.println("Get urls from: " + URL + "\n");
		
		URLResource urls = new URLResource(URL);
		
		for(String currUrl : urls.words()){
			
			
			//transfer lower case letters to upper case letters
			String UpCaseURL = toUpCase(currUrl);
			
			if(UpCaseURL.contains("YOUTUBE.COM")){
				
				int pos = UpCaseURL.indexOf("YOUTUBE>COM");
				
				int start = currUrl.lastIndexOf("href=\"", pos);
				int stop = currUrl.indexOf("\">", pos);
				
				//get the substring between start and stop indices;
				String pureURL = currUrl.substring(start + 6, stop);
				
				System.out.println("URL: " + currUrl);
				System.out.println("URL: " + pureURL +"\n");
				
				urlArray.add(pureURL);
			}
			
		}
		
		return urlArray;
		
		
	}//end findURLs() method;
	
	
	
	//transfer lower case letters into upper case letters;
	private String toUpCase(String str) {
		// TODO Auto-generated method stub
		
		int len = str.length();
		String retStr = "";
		for(int i=0; i<len; i++){
			
			char curChar = str.charAt(i);
			
			if(Character.isLowerCase(curChar)){
				curChar = Character.toUpperCase(curChar);
			}
			
			retStr += curChar;
			
		}//end for loop;
		
		return retStr;
		
	}//end toUpCase() method;



	/**********
	 * The main() method; 
	 * @param args
	 */
	public static void main(String[] args){
		
		//create a new FindWebLinks object FWL
		Week2_FindWebLinks FWL = new Week2_FindWebLinks();
		
		//get the webpage; 
		String URL = "http://www.dukelearntoprogram.com/course2/data/manylinks.html" ;
		
		//call FWL.findURLS() method to get all the urls contain "youtube.com", save them to an arrayList;
		ArrayList<String> urlAL = FWL.findURLs(URL);
		
		//printout the size of url-arraylist; 
		System.out.println("There are " + urlAL.size() + " youtube links in the webpage.");
		
	}//end main();

}//ee 
