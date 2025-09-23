interface Printable {
    void print();
}

class KeyValuePair extends Number implements Printable {
    private final int value;

    public KeyValuePair(int value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.println(value);
    }

    // Overriding abstract methods from Number
    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return (long) value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public double doubleValue() {
        return (double) value;
    }
}

class Boxx<T extends Number & Printable> {
    private T item;

    public Boxx(T item) {
        this.item = item;
    }

    public void display() {
        item.print();
    }
}

public class GenericsDemo5 {
    public static void main(String[] args) {
        // This now works because KeyValuePair correctly implements all required methods
        KeyValuePair kvp = new KeyValuePair(45634);
        
        // The generic type constraint T extends Number & Printable is now satisfied
        Boxx<KeyValuePair> b = new Boxx<>(kvp);
        
        b.display(); // Prints: 45634
    }
}