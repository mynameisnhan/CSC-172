/* Nhan Le
 * nle2@u.rochester.edu
 * Lab 1: Generics (Q1 to Q5) 
 */

public class Lab1Part1 
{	
    public static void main(String[] args) 
    {
        Integer [] intArray = {1, 2, 3, 4, 5};
        Double [] doubArray = {1.1, 2.2, 3.3, 4.4};
        Character [] charArray = {'H','E','L','L','O'};
        String [] strArray = {"once", "upon", "a", "time"};
        
        printArray(intArray);
        printArray(doubArray);
        printArray(charArray);
        printArray(strArray);
       
        System.out.println("max Integer is: " + getMax(intArray));
        System.out.println("max Double is: " + getMax(doubArray));
        System.out.println("max Character is: " + getMax(charArray));
        System.out.println("max String is: " + getMax(strArray));
    }
    
    /**************** SECTION 1 START. ****************
    public static void printArray(Object [] tim) 
    {
        for (int i = 0; i < tim.length; i++)  
            System.out.print(tim[i] + " ");
        
        System.out.println();
    }
    **************** SECTION 1 END. ****************/

    /**************** SECTION 2 START. ****************
    public static void printArray(Integer [] intArray) 
    {
        for (Integer value : intArray)
            System.out.printf("%s ", value);
        
        System.out.println("");
    }
    
    public static void printArray(Double [] doubArray) 
    {
        for (Double value : doubArray) 
            System.out.printf("%s ", value);
        
        System.out.println("");
    }
    
    public static void printArray(Character [] charArray) 
    {
        for (Character value : charArray)
            System.out.printf("%s ", value);
        
        System.out.println("");
    }
    
    public static void printArray(String [] strArray) 
    {
        for (String value : strArray)
            System.out.printf("%s ", value);
        
        System.out.println("");
    }
    **************** SECTION 2 END. ****************/
    
    /**************** SECTION 3 START. ****************/   
    public static <Tim> void printArray(Tim[] genArray) 
    {
        for (Tim chu : genArray)
            System.out.printf("%s ", chu);
        
        System.out.println("");
    }
    /**************** SECTION 3 END. ****************/
    
    /**************** SECTION 4 START. ****************
    public static Comparable getMax(Comparable [] num) 
    {
        Comparable max;
        max = num[0];
        
        for (Comparable i : num) 
            if (i.compareTo(max) > 0)
                max = i;
    
        return max;
    }
    **************** SECTION 4 END. ****************/
    
    /**************** SECTION 5 START. ****************/
    public static <Tim extends Comparable<? super Tim>> Tim getMax(Tim [] num) 
    {
        Tim chu = num[0];

        for (Tim i : num) 
            if (i.compareTo(chu) > 0)
                chu = i;
        
        return chu;
    }
    /**************** Section 5 end. ****************/
}
