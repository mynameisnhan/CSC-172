/* Nhan Le
 * CSC 172
 * Lab 7: Queue
 */

public interface DLLInterface<T> 
{
	public void insert(T x);
	public T delete();
	public boolean isPresent(T x);
	public T lookup(T x);
	public boolean isEmpty();
	public void printList();
	public void printListRev();
}
