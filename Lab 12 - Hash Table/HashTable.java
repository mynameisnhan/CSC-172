/* Nhan Le
 * CSC 172
 * Lab 12: Hash Table
 */

public class HashTable
{
    String[] hashTable;

    // Constructor.
    public HashTable(int size)
    {
        hashTable = new String[size];
    }

    // Method to lookup.
    public boolean lookup(String item)
    {
        for (String hashItem : hashTable)
            if (item.equals(hashItem) == true)
                return true;

        return false;
    }

    // Method to insert.
    public void insert(String item)
    {
        // If item is not in hash table ...
        if (lookup(item) == false)
        {
            if (getLoad() > 0.5)
                rehash();

            int in = hash(item, hashTable.length);

            while (true)
            {
                if (hashTable[in] == null)
                {
                    hashTable[in] = item;
                    break;
                }

                else
                {
                    if (in == hashTable.length - 1)
                        in = 0;

                    else
                        in++;
                }
            }
        }
    }

    // Method to print.
    public void print()
    {
        for (String e : hashTable)
            if (e != null)
                System.out.print(e + ", ");

        System.out.println("\n");
    }

    public int getCapacity()
    {
        return hashTable.length;
    }

    public int getNumElements()
    {
        int sum = 0;

        for (String s : hashTable)
        {
            if (s != null)
                sum++;
        }

        return sum;
    }

    public float getLoad()
    {
        return (float) getNumElements() / (float) getCapacity();
    }

    // Method to hash.
    public static int hash(String key, int tableSize)
    {
        int hashVal = 0;

        for (int i = 0; i < key.length(); i++)
            hashVal = 37 * hashVal + key.charAt(i);

        hashVal %= tableSize;

        if (hashVal < 0)
            hashVal += tableSize;

        return hashVal;
    }

    // Method to rehash.
    private void rehash()
    {
        String[] temp = new String[hashTable.length * 2];

        for (String s : hashTable)
            if (s != null)
            {
                int in = hash(s, temp.length);

                if (temp[in] == null)
                    temp[in] = s;

                else
                    while (true)
                    {
                        if (temp[in] != null)
                        {
                            temp[in] = s;
                            break;
                        }

                        else
                        {
                            if (in == temp.length - 1)
                                in = 0;

                            else
                                in++;
                        }
                    }
            }

        hashTable = temp;
    }
}