/* Nhan Le
 * CSC 172
 * Project 2: Postfix Calculator
 */

public interface StackInterface<T> 
{
	public boolean isEmpty();
	public void push(T x);
	public T pop();
	public T peek();
}