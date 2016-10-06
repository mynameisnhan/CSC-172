/* Nhan Le
 * CSC 172
 * Project 2: Postfix Calculator
 */

public class Stack<T> implements StackInterface<T>
{	
	public SLL<T> list = new SLL<T>();
	
	public Stack() 
	{
		while (!list.isEmpty())
			list.delete();
	}
	
	@Override
	public boolean isEmpty() 
	{
		return list.isEmpty();
	}

	@Override
	public void push(T x) 
	{
		list.insert(x);	
	}

	@Override
	public T pop() 
	{
		if (isEmpty())
			throw new java.util.NoSuchElementException("Cannot pop from empty stack.");
		
		else
			return list.delete();
	}

	@Override
	public T peek() 
	{
		return list.peek();
	}
	
	public int returnSize()
	{
		return list.returnSize();
	}
}