/* Nhan Le
 * CSC 172
 * Lab 6: Stack
 */

public interface StackInterface<T> 
{
	public boolean isEmpty();
	public void push(T x);
	public T pop();
	public T peek();
}
