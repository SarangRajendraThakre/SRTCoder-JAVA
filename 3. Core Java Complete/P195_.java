import java.util.LinkedList;

public class P195_ {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println(list);

        System.out.println("-------------addLast()----------------");
        list.add(10);
        list.add(20);
        list.add(30);
        list.addLast(40);
        System.out.println(list);

        System.out.println("-------------addFirst()----------------");

        list.addFirst(100);

        System.out.println(list);

        System.out.println("-------------getFirst()----------------");

        System.out.println(list.getFirst());

        System.out.println("------------getLast-----------------");

        System.out.println(list.getLast());

        System.out.println("-----------  peek()------------------");

        System.out.println(list.peek());

        System.out.println("--------------peekFirst()---------------");

        System.out.println(list.peekFirst());

        System.out.println("------------peekLast()-----------------");

        System.out.println(list.peekLast());

        System.out.println("-----------------------------");

        System.out.println("-----------------------------");

        System.out.println(list);
    }
}