package coursera_java_duke;

import java.util.ArrayList;

import edu.duke.URLResource;



public class Week2_FindAllURLs {
	
	//find all URLs, and store these URLs as strings into an ArrayList
	public ArrayList<String> findURLs(String page){
		
		URLResource currSource = new URLResource(page);
		ArrayList<String> urlAL = new ArrayList<String>();
		
		
		for(String str : currSource.words()){
			
			if(str.contains("href=")){
				
			//	System.out.println("One URL: " + str);
				
				//the format of URL in html document is: <href="http://www.duke.edu"> 
				//but, sometimes, the end may not have that > symbol
				//the start position is 6;
				int start = str.indexOf("href=") + 6;
				
				//the stop position is the position of "\"" or ( " )
				int stop = str.indexOf("\"", start);
				
				if(stop == -1) {
					
					stop = str.length();
				}
				
			//	System.out.println("start: " + start + " stop: " + stop);
				String currURL = str.substring(start, stop);
				
				//to avoid internal links, only add urls start with http to the arrayList
				if(currURL.startsWith("http"))
					urlAL.add(str.substring(start, stop));
				
				System.out.println("Real URL: " + str.substring(start, stop) );
			}//end if
			

		}//end for loop;
		
		System.out.println("There are: " + urlAL.size() + " URLs on the page.");
		
		return urlAL;
				
	}//end findURLs() method
	
	
	
	//main()
	public static void main(String[] args){
		
		Week2_FindAllURLs findAllURLs = new Week2_FindAllURLs();
		
		//find all URLs and store them in an ArrayList urlList
	//	String page = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
		String page = "http://dukelearntoprogram.com/course2/data/newyorktimes.html";
		ArrayList<String> urlList = findAllURLs.findURLs(page);
		System.out.println();
		
		//find secure links, start with https
		int secuURLs = findSecuURLs(urlList);
		System.out.println("There are: " + secuURLs + " security URLs.");
		
		
		//find number of links have .com
		int comNum = findComNum(urlList);
		System.out.println("There are: " + comNum + " .com URLs.");
		
		
		//find links end with .com or .com/
		int comEnd = findComEnd(urlList);
		System.out.println("There are: " + comEnd + " URLs end with .com or .com/");
		
		
		//count the number of "."'s in all links
		int dotNum = countDots(urlList);
		System.out.println("There are: " + dotNum + " in total.");
		
	}// end main();



	private static int countDots(ArrayList<String> urlList) {
		// TODO Auto-generated method stub
		
		int dotCount = 0;
		
		for(String url : urlList){
			
			for(int i=0; i<url.length(); i++){
				
				if(url.charAt(i) == '.') 
					dotCount++;
				
			}//end inner for loop;
			
		}//end outter for loop;
		
		return dotCount;
		
	}//end countDots() method



	private static int findComEnd(ArrayList<String> urlList) {
		// TODO Auto-generated method stub
		int count = 0;
		
		for(String url : urlList){
			int len = url.length();
			if( url.substring(len-3).equals("com") || url.substring(len-5).equals(".com/"))
				count++;
		}
		return count;
	}//end findComEnd() method;



	private static int findComNum(ArrayList<String> urlList) {
		// TODO Auto-generated method stub
		int count = 0;
		
		for(String url : urlList){
			
			if(url.contains(".com"))
				count++;
		}
		
		return count;
	}//end findComNum() method;



	private static int findSecuURLs(ArrayList<String> aList) {
		// TODO Auto-generated method stub
		
		int count = 0;
		for(String url : aList){
			if(url.startsWith("https"))
				count++;
		}
		
		return count;
	}//end findSecuURLs() method;

}//ee
