package coursera_java_duke;

public class Class_01_hw {

	/***
	 * What this tiny object hw do
	 * to printout "Hello Java Class!"
	 */
	public void sayHello(){
		System.out.println("Hello Java Class!");
	} //end of sayHello object
	
	
	/****
	 * the main() function
	 * @param args
	 */
	public static void main(String[] args){
		//create a new object Class_01_hw, name hw1
		Class_01_hw hw1 = new Class_01_hw();
		
		//call one method in hw1, sayHello to printout "Hello Java Class!".
		hw1.sayHello();
	}//end of main()
	
}//ee
