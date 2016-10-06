Nhan Le
CSC 172
Project 1: Hamming(7, 4) and Hamming(15, 11)

=== SYNOPSIS ===
The purpose of the project was to be exposed to hamming codes. The program implements one of 4 methods: encode7_4("input path", "output path"), encode15_11("input path", "output path"), decode7_4("input path", "output path"), and decode15_11("input path", "output path") and creates an output file. 

Both encode methods parsed bytes from input, stored binary ASCII values of bytes within byte arrays of value arrays, performed matrix multiplication with value subarrays and generator matrix, and generated output files with results. The differences between encode7_4 and encode15_11 pertain to size of generator matrix,amount of leading zeroes, and whether code blocks were split up before matrix multiplication to be compatible with generator matrix. 

The first part of both decode methods worked similarly to both encode methods, with the main difference being using parity check matrix instead of generator matrix. The differences between decode7_4 and decode15_11 pertain to size of parity check matrix and whether code blocks were joined before matrix multiplication to be compatible with parity check matrix.

The second part of both decode methods listed all possible errors calculated by matrix multiplication, decided whether error codes were due to single bit or double bit error, and provided solutions for error detection or correction.

EXTRA CREDIT: Double bit error throws error for both decode methods, as requested.

testfile.txt = Contains original message to be encoded
encodedtestfile7_4.txt = Contains Hamming(7, 4) encoding of testfile.txt
decodedtestfile7_4.txt = Contains Hamming(7, 4) decoding of encodedtestfile7_4.txt
encodedtestfile15_11.txt = Contains Hamming(15, 11) encoding of testfile.txt
decodedtestfile15_11.txt = Contains Hamming(15, 11) decoding of encodedtestfile15_11.txt 
1error_encodedtestfile7_4.txt = Contains Hamming(7, 4) encoding of testfile.txt with single bit error at first character
1error_encodedtestfile7_4_fix.txt = Contains Hamming(7, 4) error correction of encodedtestfile7_4.txt
2errors_encodedtestfile7_4.txt = Contains Hamming(7, 4) encoding of testfile.txt with double bit error at first character
1error_encodedtestfile15_11.txt = Contains Hamming(15, 11) encoding of testfile.txt with single bit error at first character
1error_encodedtestfile15_11_fix.txt = Contains Hamming(15, 11) error correction of encodedtestfile15_11.txt
2errors_encodedtestfile7_4.txt = Contains Hamming(15, 11) encoding of testfile.txt with double bit error at first character
Hamming.java = Contains hamming codes
Main.java = Contains main method

=== TO TEST ===
To test encode7_4, perform the method on testfile.txt. The output file should be the same as encodedtestfile7_4.txt.  

To test encode15_11, perform the method on testfile.txt. The output file should be the same as encodedtestfile15_11.txt.

To test that decode7_4 works for no errors, perform the method on encodedtestfile7_4.txt. The output should be the same as decodedtestfile7_4.txt which is the same as testfile.txt.  

To test that decode7_4 works for single bit errors, perform the method on 1error_encodedtestfile7_4.txt. The output should be the same as decodedtestfile7_4.txt which is the same as testfile.txt.

To test that decode7_4 works for double bit errors, perform the method on 2errors_encodedtestfile7_4.txt. The program should throw error.

To test that decode15_11 works for no errors, perform the method on encodedtestfile15_11.txt. The output should be the same as decodedtestfile7_4.txt which is the same as testfile.txt.  

To test that decode15_11 works for single bit errors, perform the method on 1error_encodedtestfile15_11.txt. The output should be the same as decodedtestfile7_4.txt which is the same as testfile.txt.   

To test that decode15_11 works for double bit errors, perform the method on 2errors_encodedtestfile15_11.txt. The program should throw error.

=== TO RUN ===
Open command prompt
Change directory to folder with lab material
To compile, type: javac *.java
To run Test.java, type: java Main
Type input filepath as prompted
Type output filepath as prompted
Type int between 0 and 3 to select method as prompted
