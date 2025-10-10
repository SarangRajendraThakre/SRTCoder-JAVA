import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

class Entry<K, V> {
    K key;
    V value;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class Hashtable<K, V> {

    private static final int CAPACITY = 10;

    private int size;

    private LinkedList<Entry<K, V>>[] table;

    public Hashtable() {
        table = new LinkedList[CAPACITY];

        for (int i = 0; i < CAPACITY; i++) {
            table[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    private int hashFunction(K key) {
        return Math.abs(key.hashCode() % CAPACITY);

    }

    public boolean put(K key, V value) {
        int index = hashFunction(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return true;
            }
        }

        bucket.add(new Entry<>(key, value));
        size++;
        return true;

    }

    public V get(K key) {
        int index = hashFunction(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        V value = null;

        int index = hashFunction(key);

        LinkedList<Entry<K, V>> bucket = table[index];
        Iterator<Entry<K, V>> iterator = bucket.iterator();
        while (iterator.hasNext()) {

            Entry<K, V> entry = iterator.next();
            if (entry.key.equals(key)) {
                value = entry.value;
                iterator.remove();
                size--;
                return value;
            }

        }
        return value;
    }

    public Set<K> keySet() {

        Set<K> keys = new HashSet<>();

        for (int i = 0; i < CAPACITY; i++) {
            for (Entry<K, V> entry : table[i]) {
                keys.add(entry.key);
            }
        }
        return keys;

    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size() == 0)
            return "{}";

        String s = "{";

        for (int i = 0; i < CAPACITY; i++) {
            for (Entry<K, V> entry : table[i]) {
                s += entry.key + " : " + entry.value + " ,";
            }
        }
        if (s.length() > 1) {
            s = s.substring(0, s.length() - 2);
        }
        s += "}";
        return s;

    }

}

public class MyHashTableDriverP1 {

    public static void main(String[] args) {
        Hashtable<String, Integer> ht = new Hashtable<>();
        ht.put("Sarang", 1);
        System.out.println(ht);

        ht.put("Sarang", 100);
        System.out.println(ht);

        ht.remove("Sarang");
        System.out.println(ht);

        ht.put("Yadnesh", 2900);
        System.out.println(ht);
        System.out.println(ht.keySet());
    }

}