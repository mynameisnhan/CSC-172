/* Nhan Le
 * CSC 172
 * Lab 4: Singly Linked List 
 */

public class SinglyLinkedListImplementation<T> implements SinglyLinkedList<T> 
{	
	private int size;
	private MyNode<T> head;
    
	// Constructor.
	public SinglyLinkedListImplementation() 
	{
		head = new MyNode<T>();
	}
	
    	// Method to insert element at tail.
	@Override
	public void insert(T x) 
	{
        	doInsert(x);
	}
	
	// Internal method to insert element at tail.
	private void doInsert(T x) 
	{	
		// Do not add if x is already in SLL.
		if (isPresent(x) == true)
			return;
		
		// Variable declaration.
		MyNode<T> currentNode = head;
		MyNode<T> insertedNode = new MyNode<T>();
		insertedNode.data = x;
        
		// Iterate to end of SLL.
		while (currentNode.next != null) 
			currentNode = currentNode.next;
		
		// Add node and increase size count.
		currentNode.next = insertedNode;
		++size;  
	}
	
	// Method to delete node after searching.
	@Override
	public void delete(T x) 
	{
		doDelete(x);
	}
	
	// Internal method to delete node after searching.
	private void doDelete(T x) 
	{	
		// Do not attempt to delete if x is not in SLL.
		if (isPresent(x) == false) 
			return;
		
		else 
		{	
			MyNode<T> currentNode = head;
			
			// Iterate until x is found in SLL.
			while (currentNode.next != null) 
			{ 	
				if (currentNode.next.data != x)
					currentNode = currentNode.next;
				
				else 
				{
					currentNode.next = currentNode.next.next;
					--size;
					return;
				}			
			} 
			
			currentNode = currentNode.next;
		}
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
		MyNode<T> currentNode = head;
		
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
		MyNode<T> currentNode = head;
		
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
		MyNode<T> currentNode = head;
		
		// Iterate through SLL.
		while (currentNode.next != null) { 
			System.out.print(currentNode.next.data + " "); 
			currentNode = currentNode.next;
		} 
	}	
}