/* Nhan Le
 * CSC 172
 * Lab 4: Singly Linked List 
 */

public interface SLLInterface<T> 
{
	public void insert(T x);
	public void delete(T x);
	public boolean isPresent(T x); // Changed from "contains" in rubric.
	public T lookup(T x);
	public boolean isEmpty();
	public void printList();
}
