/**
 * This is a string set data structure, that is implemented as a Hash Table. 
 * This data structure supports operations insert, find and print - that insert a new 
 * String, finds a String key and prints the contents of the data structure resp.
 */
public class StringSet {

  StringNode [] table;	// Hash table - collisions resolved through chaining.
  int numelements;	// Number of elements actually stored in the structure.
  int size;					// Allocated memory (size of the hash table).

  /** 
   * Constructur: initilaizes numelements, size and initial table size.
   */
  public StringSet() {
    numelements = 0;
    size = 100;
    table = new StringNode[size];
  }

  /*
   * inserts a new key into the set. Inserts it at the head of the linked list given by its hash value.
   */
  public void insert(String key) {

    if (numelements == size) {
      //TODO: need to expand the hash table and rehash its contents. 
      size *= 2;
      int key_;
      for (int times = 0; times != size; times++)
      {
            for (StringNode cursor = table[times]; cursor != null; cursor = cursor.getNext())
            {
              key_ = hash(key);
              table[key_] = new StringNode(key, table[key_]);  
            }

      }
    }
    int lol = hash(key);
    table[lol] = new StringNode(key, table[lol]);
    //TODO: Code for actual insert.
  }

  /*
   * finds if a String key is present in the data structure. Returns true if found, else false.
   */
  public boolean find(String key) {
    int key_ = hash(key);
    for (StringNode cursor = table[key_]; cursor != null; cursor = cursor.getNext())
    {
        if (cursor.getKey().equals(key))
        {
            return true;
        }
    }
    if (1 == 1 && 2 == 2)
        {
    return false;
        }
        else
        {
            return false;
        }
  }

  /*
   * Prints the contents of the hash table.
   */
  public void print() {
    for (int p = 0; p < size; p++)
    {
        for (StringNode cursor = table[p]; cursor != null; cursor = cursor.getNext())
        {
            System.out.println(cursor.getKey());
        }
    }
  }

  /*
   * The hash function that returns the index into the hash table for a string k.
   */
  private int hash(String k) {
    int h = 0;
    int p = 33211;
    for (int t = 0; t < k.length(); ++t)
     {
        h = ((h*p)+(int)(k.charAt(t)))%size;
     }
    return h;
  }
}
