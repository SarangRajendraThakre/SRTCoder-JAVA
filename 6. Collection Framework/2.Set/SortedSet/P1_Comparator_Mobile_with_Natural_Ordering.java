import java.util.*;

class Mobile implements Comparable<Mobile> {
    String brand;

    Mobile(String brand) {
        this.brand = brand;
    }

    @Override
    public int compareTo(Mobile other) {
        return this.brand.compareTo(other.brand); // natural order by brand
    }

    @Override
    public String toString() {
        return brand;
    }
}

public class P1_Comparator_Mobile_with_Natural_Ordering {
    public static void main(String[] args) {
        TreeSet<Mobile> set = new TreeSet<>();
        set.add(new Mobile("Samsung"));
        set.add(new Mobile("Apple"));

        System.out.println("Comparator used: " + set.comparator());

        for (Mobile m : set) {
            System.out.println(m);
        }
    }
}
