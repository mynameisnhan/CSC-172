/* Nhan Le
 * CSC 172
 * Lab 12: Hash Table
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test
{
    public static Scanner in;

    public static void main(String args[]) throws FileNotFoundException
    {

        int wordCount = 0;

        String input =  new File("").getAbsolutePath().concat("\\LoremIpsum.txt");
        File in = new File(input);

        HashTable test = new HashTable(13);

        try (Scanner sc = new Scanner(in).useDelimiter("[ ,!?.]+"))
        {
            while (sc.hasNext())
            {
                String insertedWord = sc.next();

                test.insert(insertedWord);
                wordCount++;
            }

            sc.close();
        }

        System.out.println("USING print: ");
        test.print();

        System.out.println("Unique words: " + test.getNumElements());
        System.out.println("Hash table capacity: " + test.getCapacity());
        System.out.println("Words scanned in: " + wordCount);
    }
}
