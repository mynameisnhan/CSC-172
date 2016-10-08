/* Nhan Le
 * CSC 172
 * Lab 6: Stack
 */

public class Test 
{
	public static void main(String[] args) 
	{
		Stack<String> stack = new Stack<String>();
		
		System.out.println("USING isEmpty: ");
		if (stack.isEmpty())
			System.out.println("The stack is empty.");
		
		stack.push("e");
		stack.push("b");
		stack.push("m");
		stack.push("a");
		stack.push("r");
		stack.push("a");
		stack.push("H");
		stack.push(" ");
		stack.push("P");
		stack.push("I");
		stack.push("R");
		System.out.println("\nUSING push:\ne, b, m, a, r, a, H, , P, I, R were inserted.");
		
		System.out.println("\nUSING isEmpty: ");
		if (!stack.isEmpty())
			System.out.println("The stack is not empty.");
		
		System.out.println("\nUSING peek: ");
		System.out.println("The first element is: " + stack.peek());
		
		System.out.println("\nUSING pop: ");
		System.out.println("The popped element is: " + stack.pop());
		System.out.println("The popped element is: " + stack.pop());
		System.out.println("The popped element is: " + stack.pop());
		System.out.println("The popped element is: " + stack.pop());
		System.out.println("The popped element is: " + stack.pop());
		System.out.println("The popped element is: " + stack.pop());
		System.out.println("The popped element is: " + stack.pop());
		System.out.println("The popped element is: " + stack.pop());
		System.out.println("The popped element is: " + stack.pop());
		System.out.println("The popped element is: " + stack.pop());
		System.out.println("The popped element is: " + stack.pop());
		
		System.out.println("\nUSING isEmpty: ");
		if (stack.isEmpty())
			System.out.println("The stack is empty. Harambe is dead. The world is meaningless.");
	}
}