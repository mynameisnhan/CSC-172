/* Nhan Le
 * CSC 172
 * Project 2: Postfix Calculator
 */

public class DLL<T> implements DLLInterface<T> 
{	
	private int size;
	private DLLNode<T> head;
	private DLLNode<T> tail;
    
	// Constructor.
	public DLL() 
	{
		head = new DLLNode<T>();
		tail = new DLLNode<T>();
		head.next = tail;
		tail.prev = head;
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
		// Variable declaration.
		DLLNode<T> currentNode = tail;
		DLLNode<T> insertedNode = new DLLNode<T>();
		insertedNode.data = x;
		
		// Insert node at tail.
		insertedNode.prev = currentNode.prev;
		currentNode.prev.next = insertedNode;
		insertedNode.next = currentNode;
		currentNode.prev = insertedNode;
		
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
		DLLNode<T> deletedNode = head.next;
		head.next.next.prev = head;
		head.next = head.next.next;
		--size;
		return deletedNode.data;					
	}
	
	// Method to determine if element of interest is in DLL.
	@Override
	public boolean isPresent(T x) 
	{
		return doIsPresent(x);
	}
	
	// Internal method to determine if element of interest is in DLL.
	private boolean doIsPresent(T x) 
	{
		DLLNode<T> currentNode = head;
		
		// Iterate until x is found in DLL.
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
			
		DLLNode<T> currentNode = head;
		
		// Iterate until x is found in DLL.
		while (currentNode.next != null) 
		{ 	
			if (currentNode.next.data == x) 
				returnValue = x;
			
			else 
				currentNode = currentNode.next;
		} 
			
		return returnValue;	
	}
	
	// Method to return size of DLL.
	public int returnSize() 
	{
		return doReturnSize();
	}
	
	// Internal method to return size of DLL.
	public int doReturnSize() 
	{
		return size;
	}
	
	// Method to return if DLL is empty.
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
		DLLNode<T> currentNode = head;
		
		// Iterate through DLL.
		while (currentNode.next.next != null) 
		{ 
			System.out.print(currentNode.next.data + " "); 
			
			currentNode = currentNode.next;
		} 	
	}

	@Override
	public void printListRev() 
	{
		doPrintListRev();
		System.out.println();
	}
	
	// Internal method to print list.
	private void doPrintListRev() 
	{
		DLLNode<T> currentNode = tail;
		
		// Iterate through DLL.
		while (currentNode.prev.prev != null) 
		{ 
			System.out.print(currentNode.prev.data + " "); 
			
			currentNode = currentNode.prev;
		} 
	}	
	
	public T peek()
	{
		return head.next.data;
	}
}