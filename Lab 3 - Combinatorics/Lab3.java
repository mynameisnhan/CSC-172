/* Nhan Le
 * CSC 172
 * Lab 3: Combinatorics 
 */

import java.math.BigInteger;

public class Lab3 
{	
	public static void main(String[] args) 
	{
		// Question 1a.
		System.out.println("The number of anagrams for \"error\" is: " + perm(5).divide(perm(3)));

		// Question 1b.
		System.out.println("The number of anagrams for \"street\" is: " + perm(6).divide(perm(2).multiply(perm(2))));


		// Question 1c.
		System.out.println("The number of anagrams for \"allele\" is: " + perm(6).divide(perm(3).multiply(perm(2))));

		// Question 1d.
		System.out.println("The number of anagrams for \"Mississippi\" is: " + perm(11).divide(perm(4).multiply(perm(4).multiply(perm(2)))));
		
		// Question 2a.
		System.out.println("The number of ways to distribute 6 apples to 4 children is: " + perm(9).divide(perm(6).multiply(perm(3))));
		
		// Question 2b.
		System.out.println("The number of ways to distribute 4 apples to 6 children is: " + perm(9).divide(perm(5).multiply(perm(4))));
		
		// Question 3a.
		System.out.println("The number of ways to distribute 6 apples and 3 pears to 5 children is: " + perm(13).divide(perm(4).multiply(perm(6).multiply(perm(3)))));
		
		// Question 3b.
		System.out.println("The number of ways to distribute 2 apples, 5 pears, and 6 bananas to 3 children is: " + perm(15).divide(perm(2).multiply(perm(2).multiply(perm(5)).multiply(perm(6)))));	
	}
	
	// Recursive method for permutations.
	public static BigInteger perm(int n) 
	{
		if ((BigInteger.valueOf(n) == BigInteger.ONE) || (BigInteger.valueOf(n) == BigInteger.ZERO)) 
			return BigInteger.ONE;
		
		else 
			return BigInteger.valueOf(n).multiply(perm(n-1));
	}
}

