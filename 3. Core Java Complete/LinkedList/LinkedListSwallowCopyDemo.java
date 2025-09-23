import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListSwallowCopyDemo {

    public static void main(String[] args) {
        
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);

        System.out.println(list1);


        LinkedList<Integer> list2 = new LinkedList<>(list1);
        System.out.println(list2);
        list2.set(0, 7000);
        System.out.println(list1);
        System.out.println(list2);
 

    }
    
}
