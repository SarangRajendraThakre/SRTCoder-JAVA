import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class List_interface_demo {

    public static void main(String[] args) {

        List<Integer> list = new  ArrayList<Integer>();

        System.out.println("----------------1------add()--------------------------");


     

        list.add(10);
        System.out.println(list);
        System.out.println("----------------2----addAll()----------------------------");

        List<Integer> list2 = new LinkedList<>();

        list2.add(10);
        list2.add(20);
        list2.add(30);
        list2.add(100);

        list.addAll(list2);
        System.out.println(list);



        System.out.println("---------------3-------remove()--------------------------");

        list.remove(0);
        System.out.println(list);

        System.out.println("----------------4-------get()-------------------------");

        System.out.println(list.get(0));

        System.out.println("--------------5--------set--------------------------");

        list.set(2, 100);
        System.out.println(list);

        System.out.println("----------------6-------indexOf-------------------------");

          int index =   list.indexOf(100);
        System.out.println( "index of 100 : "+index);

        System.out.println("-------------7--------lastIndexOf---------------------------");

        int lastIndexOf = list.lastIndexOf(100);
        System.out.println(lastIndexOf);

        System.out.println("--------------8-------sublist()---------------------------");


        List  sublist = list.subList(1, 3);


        System.out.println("--------------9-------listIterator()---------------------------");

    


        

    }

}
