Nhan Le
CSC 172
Project 2: Postfix Calculator

=== SYNOPSIS ===
Step 1:
Each line of txt file is added to input array as String.

Step 2:
Each input array unit (consisting of one String of one infix equation) is converted to postfix equation.
   InfixToPostfix.java parses infix String and adds spaces where needed for StringTokenizer delimiters. 
   StringTokenizer parses infix String and assigns each unit to infix String queue (using spaces as delimiters).
   Infix String queue is converted to postfix String queue using shunting-yard algorithm.

Step 3:
Postfix String queue is converted to postfix String and is put through calculator that returns answer String.
   PostfixCalc.java's StringTokenizer parses postfix String and assigns each unit to postfix String queue (using spaces as delimiters).
   If first in postfix String queue is an operand, dequeue and push to number stack.
   If first in postfix String queue is an operator, pop from number stack either 1 number for ! and function operators or 2 numbers for other operators, solve, and push answer to stack.
   When postfix String queue is empty, stack should contain one value that is the answer, which is converted to String form.
   Answer String is added to answer array.

Step 4:
Each answer array unit is added to txt file on new line.

EXTRA CREDIT 1: ^, %, sin, cos, and tan are supported.

EXTRA CREDIT 2: Division by 0 prints prints out "Cannot divide by zero.". Unrecognized operators and operands during calculations print out the first unrecognized character "is not supported.".

ASSUMPTION 1: The program assumes that all tokens are delimited by spaces except parentheses, 
!, sin, cos, tan, and ^. For sin(, cos(, and tan(, 1 space is added between the function and the open parenthesis. 
For (expression), 1 space is added between the open parenthesis and the first token of the inner expression and 
between the last token of the inner expression and the close parenthesis. For !operand, 1 space is added between ! and operand. 
For operand^operand, 1 space is added between the first operand and ^ and between ^ and the second operand.

ASSUMPTION 2: The program assumes that - followed by space indicates subtraction but - followed by any number indicates negativity.

LIMITATION: The program only works for numeric operands.

infix_expr_short.txt: Contains input demonstrating functionality
extracred1.txt: Contains input demonstrating use of ^, %, sin, cos, and tan
extracred2.txt: Contains input demonstrating handling of an illegal expression
SLLInterface.java: Contains interface for SLL
SLL.java: Contains SLL implementation that implements SLLInterface.java
StackInterface.java: Contains interface for stack.
Stack.java: Contains stack implementation based on SLL that implements StackInterface.java
DLLInterface.java: Contains interface for DLL
DLL.java: Contains DLL implementation that implements DLLInterface.java
QueueInterface.java: Contains interface for queue
Queue.java: Contains queue implementation based on DLL that implements QueueInterface.java
InfixToPostfix.java: Contains conversion of infix String to postfix String queue
PostfixCalc.java: Contains calculation of postfix String to answer String
Main.java: Contains main method

=== TO RUN ===
Open command prompt
Change directory to folder with lab material
To compile, type: javac *.java
To run Main.java with input from infix_expr_short.txt and output to output1.txt, type: java Main infix_expr_short.txt output1.txt
To run Main.java with input from extracred1.txt and output to output2.txt, type: java Main extracred1.txt output2.txt
To run Main.java with input from extracred2.txt and output to output3.txt, type: java Main extracred2.txt output3.txt
