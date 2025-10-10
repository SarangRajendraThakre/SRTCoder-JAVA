import java.util.LinkedList;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

 class Entry<K, V> {
    K key;
    V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}



 class MyHashTable<K, V> {

    // Global variable to define the number of buckets
    private static final int CAPACITY = 10; 


    // The array of linked lists (the buckets)

    private LinkedList<Entry<K,V>>[] table; 
    
    // Stores the total number of key-value mappings
    private int size; 

    // Constructor to initialize the table
    public MyHashTable() {
        // Initialize the array of linked lists
        table = new LinkedList[CAPACITY]; 

    //   above line is similar to 
    //    int[] table = new int[CAPACITY];
        
        // Initialize each bucket with an empty linked list
       for(int i = 0;i<CAPACITY ;i++)
       {
        table[i] = new LinkedList<>();
       }
       this.size=0;
    }

    // A simple hash function to map a key to an index
    private int hashFunction(K key) {
        // Uses the key's built-in hashCode and the modulo operator 
        // to fit it within the array's capacity.
        return Math.abs(key.hashCode() % CAPACITY);
    }





    /**
     * Inserts a key-value pair into the hash table. 
     * If the key already exists, it updates the value.
     */
    public boolean put(K key, V value) {
        int index = hashFunction(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // 1. Check if the key already exists (Collision check within the bucket)
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Key found: Update the value and return
                entry.value = value;
                return true; 
            }
        }

        // 2. Key not found: Add a new entry
        bucket.add(new Entry<>(key, value));
        size++;
        return true;
    }

    /**
     * Retrieves the value associated with a given key.
     */
    public V get(K key) { // (Lines 91-98)
        int index = hashFunction(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }



    /**
     * Removes the key-value pair associated with the key.
     */
    public V remove(K key) { // (Lines 50-62 in Image 2819e8.jpg)
        V value = null;
        int index = hashFunction(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        
        // Use an Iterator for safe removal while traversing
        Iterator<Entry<K, V>> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.key.equals(key)) {
                value = entry.value;
                iterator.remove(); // Safely remove the entry
                size--;
                return value;
            }
        }
        return value; // Will be null if key wasn't found
    }

    /**
     * Returns a Set containing all the keys in the hash table.
     */
    public Set<K> keySet() { // (Lines 81-89 in Image 2819ca.jpg)
        Set<K> keys = new HashSet<>();
        
        // Iterate through all buckets
        for (int i = 0; i < CAPACITY; i++) {
            // Iterate through all entries in the bucket's linked list
            for (Entry<K, V> entry : table[i]) {
                keys.add(entry.key);
            }
        }
        return keys;
    }


    /**
     * Returns the total number of key-value mappings.
     */
    public int size() { // (Lines 103-105 in Image 2819b0.jpg)
        return size;
    }

    /**
     * Provides a string representation of the hash table.
     */
    @Override // (Lines 67-77 in Image 2819ca.jpg)
    public String toString() {
        if (size() == 0) return "{}";
        String op = "{";

        for (int i = 0; i < CAPACITY; i++) {
            for (Entry<K, V> entry : table[i]) {
                op += entry.key + "=" + entry.value + ", ";
            }
        }
        // Remove the trailing ", " and close the brace
        if (op.length() > 1) {
            op = op.substring(0, op.length() - 2); 
        }
        return op + "}";
    }
}




public class MyHashTableDriver { // (Lines 107-127 in Image 2819b0.jpg)

    public static void main(String[] args) {
        System.out.println("HELLO000");

        // Create a new hash table mapping Integer keys to String values
        MyHashTable<Integer, String> table = new MyHashTable<>();
        System.out.println(table.size()); // Should print 0

        // Put operations
        table.put(1, "JAVA");
        table.put(123, "HELLO");
        table.put(25, "WORLD");
        table.put(10, "HIE");
        table.put(113, "BYE"); // Assuming this is a collision or a new entry
        table.put(0, "HELLO JAVA");
        table.put(222, "HELLO WORLD");

        // The image shows the put operations, let's assume it prints the size after this.
        System.out.println("Size after puts: " + table.size()); 
        
        // Use keySet() to get all the keys
        Set<Integer> keys = table.keySet(); // (Line 120)

        // Iterate through the keys and print the key and its value
        for (Integer key : keys) { // (Line 122)
            System.out.println("key=" + key + ":table.getValue(key)=" + table.get(key));
        }

        // Example of remove operation (not explicitly shown in the loop, but good to test)
        System.out.println("Removing key 10: " + table.remove(10)); 
        System.out.println("Size after remove: " + table.size()); 
        System.out.println("Final Table: " + table);
    }
}