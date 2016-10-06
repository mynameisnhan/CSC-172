/* Nhan Le
 * CSC 172
 * Project 2: Postfix Calculator
 */

public interface QueueInterface<T> 
{
	public boolean isEmpty();
	public void enqueue(T x);
	public T dequeue();
	public T peek();
}