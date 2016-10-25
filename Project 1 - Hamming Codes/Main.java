/* Nhan Le
 * CSC 172
 * Project 1: Hamming 
 */

import java.io.IOException;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner scanner = new Scanner(System.in);
		
		// Ask for user input for input filepath.
		System.out.println("Enter file path for input file.");
		String input = scanner.nextLine();
		
		// Ask for user input for output filepath.
		System.out.println("\nEnter file path for output file.");
		String output = scanner.nextLine();
		
		// Ask for user input for method call. 
		System.out.println("\nEnter value between 0 and 3.\n 0 to encode_7_4. \n 1 to encode_15_11. \n 2 to decode_7_4. \n 3 to decode_15_11.");
		int value = scanner.nextInt();
		
		System.out.println();

		scanner.close();
		
		switch (value) 
		{
        		case 0:  Hamming.encode_7_4(input, output); // Done!
        			break;
        			
        		case 1:  Hamming.encode_15_11(input, output); // Done!
        			break;
        		
        		case 2:  Hamming.decode_7_4(input, output);
        			break;
        		
        		case 3: Hamming.decode_15_11(input, output);
        			break;
        		
        		default: {throw new IllegalArgumentException("Invalid input, dumbass.");}
		}
		
	}
}
