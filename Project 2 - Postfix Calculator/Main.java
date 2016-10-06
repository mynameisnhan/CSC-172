/* Nhan Le
 * CSC 172
 * Project 2: Postfix Calculator
 */

import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        // Scan file.
        Scanner scanner = new Scanner(new File(args[0]));
        List<String> line = new ArrayList<String>();
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        
        while (scanner.hasNextLine()) 
            line.add(scanner.nextLine());
        
        scanner.close();

        String[] array = line.toArray(new String[0]);
        Queue<String> postfix = new Queue<String>();
        String[] answer = new String[array.length];
        
        // Convert infix string to postfix string.
        for (int i = 0; i < array.length; ++i) 
        { 
            String input = array[i];
            postfix = InfixToPostfix.toPostfix(input);
            
            String temp = "";
            while (postfix.returnSize() > 0) 
                temp += postfix.dequeue() + " ";
            
            answer[i] = PostfixCalc.calculate(temp);
        }
        
        // Write answer string to txt file.
        for (String i : answer) 
        {
            writer.write(i);
            writer.newLine();
        }
        
        writer.close();
    }
    
    public static String toString(String[] array) 
    {
        String string = "";
        for (String element : array)
            string += element + "\n";
        return string;
    }
    
    public static <T> void printArray(T[] genArray) 
    {
        for (T element : genArray) 
            System.out.printf("%s", element);
    }
}
