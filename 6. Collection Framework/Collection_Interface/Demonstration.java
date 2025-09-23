import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;

class MyCollection {

    public static void swap(List<?> list, int i, int j) {

        swapHelper(list, i, j);
    }

    private static <E> void swapHelper(List<E> list, int i, int j) {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * Reverses the order of the elements in the specified list.
     */
    public static <E> void reverse(List<E> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {

            swap(list, i, size - 1 - i);
        }
    }

    /**
     * Replaces every element in a list with the specified element.
     */
    public static <E> void fill(List<E> list, E element) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, element);
        }
    }

    /**
     * Finds the minimum element in a list according to natural ordering.
     */
    public static <E extends Comparable<E>> E min(List<E> list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        E min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(min) < 0) {
                min = list.get(i);
            }
        }
        return min;
    }

    /**
     * Finds the maximum element in a list according to natural ordering.
     */
    public static <E extends Comparable<E>> E max(List<E> list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        E max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return max;
    }

    /**
     * Replaces all occurrences of one specified value with another.
     */
    public static <E> void replaceAll(List<E> list, E oldValue, E newValue) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), oldValue)) {
                list.set(i, newValue);
            }
        }
    }

    /**
     * Rotates the elements in the specified list by the specified distance.
     */
    public static void rotate(List<?> list, int distance) {
        int size = list.size();
        if (size == 0) {
            return;
        }

        distance = distance % size;
        if (distance < 0) {
            distance += size;
        }
        if (distance == 0) {
            return;
        }

        reverse(list.subList(0, size - distance));
        reverse(list.subList(size - distance, size));
        reverse(list);
    }

}

public class Demonstration {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println(MyCollection.min(list));

        MyCollection.fill(list, 100);
        System.out.println(list);


MyCollection.reverse(list);
System.out.println(list);



    }

}