import java.util.ArrayList;
import java.util.Iterator;

public class P0_C_ {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();


        ArrayList<Integer> inte = new ArrayList<>();
        ArrayList<String> str = new ArrayList<>();
        ArrayList<Boolean> bool = new ArrayList<>();
        ArrayList<Double> doub = new ArrayList<>(); // Added for the double value

        list.add(10);
        list.add(true);
        list.add(false);
        list.add("Sarang");
        list.add(143.433);
        list.add(143);
        list.add(1434);

        System.out.println("Original list: " + list);
        System.out.println("---");

        Iterator<Object> i = list.iterator();

        while (i.hasNext()) {
            Object element = i.next();

            if (element instanceof Integer) {
                inte.add((Integer) element);
            } else if (element instanceof String) {
                str.add((String) element);
            } else if (element instanceof Boolean) {
                bool.add((Boolean) element);
            } else if (element instanceof Double) {
                doub.add((Double) element);
            }
        }

        System.out.println("Integers: " + inte);
        System.out.println("Strings: " + str);
        System.out.println("Booleans: " + bool);
        System.out.println("Doubles: " + doub);
    }
}