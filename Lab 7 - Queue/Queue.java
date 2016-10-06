/* Nhan Le
 * CSC 172
 * Lab 7: Queue
 */

public class Queue<T> implements QueueInterface<T> 
{
	public DLL<T> list = new DLL<T>();
	
	public Queue() 
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
	public void enqueue(T x) 
	{
		list.insert(x);
	}

	@Override
	public T dequeue() 
	{
		return list.delete();
	}

	@Override
	public T peek() 
	{
		return list.peek();
	}
}
