/* Nhan Le
 * CSC 172
 * Lab 8: Binary Search Tree
 */

public class BST<T extends Comparable<T>> implements BSTInterface<T>
{
		private BSTNode<T> root;

		public BST() 
		{
			root = new BSTNode<T>();
		}

		@Override
		// Method to insert.
		public void insert(T x) 
		{
			if (root.data == null) 
				root.data = x;
			
			else 
				root.insert(x);
		}

		@Override
		// Method to delete.
		public void delete(T x) 
		{
			if (lookup(x))
				if (root != null) 
					root.delete(x);
		}

		@Override
		// Method to lookup.
		public boolean lookup(T x) 
		{
			if (root == null) 
				return false;
			
			else 
				return root.lookup(x);
		}

		@Override
		// Method to print preorder.
		public void printPreOrder() 
		{
			if (root != null) 
				root.printPreOrder();
		}

		@Override
		// Method to print inorder.
		public void printInOrder() 
		{
			if (root != null) 
				root.printInOrder();
		}

		@Override
		// Mmetehod to print postorder.
		public void printPostOrder() 
		{
			if (root != null) 
				root.printPostOrder();
		}
}