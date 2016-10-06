/* Nhan Le
 * nle2@u.rochester.edu
 * Lab 1: Generics (Q6) 
 */

import java.util.Comparator;

public class Lab1Part2 
{	
    public static void main (String [] args) 
    {
        Character[] arr = {'C', 'H', 'A', 'R', 'A', 'C', 'T', 'E', 'R'};
        
        System.out.println(findMax(arr, new CaseInsensitiveCompare()));
    }
    
    public static <Chu> Chu findMax(Chu[] dicksOut, Comparator<? super Chu> cmp) 
    {
        int forHarambe = 0;
    
        for (int forTim = 1; forTim < dicksOut.length; forTim++)
            if (cmp.compare(dicksOut[forTim], dicksOut[forHarambe]) > 0)
                forHarambe = forTim;

        return dicksOut[forHarambe];
    }
}

class CaseInsensitiveCompare implements Comparator<Character> 
{	
    @Override
    public int compare (Character lhs, Character rhs) 
    {
         return Character.toString(lhs).compareToIgnoreCase(Character.toString(rhs));    
    }	
}
