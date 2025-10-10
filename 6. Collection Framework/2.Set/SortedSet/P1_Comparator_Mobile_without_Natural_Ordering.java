import java.util.*;

class Mobile {
    String brand;
    double price;

    Mobile(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return brand + " | ₹" + price;
    }
}

public class P1_Comparator_Mobile_without_Natural_Ordering {
    public static void main(String[] args) {
        Comparator<Mobile> byPrice = (m1, m2) -> Double.compare(m1.price, m2.price);

        TreeSet<Mobile> set = new TreeSet<>(byPrice);
        set.add(new Mobile("Samsung", 25000));
        set.add(new Mobile("Apple", 80000));

        System.out.println("Comparator used: " + set.comparator());

        for (Mobile m : set) {
            System.out.println(m);
        }
    }
}
