

import java.util.ArrayList;

interface MyCollection {
    int size();
    boolean isEmpty();
}

interface MyList extends MyCollection {
    void add(int ele);
}

class MyArrayList implements MyList {
    // Internal ArrayList to store data
    private ArrayList<Integer> obj = new ArrayList<>();

    @Override
    public String toString() {
        return obj.toString();
    }

    @Override
    public void add(int ele) {
        obj.add(ele);
    }

    @Override
    public int size() {
        // The efficient way to get the size
        return obj.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
}

 public class P73_Interface_Driverexample {
    public static void main(String[] args) {
        MyArrayList obj = new MyArrayList();
        
        // 1. Check if the new list is empty
        System.out.println(obj.isEmpty()); // Prints: true

        obj.add(10);
        obj.add(20);
        obj.add(30);
        obj.add(40);
        
        // 2. Print the list contents
        System.out.println(obj); // Prints: [10, 20, 30, 40]
        
        // 3. Print the size of the list
        System.out.println(obj.size()); // Prints: 4
        
        // 4. Check if the list is empty now
        System.out.println(obj.isEmpty()); // Prints: false
    }
}