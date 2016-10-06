/* Nhan Le
 * CSC 172
 * Project 1: Hamming
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Hamming 
{
	/** Method to encode Hamming(7, 4). **/
	public static void encode_7_4 (String inFileName, String outFileName) throws IOException 
	{
		int [][] genMatrix = {{1, 1, 1, 0, 0, 0, 0}, 
				      {1, 0, 0, 1, 1, 0, 0}, 
				      {0, 1, 0, 1, 0, 1, 0}, 
				      {1, 1, 0, 1, 0, 0, 1}};
        
		// Initialize writer.
        	BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));     
        
		// Scan input file. (From Pawlicki's email.)
		Path path = Paths.get(inFileName);
		byte[] input = Files.readAllBytes(path);
		
		// Convert 1 byte to 8 bits.
		int intInput[][] = new int[input.length][8];
		
		for (int i = 0; i < input.length; i++) 
		{
			String temp = String.format("%8s", Integer.toBinaryString((byte) input[i])).replace(' ', '0'); // Convert byte to binary ASCII String.
			
			String[] tempArr = temp.split(""); // Add each element in ASCII String into temp array.
			
			for (int j = 0; j < tempArr.length; j++) // Parse integer in temp array and assign to bit subarray of element array.
				intInput[i][j] = (int) Integer.parseInt(tempArr[j]);		
	   	}
		
		String output = "";
		
		// For each bit ...
		for (int i = 0; i < intInput.length; i++) 
		{
			// Split 8 bits into 2 4 bits to be compatible with generator matrix.
			int[] alteredInput1 = new int[4];
			int[] alteredInput2 = new int[4];	
		
			for (int j = 0; j < 4; j++) 
				alteredInput1[j] = intInput[i][j];
			
			for (int j = 4; j < 8; j++) 
				alteredInput2[j-4] = intInput[i][j];
		
			// Perform matrix multiplication.
			int[] result1 = matrixMultiplication(alteredInput1, genMatrix);
			int[] result2 = matrixMultiplication(alteredInput2, genMatrix);		
			
			// Convert result arrays to output String.
			String asciiStringForOneByte = "0"; // Add leading 0.
			
			for (int j = 0; j < result1.length; j++) 
				asciiStringForOneByte += result1[j];
			
			asciiStringForOneByte += "0"; // Add leading 0.
			
			for (int j = 0; j < result2.length; j++)
				asciiStringForOneByte += result2[j];
			
		    for (int j = 0; j < asciiStringForOneByte.length()/8; j++) 
		    {
		        int temp = Integer.parseInt(asciiStringForOneByte.substring(8*j,(j+1)*8),2);
		        output += (char) (temp);
		    }
		}
		
		// Write output file.
        	writer.write(output);
        	writer.close();
	}
	
	/** Method to encode Hamming(15, 11). **/
	public static void encode_15_11 (String inFileName, String outFileName) throws IOException 
	{
		int[][] genMatrix = {{1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
		 		     {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				     {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				     {1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, 
				     {1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0}, 
				     {0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0}, 
				     {1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0}, 
				     {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, 
				     {1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0}, 
				     {0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0}, 
				     {1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1}};

		// Initialize writer.
        	BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));     
        
		// Scan input file. (From Pawlicki's email.)
		Path path = Paths.get(inFileName);
		byte[] input = Files.readAllBytes(path);
		
		// Convert 1 byte to 11 bits.
		int intInput[][] = new int[input.length][11];
		
		for (int i = 0; i < input.length; i++) 
		{
			String temp = String.format("%8s", Integer.toBinaryString((byte) input[i])).replace(' ', '0'); // Convert byte to binary ASCII String.
			
			String[] tempArr = temp.split(""); // Add each element in ASCII String into temp array.
			
			intInput[i][0] = intInput[i][1] = intInput[i][2] = 0; // Add 3 leading 0s.
			
			for (int j = 0; j < tempArr.length; j++) // Parse integer in temp array and assign to bit subarray of element array.
				intInput[i][j+3] = (int) Integer.parseInt(tempArr[j]);		
	   	}
		
		String output = "";
		
		// For each bit ...
		for (int i = 0; i < intInput.length; i++) 
		{
			// Perform matrix multiplication.
			int[] result = matrixMultiplication(intInput[i], genMatrix);	
			
			// Convert result array to output String.
			String asciiStringForOneByte = "0"; // Add leading 0. 
			
			for (int j = 0; j < result.length; j++) 
				asciiStringForOneByte += result[j];
			
		    for (int j = 0; j < asciiStringForOneByte.length()/8; j++) 
		    {
		        int temp = Integer.parseInt(asciiStringForOneByte.substring(8*j,(j+1)*8),2);
		        output += (char) temp;		    
		    }
		}

		// Write output file.
        	writer.write(output);
        	writer.close();
	}
	
	/** Method to decode Hamming(7, 4). **/
	public static void decode_7_4 (String inFileName, String outFileName) throws IOException
	{
		int[][] checkMatrix = {{0, 0, 0, 0},
				       {1, 1, 0, 0},
				       {1, 0, 1, 0},
				       {0, 1, 1, 0},
				       {1, 0, 0, 1},
				       {0, 1, 0, 1},
				       {0, 0, 1, 1},
				       {1, 1, 1, 1}};
		
		// Initialize writer.
        	BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));     
        
		// Scan input file. (From Pawlicki's email.)
		Path path = Paths.get(inFileName);
		byte[] input = Files.readAllBytes(path);

		// Convert 1 byte to 8 bits.
		int intInput[][] = new int[input.length][8];
		
		for (int i = 0; i < input.length; i++) 
		{
			String temp = String.format("%8s", Integer.toBinaryString((int) input[i])).replace(' ', '0'); // Convert byte to binary ASCII String.
			
			String[] tempArr = temp.split(""); // Add each element in ASCII String into temp array.
			
			for (int j = 0; j < tempArr.length; j++) // Parse integer in temp array and assign to bit subarray of element array. 
				intInput[i][j] = (int) Integer.parseInt(tempArr[j]); 		
	   	}
		
		String finalOutput = "";
		String output = "";
				
		// For each bit ...
		for (int i = 0; i < intInput.length; i++) 
		{
			// Perform matrix multiplication.
			int[] result = matrixMultiplication(intInput[i], checkMatrix);
			
			String errorString = "";
			
			// Convert error array to String.
			for (int j = 0; j < result.length; j++) 
				errorString += result[j];
			
			// For each errorString case ...
		    	switch(errorString) 
		    	{
		    		case "0000": // Nothing is wrong. Add to output String
		    			int[] tempArrNone = new int[4];  
	    			
			    		tempArrNone[0] = intInput[i][3];
			    		tempArrNone[1] = intInput[i][5];
			    		tempArrNone[2] = intInput[i][6];
		    			tempArrNone[3] = intInput[i][7];
		    		
		    			for (int j = 0; j < tempArrNone.length; j++)
		    				output += tempArrNone[j];
		    		
		    			break;
			    	
			    	case "1000": // Error at overall parity bit. Impossible.
			    		throw new IllegalArgumentException("Incorrect overall parity bit.");
			    	
			    	case "1100": // Error at p1. Switch all data bits associated with p1 and add to output String. 
		    			int[] tempArrP1 = new int[4];  
	    			
		    			tempArrP1[0] = bitSwitch(intInput[i][3]);
			    		tempArrP1[1] = bitSwitch(intInput[i][5]);
			    		tempArrP1[2] = intInput[i][6];
			    		tempArrP1[3] = bitSwitch(intInput[i][7]);
		    			
			    		for (int j = 0; j < tempArrP1.length; j++)
			    			output += tempArrP1[j];		
		    		
			    		break;
		    	
		    		case "1010": // Error at p2. Switch all data bits associated with p2 and add to output String.
			    		int[] tempArrP2 = new int[4];  
		    			
			    		tempArrP2[0] = bitSwitch(intInput[i][3]);
			    		tempArrP2[1] = intInput[i][5];
			    		tempArrP2[2] = bitSwitch(intInput[i][6]);
		    			tempArrP2[3] = bitSwitch(intInput[i][7]);
		    		
		    			for (int j = 0; j < tempArrP2.length; j++)
		    				output += tempArrP2[j];		    		

		    			break; 
		    	
			    	case "1001": // Error at p4. Switch all data bits associated with p4 and add to output String.
			    		int[] tempArrP4 = new int[4];  
	    			
			    		tempArrP4[0] = intInput[i][3];
		    			tempArrP4[1] = bitSwitch(intInput[i][5]);
		    			tempArrP4[2] = bitSwitch(intInput[i][6]);
			    		tempArrP4[3] = bitSwitch(intInput[i][7]);
		    		
			    		for (int j = 0; j < tempArrP4.length; j++)
			    			output += tempArrP4[j];
		    	
		    			break;
		    	
			    	case "1110": // Error at d1. Switch data bit at d1 and add to output String.
			    		int[] tempArrD1 = new int[4];  
	    			
			    		tempArrD1[0] = bitSwitch(intInput[i][3]);
		    			tempArrD1[1] = intInput[i][5];
			    		tempArrD1[2] = intInput[i][6];
			    		tempArrD1[3] = intInput[i][7];
		    		
			    		for (int j = 0; j < tempArrD1.length; j++)
		    				output += tempArrD1[j];
		    	
		    			break;
		    	
			    	case "1011": // Error at d3. Switch data bit at d3 and add to output String.
			    		int[] tempArrD3 = new int[4];  
	    			
			    		tempArrD3[0] = intInput[i][3];
		    			tempArrD3[1] = intInput[i][5];
		    			tempArrD3[2] = bitSwitch(intInput[i][6]);
			    		tempArrD3[3] = intInput[i][7];
		    		
			    		for (int j = 0; j < tempArrD3.length; j++)
			    			output += tempArrD3[j];
		    	
		    			break;
		    		
		    		case "1101": // Error at d2. Switch data bit at d2 and add to output String.
			    		int[] tempArrD2 = new int[4];  
	    			
			    		tempArrD2[0] = intInput[i][3];
			    		tempArrD2[1] = bitSwitch(intInput[i][5]);
		    			tempArrD2[2] = intInput[i][6];
		    			tempArrD2[3] = intInput[i][7];
		    		
		    			for (int j = 0; j < tempArrD2.length; j++)
			    			output += tempArrD2[j];
			    	
			    		break;
		    		
			    	case "1111": // Error at d4. Switch data bit at d4 and add to output String.
			    		int[] tempArrD4 = new int[4];  
	    				
					tempArrD4[0] = intInput[i][3];
			    		tempArrD4[1] = intInput[i][5];
					tempArrD4[2] = intInput[i][6];
					tempArrD4[3] = bitSwitch(intInput[i][7]);
		    		
		    			for (int j = 0; j < tempArrD4.length; j++)
		    				output += tempArrD4[j];
		    	
		    			break;
		    	
		    		default: // Double bit error.
		    			throw new IllegalArgumentException("Double bit error be bitchin'.");
		    	}
		}    
		    
		for (int j = 0; j < output.length()/8; j++) 
		{
		    int temp = Integer.parseInt(output.substring(8*j,(j+1)*8), 2);
		    finalOutput += (char) (temp);
		}
		
		// Write output file.
        	writer.write(finalOutput);
        	writer.close();
	}
	
	/** Method to decode Hamming(15, 11). **/
	public static void decode_15_11 (String inFileName, String outFileName) throws IOException
	{
		int[][] checkMatrix = {{0, 0, 0, 0, 0},
	             		       {1, 1, 0, 0, 0},
				       {1, 0, 1, 0, 0},
			               {0, 1, 1, 0, 0},
				       {1, 0, 0, 1, 0},
				       {0, 1, 0, 1, 0},
				       {0, 0, 1, 1, 0},
				       {1, 1, 1, 1, 0},
				       {1, 0, 0, 0, 1},
				       {0, 1, 0, 0, 1},
				       {0, 0, 1, 0, 1},
		                       {1, 1, 1, 0, 1},
		                       {0, 0, 0, 1, 1},
		                       {1, 1, 0, 1, 1},
		                       {1, 0, 1, 1, 1},
		                       {0, 1, 1, 1, 1}};

		// Initialize writer.
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));     

		// Scan input file. (From Pawlicki's email.)
		Path path = Paths.get(inFileName);
		byte[] input = Files.readAllBytes(path);

		// Convert 2 bytes to 16 bits.
		int intInput[][] = new int[input.length/2][16];
		
		for (int i = 0; i < input.length; i = i + 2) 
		{
			String temp1 = "";
			String temp2 = "";
			
			// Convert byte to binary ASCII String. Because encoded Hamming(15, 11) contains unsigned characters with over 8 data bits, we will accept only all 8 last digits.
			if ((Integer.toBinaryString((int) input[i])).length() == 8)
				temp1 = String.format("%8s", Integer.toBinaryString((int) input[i])).replace(' ', '0');
			
			else if ((Integer.toBinaryString((int) input[i])).length() > 8) 
				temp1 = String.format("%8s", (Integer.toBinaryString((int) input[i])).substring((Integer.toBinaryString((int) input[i])).length() - 8)).replace(' ', '0');
			
			else 
				temp1 = String.format("%8s", Integer.toBinaryString((int) input[i])).replace(' ', '0');	
			
			if ((Integer.toBinaryString((int) input[i + 1])).length() == 8)
				temp2 = String.format("%8s", Integer.toBinaryString((int) input[i + 1])).replace(' ', '0');
			
			else if ((Integer.toBinaryString((int) input[i + 1])).length() > 8) 
				temp2 = String.format("%8s", (Integer.toBinaryString((int) input[i + 1])).substring((Integer.toBinaryString((int) input[i + 1] )).length() - 8)).replace(' ', '0');
			
			else 
				temp2 = String.format("%8s", Integer.toBinaryString((int) input[i + 1])).replace(' ', '0');
			
			String temp = temp1 + temp2;
			
			String[] tempArr = temp.split(""); // Add each element in ASCII String into array.
			
			for (int j = 0; j < tempArr.length; j++) // Parse integer in temp array and assign to bit subarray of element array. 
				intInput[i/2][j] = (int) Integer.parseInt(tempArr[j]); 		
	   	}

		String finalOutput = "";
		String output = "";
	
		// For each bit ...
		for (int i = 0; i < intInput.length; i++) 
		{
			// Perform matrix multiplication.
			int[] result = matrixMultiplication(intInput[i], checkMatrix);

			String errorString = "";

			// Convert error array to String.
			for (int j = 0; j < result.length; j++) 
				errorString += result[j];
			
			// For each errorString case:
			switch(errorString) 
			{
				case "00000": // Nothing is wrong. Add to output String.
					int[] tempArrNone = new int[8];  
		
					tempArrNone[0] = intInput[i][7];
					tempArrNone[1] = intInput[i][9];
					tempArrNone[2] = intInput[i][10];
					tempArrNone[3] = intInput[i][11];
					tempArrNone[4] = intInput[i][12];
					tempArrNone[5] = intInput[i][13];
					tempArrNone[6] = intInput[i][14];
					tempArrNone[7] = intInput[i][15];
					
					for (int j = 0; j < tempArrNone.length; j++)
						output += tempArrNone[j];
						
					break;
							
				case "10000": // Incorrect overall parity bit. Impossible.
		    		throw new IllegalArgumentException("Incorrect overall parity bit.");
			    	
		 		case "11000": // Error at p1. Switch all data bits associated with p1 and add to output String. 
					int[] tempArrP1 = new int[8];  
					
					tempArrP1[0] = bitSwitch(intInput[i][7]);
					tempArrP1[1] = bitSwitch(intInput[i][9]);
					tempArrP1[2] = intInput[i][10];
					tempArrP1[3] = bitSwitch(intInput[i][11]);
					tempArrP1[4] = intInput[i][12];
					tempArrP1[5] = bitSwitch(intInput[i][13]);
					tempArrP1[6] = intInput[i][14];
					tempArrP1[7] = bitSwitch(intInput[i][15]);
					
					for (int j = 0; j < tempArrP1.length; j++)
						output += tempArrP1[j];
					
					break;
					
				case "10100": // Error at p2. Switch all data bits associated with p2 and add to output String.
					int[] tempArrP2 = new int[8];  
				
					tempArrP2[0] = bitSwitch(intInput[i][7]);
					tempArrP2[1] = intInput[i][9];
					tempArrP2[2] = bitSwitch(intInput[i][10]);
					tempArrP2[3] = bitSwitch(intInput[i][11]);
					tempArrP2[4] = intInput[i][12];
					tempArrP2[5] = intInput[i][13];
					tempArrP2[6] = bitSwitch(intInput[i][14]);
					tempArrP2[7] = bitSwitch(intInput[i][15]);
					
					for (int j = 0; j < tempArrP2.length; j++)
						output += tempArrP2[j];
					
					break;
				
				case "10010": // Error at p4. Switch all data bits associated with p4 and add to output String.
					int[] tempArrP4 = new int[8];  
					
					tempArrP4[0] = bitSwitch(intInput[i][7]);
					tempArrP4[1] = intInput[i][9];
					tempArrP4[2] = intInput[i][10];
					tempArrP4[3] = intInput[i][11];
					tempArrP4[4] = bitSwitch(intInput[i][12]);
					tempArrP4[5] = bitSwitch(intInput[i][13]);
					tempArrP4[6] = bitSwitch(intInput[i][14]);
					tempArrP4[7] = bitSwitch(intInput[i][15]);
					
					for (int j = 0; j < tempArrP4.length; j++)
						output += tempArrP4[j];
					
					break;

				case "10001": // Error at p8. Switch all data bits associated with p8 and add to output String.
					int[] tempArrP8 = new int[8];  
				
					tempArrP8[0] = intInput[i][7];
					tempArrP8[1] = bitSwitch(intInput[i][9]);
					tempArrP8[2] = bitSwitch(intInput[i][10]);
					tempArrP8[3] = bitSwitch(intInput[i][11]);
					tempArrP8[4] = bitSwitch(intInput[i][12]);
					tempArrP8[5] = bitSwitch(intInput[i][13]);
					tempArrP8[6] = bitSwitch(intInput[i][14]);
					tempArrP8[7] = bitSwitch(intInput[i][15]);
					
					for (int j = 0; j < tempArrP8.length; j++)
						output += tempArrP8[j];
					
					break;
					
				case "11110": // Error at d4. Switch data bit at d4 and add to output String.
					int[] tempArrD4 = new int[8];  
		
					tempArrD4[0] = bitSwitch(intInput[i][7]);
					tempArrD4[1] = intInput[i][9];
					tempArrD4[2] = intInput[i][10];
					tempArrD4[3] = intInput[i][11];
					tempArrD4[4] = intInput[i][12];
					tempArrD4[5] = intInput[i][13];
					tempArrD4[6] = intInput[i][14];
					tempArrD4[7] = intInput[i][15];
		
					for (int j = 0; j < tempArrD4.length; j++)
						output += tempArrD4[j];
		
					break;
				
				case "11001": // Error at d5. Switch data bit at d5 and add to output String.
					int[] tempArrD5 = new int[8];  
						
					tempArrD5[0] = intInput[i][7];
					tempArrD5[1] = bitSwitch(intInput[i][9]);
					tempArrD5[2] = intInput[i][10];
					tempArrD5[3] = intInput[i][11];
					tempArrD5[4] = intInput[i][12];
					tempArrD5[5] = intInput[i][13];
					tempArrD5[6] = intInput[i][14];
					tempArrD5[7] = intInput[i][15];
		
					for (int j = 0; j < tempArrD5.length; j++)
						output += tempArrD5[j];
		
					break;
					
				case "10101": // Error at d6. Switch data bit at d6 and add to output String.
					int[] tempArrD6 = new int[8];  
		
					tempArrD6[0] = intInput[i][7];
					tempArrD6[1] = intInput[i][9];
					tempArrD6[2] = bitSwitch(intInput[i][10]);
					tempArrD6[3] = intInput[i][11];
					tempArrD6[4] = intInput[i][12];
					tempArrD6[5] = intInput[i][13];
					tempArrD6[6] = intInput[i][14];
					tempArrD6[7] = intInput[i][15];
		
					for (int j = 0; j < tempArrD6.length; j++)
						output += tempArrD6[j];
					
					break;

				case "11101": // Error at d7. Switch data bit at d7 and add to output String.
					int[] tempArrD7 = new int[8];  
		
					tempArrD7[0] = intInput[i][7];
					tempArrD7[1] = intInput[i][9];
					tempArrD7[2] = intInput[i][10];
					tempArrD7[3] = bitSwitch(intInput[i][11]);
					tempArrD7[4] = intInput[i][12];
					tempArrD7[5] = intInput[i][13];
					tempArrD7[6] = intInput[i][14];
					tempArrD7[7] = intInput[i][15];
		
					for (int j = 0; j < tempArrD7.length; j++)
						output += tempArrD7[j];
		
					break;					
					
				case "10011": // Error at d8. Switch data bit at d8 and add to output String.
					int[] tempArrD8 = new int[8];  
		
					tempArrD8[0] = intInput[i][7];
					tempArrD8[1] = intInput[i][9];
					tempArrD8[2] = intInput[i][10];
					tempArrD8[3] = intInput[i][11];
					tempArrD8[4] = bitSwitch(intInput[i][12]);
					tempArrD8[5] = intInput[i][13];
					tempArrD8[6] = intInput[i][14];
					tempArrD8[7] = intInput[i][15];
		
					for (int j = 0; j < tempArrD8.length; j++)
						output += tempArrD8[j];
		
					break;					
				
				case "11011": // Error at d9. Switch data bit at d9 and add to output String.
					int[] tempArrD9 = new int[8];  
		
					tempArrD9[0] = intInput[i][7];
					tempArrD9[1] = intInput[i][9];
					tempArrD9[2] = intInput[i][10];
					tempArrD9[3] = intInput[i][11];
					tempArrD9[4] = intInput[i][12];
					tempArrD9[5] = bitSwitch(intInput[i][13]);
					tempArrD9[6] = intInput[i][14];
					tempArrD9[7] = intInput[i][15];
		
					for (int j = 0; j < tempArrD9.length; j++)
						output += tempArrD9[j];
		
					break;					
					
				case "10111": // Error at d10. Switch data bit at d10 and add to output String.
					int[] tempArrD10 = new int[8];  
		
					tempArrD10[0] = intInput[i][7];
					tempArrD10[1] = intInput[i][9];
					tempArrD10[2] = intInput[i][10];
					tempArrD10[3] = intInput[i][11];
					tempArrD10[4] = intInput[i][12];
					tempArrD10[5] = intInput[i][13];
					tempArrD10[6] = bitSwitch(intInput[i][14]);
					tempArrD10[7] = intInput[i][15];
		
					for (int j = 0; j < tempArrD10.length; j++)
						output += tempArrD10[j];
		
					break;					
				
				case "11111": // Error at d11. Switch data bit at d11 and add to output String.
					int[] tempArrD11 = new int[8];  
		
					tempArrD11[0] = intInput[i][7];
					tempArrD11[1] = intInput[i][9];
					tempArrD11[2] = intInput[i][10];
					tempArrD11[3] = intInput[i][11];
					tempArrD11[4] = intInput[i][12];
					tempArrD11[5] = intInput[i][13];
					tempArrD11[6] = intInput[i][14];
					tempArrD11[7] = bitSwitch(intInput[i][15]);
		
					for (int j = 0; j < tempArrD11.length; j++)
						output += tempArrD11[j];
		
					break;		

				default: // Double bit error.
					throw new IllegalArgumentException("Double bit error be bitchin'.");
			}
		}    

		for (int j = 0; j < output.length()/8; j++) 
		{
			int temp = Integer.parseInt(output.substring(8*j,(j+1)*8), 2);
			finalOutput += (char) (temp);
		}

		// Write output file.
		writer.write(finalOutput);
		writer.close(); 
	}
	
	/** Method for matrix multiplication for 1 x n and n x p. **/
	private static int[] matrixMultiplication(int alteredInput[], int genMatrix[][])
	{
		int inputColumns = alteredInput.length; // n
		int genMatrixRows = genMatrix.length; // n
		int genMatrixColumns = genMatrix[0].length; // p
		
		// Throw error for illegal matrix multiplication.
		if (inputColumns != genMatrixRows)
			throw new IllegalArgumentException("Illegal matrix multiplication.");
		
		// Initialize int array answer.
		int[] answer = new int[genMatrixColumns];
		
        	// Perform matrix multiplication.
		for(int p = 0; p < genMatrixColumns; p++) 
		{
			for(int n = 0; n < inputColumns; n++)  
				answer[p] = bitAdd(answer[p], bitMult(alteredInput[n], genMatrix[n][p])); 
		}
		
		return answer;
	}
	
	/** Method for mod 2 multiplication. **/
	private static int bitMult(int n1, int n2) 
	{
		if (n1 == 0)
		{
			if (n2 == 0)
				return 0;
			else 
				return 0; 
		}
		
		else if (n1 == 1)
		{
			if (n2 == 0)
				return 0;
			else
				return 1;
		}
		
		else // Redundant but used for paranoia.
			throw new IllegalArgumentException("Input must be 0 or 1.");
	}
	
	/** Method for mod 2 addition. **/
	private static int bitAdd(int n1, int n2) 
    	{
		if (n1 == 0)
		{
			if (n2 == 0)
				return 0;
			else 
				return 1; 
		}
		
		else if (n1 == 1)
		{
			if (n2 == 0)
				return 1;
			else
				return 0;
		}
		
		else // Redundant but used for paranoia.
			throw new IllegalArgumentException("Input must be 0 or 1.");        
    	}
	
	/** Method to switch 0 and 1. **/
	private static int bitSwitch(int n) 
	{
		if (n == 1)
			return 0;
	
		else if (n == 0)
			return 1;
		
		else // Redundant but used for paranoia.
			throw new IllegalArgumentException("Input must be 0 or 1.");        
	}
}
