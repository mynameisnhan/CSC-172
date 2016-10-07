Nhan Le
CSC 172
Project 2: Postfix Calculator

=== SYNOPSIS ===
Step 1:
Each line of txt file is added to input array as string.

Step 2:
Each input array unit (consisting of one string of one infix equation) is converted to postfix equation.
   InfixToPostfix.java parses infix string and adds spaces where needed for StringTokenizer delimiters. 
   StringTokenizer parses infix string and assigns each unit to infix string queue (using spaces as delimiters).
   Infix string queue is converted to postfix string queue using shunting-yard algorithm.

Step 3:
Postfix string queue is converted to postfix string and is put through calculator that returns answer string.
   PostfixCalc.java's StringTokenizer parses postfix string and assigns each unit to postfix string queue (using spaces as delimiters).
   If first in postfix string queue is an operand, dequeue and push to number stack.
   If first in postfix string queue is an operator, pop from number stack either 1 number for ! or 2 numbers for other operators, solve,
   and push answer to stack.
   When postfix string queue is empty, stack should contain one value that is the answer, which is converted to String form.
   Answer string is added to answer array.

Step 4:
Each answer array unit is added to txt file on new line.

EXTRA CREDIT 1: ^, %, sin, cos, and tan are supported.
EXTRA CREDIT 2: Division by 0 prints prints out "Cannot divide by zero". Unrecognized operators throw error.

LIMITATION: The program works on the assumption that all tokens are delimited by spaces except parentheses, 
!, sin, cos, tan, and ^. For sin(, cos(, and tan(, 1 space is added between the function and the open parenthesis. 
For (expression), 1 space is added between the open parenthesis and the first token of the inner expression and 
between the last token of the inner expression and the close parenthesis. For !operand, 1 space is added between ! and operand. 
For operand^operand, 1 space is added between the first operand and ^ and between ^ and the second operand.

infix_expr_short.txt: Contains input demonstrating functionality
extracred1.txt: Contains input demonstrating use of ^, %, sin, cos, and tan
extracred2.txt: Contains input demonstrating handling of an illegal expression
SLLInterface.java: Contains interface for SLL
SLL.java: Contains SLL implementation that implements SLLInterface.java
StackInterface.java: Contains interface for stack.
Stack.java: Contains stack implementationbased on SLL that implements StackInterface.java
DLLInterface.java: Contains interface for DLL
DLL.java: Contains DLL implementation that implements DLLInterface.java
QueueInterface.java: Contains interface for queue
Queue.java: Contains queue implementation based on DLL that implements QueueInterface.java
InfixToPostfix.java: Contains conversion of infix string to postfix string queue node
PostfixCalc.java: Contains calculation of postfix string to answer string
Main.java: Contains main method

=== TO RUN ===
Open command prompt
Change directory to folder with lab material
To compile, type: javac *.java
To run Main.java with input from infix_expr_short.txt and output to output1.txt, type: java Main infix_expr_short.txt output1.txt
To run Main.java with input from extracredit1.txt and output to output2.txt, type: java Main extracredit1.txt output2.txt
To run Main.java with input from extracredit2.txt and output to output3.txt, type: java Main extracredit2.txt output3.txt
