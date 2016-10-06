/* Nhan Le
 * CSC 172
 * Project 2: Postfix Calculator
 */

public class SLL<T> implements SLLInterface<T> 
{	
	private int size;
	private SLLNode<T> head;
    
	// Constructor.
	public SLL() 
	{
		head = new SLLNode<T>();
	}
	
    	// Method to insert element at tail.
	@Override
	public void insert(T x) 
	{
        	doInsert(x);
	}
	
	// Internal method to insert element at head.
	private void doInsert(T x) 
	{
		SLLNode<T> insertedNode = new SLLNode<T>();
		insertedNode.data = x;
		insertedNode.next = head.next;
		head.next = insertedNode;
        	++size;  
	}
	
	// Method to delete node at head.
	@Override
	public T delete() 
	{
		return doDelete();
	}
	
	// Internal method to delete node at head.
	private T doDelete() 
	{
		SLLNode<T> deletedNode = head.next;
		head.next = head.next.next;
		--size;	
		return deletedNode.data;
	}
	
	// Method to determine if element of interest is in SLL.
	@Override
	public boolean isPresent(T x) 
	{
		return doIsPresent(x);
	}	

	// Internal method to determine if element of interest is in SLL.
	private boolean doIsPresent(T x) 
	{	
		SLLNode<T> currentNode = head;
		
		// Iterate until x is found in SLL.
		while (currentNode.next != null) 
		{ 
			if (currentNode.next.data == x)
				return true;
			
			else 
				currentNode = currentNode.next;
		} 
			
		return false;
	}	
	
	// Method to look up and return value of element of interest.	
	@Override
	public T lookup(T x) 
	{
		return doLookup(x);
	}
	
	// Internal method to look up and return value of element of interest.
	private T doLookup(T x) 
	{	
		T returnValue = null;		
		SLLNode<T> currentNode = head;
		
		// Iterate until x is found in SLL.
		while (currentNode.next != null) 
		{ 
			if (currentNode.next.data == x) 
				returnValue = x;
			
			else 
				currentNode = currentNode.next;
		} 
			
		return returnValue;	
	}

	// Method to return size of SLL.
	public int returnSize() 
	{
		return doReturnSize();
	}
	
	// Internal method to return size of SLL.
	public int doReturnSize() 
	{
		return size;
	}
	
	// Method to return if SLL is empty.
	@Override
	public boolean isEmpty() 
	{
		return returnSize() == 0;
	}
		
	// Method to peek at first element in SLL.
	public T peek() 
	{
		return head.next.data;
	}
	
    	// Method to print list.
	@Override
	public void printList() 
	{
        	doPrintList();
        	System.out.println();
	}
    
	// Internal method to print list.
	private void doPrintList() 
	{	
		SLLNode<T> currentNode = head;
		
		// Iterate through SLL.
		while (currentNode.next != null) 
		{ 
			System.out.print(currentNode.next.data + " "); 
			
			currentNode = currentNode.next;
		} 
	}	
}