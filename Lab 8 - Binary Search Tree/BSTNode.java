/* Nhan Le
 * CSC 172
 * Lab 8: Binary Search Tree 
 */

public class BSTNode<T extends Comparable<T>> 
{
	public T data;
	public BSTNode<T> leftChild;
	public BSTNode<T> rightChild;
	public BSTNode<T> parent;
	
	// Method to insert.
	public void insert(T x)
	{
		doInsert(x);
	}
	
	// Internal method to insert.
	public void doInsert(T x) 
	{
		// If new element is less than node element.
		if (x.compareTo(this.data) < 0) 
		{
			if (this.leftChild == null) 
			{
				BSTNode<T> newNode = new BSTNode<>();
				newNode.data = x;
				newNode.parent = this;
				this.leftChild = newNode;
			} 
			
			else 
				this.leftChild.insert(x);	
		} 
		
		// If new element is greater than or equal to node element.

		else if (x.compareTo(this.data) > 0 || x.compareTo(this.data) == 0) 
		{
			if (this.rightChild == null) 
			{
				BSTNode<T> newNode = new BSTNode<>();
				newNode.data = x;
				newNode.parent = this;
				this.rightChild = newNode;
			} 
			
			else 
				this.rightChild.insert(x);
		}
	}

	// Method to delete.
	public void delete(T x)
	{
		doDelete(x);
	}
	
	// Internal to delete.
	private void doDelete(T x) 
	{
		// If data is found.
		if (this.data == x) 
		{
			// If node is leaf.
			if (this.leftChild == null && this.rightChild == null) 
				this.parent = null;
			
			// If parent has one child.
			else if ((this.leftChild == null || this.rightChild == null) && !(this.leftChild != null && this.rightChild != null)) 
				this.parent = this;
			
			// If parent has two children.
			else 
			{
				BSTNode<T> rightChild = this.rightChild;
				BSTNode<T> lmcOfRightChild = rightChild.leftChild;

				while (lmcOfRightChild.leftChild != null)
					lmcOfRightChild = lmcOfRightChild.leftChild;
				
				this.data = lmcOfRightChild.data;
				lmcOfRightChild.parent.leftChild = lmcOfRightChild.rightChild;
			}
		}
		
		// Keep traversing if data is not found.
		else 
		{
			if (x.compareTo(this.data) < 0) 
				if (this.leftChild != null) 
					this.leftChild.delete(x);
			
			else 
				if (this.rightChild != null) 
					this.rightChild.delete(x);	
		}
	}

	// Method to lookup.
	public boolean lookup(T x)
	{
		return doLookup(x);
	}
	
	// Internal method to lookup.
	private boolean doLookup(T x) 
	{
		// If data is found.
		if (this.data == x) 
			return true;
		
		// If new element is less than node element. 
		else if (x.compareTo(this.data) < 0) 
			if (this.leftChild != null) 
				return this.leftChild.lookup(x);

		// If new element is greater than node element.
		else // (x.compareTo(this.data) < 0) 
			if (this.rightChild != null) 
				return this.rightChild.lookup(x);
		
		return false;
	}

	// Method to print inorder.
	public void printInOrder()
	{
		doPrintInOrder();
	}
	
	// Internal method to print inorder.
	private void doPrintInOrder() 
	{
		if (this.leftChild != null) 
			this.leftChild.doPrintInOrder();

		System.out.println(this.data);
		
		if (this.rightChild != null)
			this.rightChild.doPrintInOrder();
	}

	// Method to print preorder. 
	public void printPreOrder()
	{
		doPrintPreOrder();
	}
	
	// Internal method to print preorder.
	private void doPrintPreOrder() 
	{
		System.out.println(this.data);
		
		if (this.leftChild != null) 
			this.leftChild.doPrintPreOrder();

		if (this.rightChild != null) 
			this.rightChild.doPrintPreOrder();
	}

	// Method to print postorder.
	public void printPostOrder()
	{
		doPrintPostOrder();
	}
	
	// Internal method to print postorder.
	private void doPrintPostOrder() 
	{
		if (this.leftChild != null) 
			this.leftChild.doPrintPostOrder();

		if (this.rightChild != null) 
			this.rightChild.doPrintPostOrder();
		
		System.out.println(this.data);
	}
}
