/* Nhan Le
 * CSC 172
 * Project 2: PostFix
 */

import java.util.*;

public class InfixToPostfix 
{
    private static Queue<String> postfix;
        
    // Create postfix queue.
    public static Queue<String> toPostfix(String input) 
    {
        postfix = new Queue<String>();
             
        input = input.replace("(", "( ");
        input = input.replace(")", " )");
        input = input.replace("!", "! ");
        input = input.replace("sin", "sin ");
        input = input.replace("cos", "cos ");
        input = input.replace("tan", "tan ");
        input = input.replace("^", " ^ ");
        
        // Tokenize infix.
    	Queue<String> infix = new Queue<String>();
        StringTokenizer token = new StringTokenizer(input, " ");
        
        while (token.hasMoreTokens())
            infix.enqueue(token.nextToken());

    	// Initialize operator stack.
    	Stack<String> stack = new Stack<String>();
    	
        while (infix.returnSize() > 0) // While there are things left in infix queue ... 
        { 
            if (infix.peek().equals("&") | infix.peek().equals("|") | infix.peek().equals("=") | infix.peek().equals("<") | infix.peek().equals(">")) 
	    {
                while (stack.returnSize() > 1 && !stack.peek().equals("(") ) // While there are things left in stack ... 
                    postfix.enqueue(stack.pop()); // Pop from stack and enqueue to postfix queue.
                
                stack.push(infix.dequeue());
            }
                        
            else if (isDouble(infix.peek()))  // If first in infix queue is number ...
            	postfix.enqueue(infix.dequeue()); // Dequeue from infix queue and enqueue to postfix queue.
       
            else if (infix.peek().equals("sin") | infix.peek().equals("cos") | infix.peek().equals("tan")) // If first in infix queue is sin ...
            	stack.push(infix.dequeue()); // Dequeue infix queue and push to stack.
       
            else if (infix.peek().equals("("))  // If first in infix queue is ( ...
            	stack.push(infix.dequeue()); // Dequeue infix queue and push to stack.
            
		
            else if (infix.peek().equals(")")) { // If first in infix is ) ...
            	while ((stack.returnSize() > 0) && (!stack.peek().equals("(")))  // While first in stack is not ( ...
                    postfix.enqueue(stack.pop()); // Pop off stack and enqueue to postfix queue.
               
                stack.pop(); // Pop ( off stack.
                infix.dequeue(); // Dequeue ) from infix queue.
            }
    		
            else // If first in infix is operator ...
	    { 
                while (stack.returnSize() > 0 && (getPriority(stack.peek()) >= getPriority(infix.peek())) && !infix.peek().equals("^")) 
                    postfix.enqueue(stack.pop()); // Pop operator off stack and enqueue to postfix queue.
                
    		stack.push(infix.dequeue());
            }
    	}
    	
        while (stack.returnSize() > 0)  // While there are things left in stack ...
            postfix.enqueue(stack.pop()); // Pop from stack and enqueue to postfix queue.
        
        return postfix;
    }
    
    // Check if string is parseable to double.
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
    
    // Assign operators to integers.
    private static final int ADDORSUBTRACT = 2;
    private static final int MULTIPLYORDIVIDE = 3;
    private static final int BOOLEAN = 0;
    private static final int NOT = -4;
    private static final int EXP = 6;
    private static final int PAREN = -2;
    private static final int FUNC = 4;
     
    private static int getPriority(String operator) 
    {
        switch (operator) 
        {
            case "+":
            case "-":
                return ADDORSUBTRACT;
            case "^":
                return EXP;
            case "&":
            case "|":
            case "=":
            case ">":
            case "<":
                return BOOLEAN;
            case "%":
            case "*":
            case "/":
                return MULTIPLYORDIVIDE;
            case "!":
                return NOT;
            case "(":
            case ")":
                return PAREN;
            case "sin":
            case "cos":
            case "tan":
                return FUNC;
            default:
                throw new IllegalArgumentException("Operator not recognized.");
        }
    }    
}
