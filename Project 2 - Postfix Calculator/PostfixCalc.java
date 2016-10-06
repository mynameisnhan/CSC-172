/* Nhan Le
 * CSC 172
 * Project 2: Postfix Calculator
 */

import java.util.StringTokenizer;

public class PostfixCalc 
{
    public static String calculate(String input) 
    {
        Stack<String> stack = new Stack<String>();
        
        // Tokenize postfix.
    	Queue<String> postfix = new Queue<String>();
        StringTokenizer token = new StringTokenizer(input, " ");
        
        while (token.hasMoreTokens())
            postfix.enqueue(token.nextToken());
        
        // Calculate.
        while (postfix.returnSize() > 0) 
        {
            if (isDouble(postfix.peek())) // If first in queue is number...
                stack.push(postfix.dequeue()); // Push to stack.
            
            if (!isDouble(postfix.peek())) // If first in queue is operator... 
            { 
                if (postfix.peek().equals("+"))  
                {
                    double valueOne = Double.parseDouble(stack.pop());
                    double valueTwo = Double.parseDouble(stack.pop());
                    double valueAnswer = valueOne + valueTwo;
                    String temp = Double.toString(valueAnswer);
                    StringTokenizer tempToken = new StringTokenizer(temp);
                    
                    while (tempToken.hasMoreTokens())
                        stack.push(tempToken.nextToken());
                    
                    postfix.dequeue();
                }
                
                else if (postfix.peek().equals("*"))  
                {
                    double valueOne = Double.parseDouble(stack.pop());
                    double valueTwo = Double.parseDouble(stack.pop());
                    double valueAnswer = valueOne * valueTwo;
                    String temp = Double.toString(valueAnswer);
                    StringTokenizer tempToken = new StringTokenizer(temp);
                    
                    while (tempToken.hasMoreTokens())
                        stack.push(tempToken.nextToken());
                    
                    postfix.dequeue();
                }
                
                else if (postfix.peek().equals("/"))  
                {
                    double valueOne = Double.parseDouble(stack.pop());
                    double valueTwo = Double.parseDouble(stack.pop());
                    
                    if (valueOne == 0) 
                    	return "Cannot divide by 0.";
                
                    else 
                    {
                        double valueAnswer = valueTwo / valueOne;
                        String temp = Double.toString(valueAnswer);
                        StringTokenizer tempToken = new StringTokenizer(temp);
                        
                        while (tempToken.hasMoreTokens())
                            stack.push(tempToken.nextToken());
                        
                        postfix.dequeue();
                    }
                }
                
                else if (postfix.peek().equals("-"))  
                {
                    double valueOne = Double.parseDouble(stack.pop());
                    double valueTwo = Double.parseDouble(stack.pop());
                    double valueAnswer = valueTwo - valueOne;
                    String temp = Double.toString(valueAnswer);
                    StringTokenizer tempToken = new StringTokenizer(temp);
                    
                    while (tempToken.hasMoreTokens())
                        stack.push(tempToken.nextToken());
                    
                    postfix.dequeue();
                }
                
                
                else if (postfix.peek().equals("%"))  
                {
                    double valueOne = Double.parseDouble(stack.pop());
                    double valueTwo = Double.parseDouble(stack.pop());
                    double valueAnswer = valueTwo % valueOne;
                    String temp = Double.toString(valueAnswer);
                    StringTokenizer tempToken = new StringTokenizer(temp);
                    
                    while (tempToken.hasMoreTokens())
                        stack.push(tempToken.nextToken());
                    
                    postfix.dequeue();
                }
                
                else if (postfix.peek().equals("^"))  
                {
                    double valueOne = Double.parseDouble(stack.pop());
                    double valueTwo = Double.parseDouble(stack.pop());
                    double valueAnswer = Math.pow(valueTwo, valueOne);
                    String temp = Double.toString(valueAnswer);
                    StringTokenizer tempToken = new StringTokenizer(temp);
                    
                    while (tempToken.hasMoreTokens())
                        stack.push(tempToken.nextToken());
                    
                    postfix.dequeue();
                }
                
                else if (postfix.peek().equals("sin"))  
                {
                    double valueOne = Double.parseDouble(stack.pop());
                    double valueAnswer = Math.sin(valueOne);
                    String temp = Double.toString(valueAnswer);
                    StringTokenizer tempToken = new StringTokenizer(temp);
                    
                    while (tempToken.hasMoreTokens())
                        stack.push(tempToken.nextToken());
                    
                    postfix.dequeue();
                }
                
                else if (postfix.peek().equals("cos"))  
                {
                    double valueOne = Double.parseDouble(stack.pop());
                    double valueAnswer = Math.cos(valueOne);
                    String temp = Double.toString(valueAnswer);
                    StringTokenizer tempToken = new StringTokenizer(temp);
                    
                    while (tempToken.hasMoreTokens())
                        stack.push(tempToken.nextToken());
                    
                    postfix.dequeue();
                }
                
                else if (postfix.peek().equals("tan"))  
                {
                    double valueOne = Double.parseDouble(stack.pop());
                    double valueAnswer = Math.tan(valueOne);
                    String temp = Double.toString(valueAnswer);
                    StringTokenizer tempToken = new StringTokenizer(temp);
                    
                    while (tempToken.hasMoreTokens())
                        stack.push(tempToken.nextToken());
                    
                    postfix.dequeue();
                }
                
                else if (postfix.peek().equals("="))  
                {
                    double valueOne = Double.parseDouble(stack.pop());
                    double valueTwo = Double.parseDouble(stack.pop());
                    double valueAnswer;
                    
                    if (valueOne == valueTwo)
                        valueAnswer = 1.00;
                    
                    else
                        valueAnswer = 0.00;
                    
                    String temp = Double.toString(valueAnswer);
                    StringTokenizer tempToken = new StringTokenizer(temp);
                    
                    while (tempToken.hasMoreTokens())
                        stack.push(tempToken.nextToken());
                    
                    postfix.dequeue();
                }
                
                else if (postfix.peek().equals(">"))  
                {
                    double valueOne = Double.parseDouble(stack.pop());
                    double valueTwo = Double.parseDouble(stack.pop());
                    double valueAnswer;
                    
                    if (valueTwo > valueOne)
                        valueAnswer = 1.00;
                    
                    else
                        valueAnswer = 0.00;
                    
                    String temp = Double.toString(valueAnswer);
                    StringTokenizer tempToken = new StringTokenizer(temp);
                    
                    while (tempToken.hasMoreTokens())
                        stack.push(tempToken.nextToken());
                    
                    postfix.dequeue();
                }
                
                else if (postfix.peek().equals("<"))  
                {
                    double valueOne = Double.parseDouble(stack.pop());
                    double valueTwo = Double.parseDouble(stack.pop());
                    double valueAnswer;
                    
                    if (valueTwo < valueOne)
                        valueAnswer = 1.00;
                    
                    else
                        valueAnswer = 0.00;
                    
                    String temp = Double.toString(valueAnswer);
                    StringTokenizer tempToken = new StringTokenizer(temp);
                    
                    while (tempToken.hasMoreTokens())
                        stack.push(tempToken.nextToken());
                    
                    postfix.dequeue();
                }
                
                else if (postfix.peek().equals("&"))  
                {
                    double valueOne = Double.parseDouble(stack.pop());
                    double valueTwo = Double.parseDouble(stack.pop());
                    double valueAnswer;
                    
                    if (valueTwo == 1.00 & valueOne == 1.00)
                        valueAnswer = 1.00;
                    
                    else
                        valueAnswer = 0.00;
                    
                    String temp = Double.toString(valueAnswer);
                    StringTokenizer tempToken = new StringTokenizer(temp);
                    
                    while (tempToken.hasMoreTokens())
                        stack.push(tempToken.nextToken());
                    
                    postfix.dequeue();
                }
                
                else if (postfix.peek().equals("|"))  
                {
                    double valueOne = Double.parseDouble(stack.pop());
                    double valueTwo = Double.parseDouble(stack.pop());
                    double valueAnswer;
                    
                    if (valueTwo == 1.00 | valueOne == 1.00)
                        valueAnswer = 1.00;
                    
                    else
                        valueAnswer = 0.00;
                    
                    String temp = Double.toString(valueAnswer);
                    StringTokenizer tempToken = new StringTokenizer(temp);
                    
                    while (tempToken.hasMoreTokens())
                        stack.push(tempToken.nextToken());
                    
                    postfix.dequeue();
                }
                
                else if (postfix.peek().equals("!"))  
                {
                    double valueOne = Double.parseDouble(stack.pop());
                    double valueAnswer;
                    
                    if (valueOne == 1.00)
                        valueAnswer = 0.00;
                    
                    else
                        valueAnswer = 1.00;
                    
                    String temp = Double.toString(valueAnswer);
                    StringTokenizer tempToken = new StringTokenizer(temp);
                    
                    while (tempToken.hasMoreTokens())
                        stack.push(tempToken.nextToken());
                    
                    postfix.dequeue();
                }
                
                else
                    throw new java.util.NoSuchElementException("Equation contains unsupported characters.");
            }
        }
        
        Double stackTemp = Double.parseDouble(stack.pop());
        String stackFinal = Double.toString(stackTemp);
        return stackFinal;
    }
    
    private static boolean isDouble(String string)
    {
        try 
        {
            Double.parseDouble(string);
            return true;
        }
        
        catch (Exception exception)
        {
            return false;
        }
    }
}
