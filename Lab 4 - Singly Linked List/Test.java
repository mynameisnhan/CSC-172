/* Nhan Le
 * CSC 172
 * Lab 4: Singly Linked List 
 */

public class Test 
{
	public static void main(String[] args) 
	{
	    // Initialize SLL.
	    SLL<String> list = new SLL<String>();
	    
	    System.out.println("USING isEmpty: ");
	    if (list.isEmpty())
	    	System.out.println("The String list is empty.");
	    
	    list.insert("h");
	    list.insert("a");
	    list.insert("r");
	    list.insert("A"); 
	    list.insert("a"); // This will not be added because "a" is already present."
	    list.insert("m");
	    list.insert("b");
	    list.insert("e");
	    System.out.println("\nUSING insert:\nh, a, r, A, m, b, e were inserted.");		
	    
	    System.out.println("\nUSING printList: ");
	    list.printList();
	    
	    System.out.println("\nUSING isEmpty: ");
	    if (!list.isEmpty())
	    	System.out.println("The String list is not empty.");
	    
	    System.out.println("\nUSING isPresent: ");
	    if (list.isPresent("h"))
	    	System.out.println("The String list contains \"h\".");  
	    
	    System.out.println("\nUSING lookup: ");
	    System.out.println("Does SLL contain \"harambe\"?: " + list.lookup("harambe")); 
	    
	    list.delete("b");
	    list.delete("e");
	    System.out.println("\nUSING delete:\nb, e were deleted. ");
	    
	    System.out.println("\nUSING printList: ");
	    list.printList();
	    
	    System.out.println("\nUSING returnSize: ");
	    System.out.println("The size of the list is: " + list.returnSize());
	}
}
