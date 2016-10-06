/* Nhan Le
 * CSC 172
 * Lab 7: Queue
 */

public interface QueueInterface<T> 
{
	public boolean isEmpty();
	public void enqueue(T x);
	public T dequeue();
	public T peek();
}
