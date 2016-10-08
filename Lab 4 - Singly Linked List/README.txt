Nhan Le
CSC 172
Lab 4: Singly Linked List

=== SYNOPSIS ===
In CSC 172 lab, we are learning about singly linked lists. The SLL was created using a node class  and an interface, both of which were given. The isPresent method was created first due to being used in other methods such as insert and delete. The lookup method was created based on isPresent, being modified to return the object in question instead of true or false. The insert and delete methods, which used isPresent to check if item is in SLL; were created. After each insertion of deletion, size is accounted for. The isEmpty and returnSize were created based on the size variable. All methods called private internal methods for privacy.

OUTPUT.txt: Contains output for Test.java
SLLNode.java = Contains node class
SLLInterface.java = Contains interface for SLL
SLL.java = Contains SLL implementation that extends SLLInterface.java
Test.java = Contains test program

=== TO RUN ===
Open command prompt
Change directory to folder with lab material
To compile, type: javac *.java
To run Test.java, type: java Test
