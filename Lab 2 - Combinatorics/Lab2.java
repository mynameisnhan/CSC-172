/* Nhan Le
 * nle2@u.rochester.edu
 * Lab 2: Combinatorics 
 */

import java.math.BigInteger;

public class Lab2 
{
	public static void main(String[] args) 
	{
		// Question 1i.
		System.out.println("The number of ways to paint 3 hours in any of 4 colors is: " + ca(3, 4));

		// Question 1ii.
		System.out.println("The number of ways to form passwords with 8 to 10 letters/digits is: " + ca(8, 62).add(ca(9, 62).add(ca(10, 62))));
	
		// Question 2.
		System.out.println("The number of orderings for 9 players is: " + perm(9));

		// Question 3i.
		System.out.println("The number of ways to elect 4 officers from 200 students is: " + perm(200).divide(perm(196)));

		// Question 3iia.
		System.out.println("The number of ways to sequence 3 unique letters is: " + perm(26).divide(perm(23)));

		// Question 3iib.
		System.out.println("The number of ways to sequence 5 unique letters is: " + perm(26).divide(perm(21)));
		
		// Question 4.
		System.out.println("The number of ways to deal 5 cards from 52 cards is: " + us(52, 5));
	}
	
	// Method for counting assignments.
	public static BigInteger ca(int k, int n) 
	{
		// Convert int to BigInteger.
		BigInteger base = new BigInteger(String.valueOf(k)); 
		int exp = n;
		BigInteger answer = base.pow(exp);
		return answer;
	}	
	
	// Method for permutations.
	public static BigInteger perm(int n) 
	{
		BigInteger answer = BigInteger.ONE;
		
		// n! = n(n-1)(n-2)(n-3)...
		for (int counter = n; counter > 0; --counter) 
			answer = answer.multiply(BigInteger.valueOf(counter));
		
		return answer;
	}
	
	// Recursive method for unordered selections.
	public static BigInteger us(int n, int m) 
	{
		if ((BigInteger.valueOf(m) == BigInteger.ZERO) ||
				(BigInteger.valueOf(n) == (BigInteger.valueOf(m)))) 
			return BigInteger.ONE;
		
		else 
			 return us(n-1, m-1).add(us(n-1, m));
	} 
}

