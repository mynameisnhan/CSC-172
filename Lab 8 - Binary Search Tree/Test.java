/* Nhan Le
 * CSC 172
 * Lab 8: Binary Search Tree
 */

public class Test {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        
        // Insert values in BST.
        System.out.println("USING insert:");
        bst.insert(36);
        bst.insert(57);
        bst.insert(42);
        bst.insert(99);
        bst.insert(160);
        bst.insert(382);
        bst.insert(282);
        bst.insert(731);
        bst.insert(5);
        bst.insert(1001);
        System.out.println("36, 57, 42, 99, 160, 382, 282, 731, 5, 1001 were inserted.");
        
        // Print values in BST.
        System.out.println("\nUSING printPreOrder:");
        bst.printPreOrder();
        
        System.out.println("\nUSING printInOrder:");
        bst.printInOrder();
        
        System.out.println("\nUSING printPostOrder:");
        bst.printPostOrder();
        
        // Look up values 39 and 36.
        System.out.println("\nUSING lookup:");
        if (!bst.lookup(39))
            System.out.println("39 is not found.");
        if (bst.lookup(36))
            System.out.println("36 is found.");
        
        // Delete 36 and 99 and print new BST.
        System.out.println("\nUSING delete:");
        bst.delete(36);
        System.out.println("36 is deleted.");
        bst.delete(99);
        System.out.println("99 is deleted.");
        
        System.out.println("\nUSING printPreOrder:");
        bst.printPreOrder();
        
        System.out.println("\nUSING printInOrder:");
        bst.printInOrder();

        System.out.println("\nUSING printPostOrder:");
        bst.printPostOrder();
    }   
}
