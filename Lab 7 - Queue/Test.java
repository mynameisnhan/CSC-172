/* Nhan Le
 * CSC 172
 * Lab 7: Queue
 */

public class Test 
{
	public static void main(String[] args) 
	{
		Queue<String> queue = new Queue<String>();
		
		System.out.println("USING isEmpty: ");
		if (queue.isEmpty())
			System.out.println("The queue is empty.");
		
		queue.enqueue("R");
		queue.enqueue("I");
		queue.enqueue("P");
		queue.enqueue(" ");
		queue.enqueue("H");
		queue.enqueue("a");
		queue.enqueue("r");
		queue.enqueue("a");
		queue.enqueue("m");
		queue.enqueue("b");
		queue.enqueue("e");
		System.out.println("\nUSING enqueue:\nR, I, P, , H, a, r, a, m, b, e were enqueued.");
		
		System.out.println("\nUSING isEmpty: ");
		if (!queue.isEmpty())
			System.out.println("The queue is not empty.");
		
		System.out.println("\nUSING peek: ");
		System.out.println("The first element is: " + queue.peek());

		System.out.println("\nUSING dequeue: ");
		System.out.println("The dequeued element is: " + queue.dequeue());
		System.out.println("The dequeued element is: " + queue.dequeue());
		System.out.println("The dequeued element is: " + queue.dequeue());
		System.out.println("The dequeued element is: " + queue.dequeue());
		System.out.println("The dequeued element is: " + queue.dequeue());
		System.out.println("The dequeued element is: " + queue.dequeue());
		System.out.println("The dequeued element is: " + queue.dequeue());
		System.out.println("The dequeued element is: " + queue.dequeue());
		System.out.println("The dequeued element is: " + queue.dequeue());
		System.out.println("The dequeued element is: " + queue.dequeue());
		System.out.println("The dequeued element is: " + queue.dequeue());
		
		System.out.println("\nUSING isEmpty: ");
		if (queue.isEmpty())
			System.out.println("The queue is empty. Harambe is dead. The world is meaningless.");
	}	
}
