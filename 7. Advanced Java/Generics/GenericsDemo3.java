
interface Container<T> {
    void add(T item);

    T get();
}

class Box<T> implements Container<T> {

    private T items;

    public void add(T item) {
        this.items = item;
    }

    public T get() {
        return this.items;
    }
}

public class GenericsDemo3 {

    public static void main(String[] args) {

        Box<String> b = new Box();
        b.add("sarang");
     System.out.println(b.get());


     Box<Integer> b2 = new Box();
     b2.add(33423);
     System.out.println(b2.get());

    }

}
