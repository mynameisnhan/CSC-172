/* Nhan Le
 * CSC 172
 * Lab 5: Doubly Linked List
 */

public interface DLLInterface<T> 
{
	public void insert(T x);
	public void delete(T x);
	public boolean isPresent(T x);
	public T lookup(T x);
	public boolean isEmpty();
	public void printList();
	public void printListRev();
}
