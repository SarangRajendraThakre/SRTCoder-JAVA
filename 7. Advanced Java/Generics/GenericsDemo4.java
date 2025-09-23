interface Pair<K extends Number, V> {
    K getKey();

    V getValue();
}

class KeyValuePair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public KeyValuePair(K key , V value)
    {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class GenericsDemo4 {

    public static void main(String[] args) {
        KeyValuePair<Integer, String> kvp = new KeyValuePair<>(2, "Sarang");

        KeyValuePair<String, String> kvp2 = new KeyValuePair<>(4, "Yadnesh");
        System.out.println(kvp2.getValue());




        System.out.println(kvp.getValue());

    }

}
