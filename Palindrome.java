	/*
	 * Arielle Watson
	 * CISC 3130 TY2
	 * EMPLID: 23690286
	 */
	import java.io.*;
	import java.util.Arrays;
	import java.util.Stack;
	import java.util.Scanner;
	
	public class Palindrome {
		
		public static void main(String[]args) {
			readWords();
		}
		
		/*
		 * Method readWords()
		 * Input
		 * 	none
		 * Process
		 * 	reads words from text file line by line
		 * 	creates a table with the original word, the reversed word, and whether it is a palindrome
		 * Output
		 * 	prints the table with the original word, backward word, and true or false for palindrome
		 */
	public static void readWords() {
		Stack<Character>palStack = new Stack <Character>(); //create empty chracter stack
			
		try {
			File file = new File ("Words.txt");
			Scanner kybd = new Scanner(file);
			
			String word = kybd.nextLine();
			
			System.out.printf("%-18s %-18s %-18s", "Original Word ", "Reversed ", "Is Palindrome? ");
			System.out.println("");
			System.out.println("-------------------------------------------------");
			
			while(kybd.hasNextLine()) { //read strings from file line by line
				System.out.printf("%-17s", word); 
				char [] palArray = word.toCharArray(); //convert to character array
				for(int i = 0; i < palArray.length; i++) { //push characters onto stack
					palStack.push(palArray[i]);
				}
				
			String output = "";
			while(!palStack.isEmpty()) { //while the stack is not empty
				char ch = palStack.pop(); //pop characters from the top
				output = output+ch; //concatenate output and popped character
			}
			
			System.out.printf("%-12s %-12s",output, isPalindrome(word,output));
			System.out.println("");
			
			}
			
			kybd.close();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	} //end of readWords method
	
	/*
	 * Method isPalindrome
	 *Input
	 * 	String word - original string
	 * 	String output - reversed string
	 *Process
	 * 	converts word and output into character arrays
	 * 	counter tracks number of characters that do not match 
	 * 	array goes through each index of originalWordArray
	 * 	orginalWordArray and palindromeArray are compared, character by character	
	 *Output
	 * 	returns true if String word is a palindrome
	 * 	returns false otherwise
	 * 
	 */
	
	public static boolean isPalindrome(String word, String output) {
		char [] originalWordArray = word.toLowerCase().toCharArray(); //converts characters to lowercase char array
		char [] palindromeArray = output.toLowerCase().toCharArray(); //char array for reversed word
		
		int counter = 0;
		for (int i = 0; i < originalWordArray.length; i++) {
			if(originalWordArray[i] != palindromeArray[i]) {
				counter++;
				break;
			}
		if (counter > 0) {
			return false;
		} 
		else {
			return true;
		}
	} //end of isPalindrome method
		return false;
	}
}
	