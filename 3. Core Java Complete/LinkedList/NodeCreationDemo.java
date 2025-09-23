public class NodeCreationDemo {

    // The Node class is defined inside for this example
    private static class Node<E> {
        E ele;
        Node<E> next;

        public Node(E ele) {
            this.ele = ele;
            this.next = null;
        }

        public void add(E ele)
        {

        }
    }



    public static void main(String[] args) {
        // 1. Declare the 'head' variable.
        Node<String> head;

        System.out.println("Before creation, head is: " + null);

        // 2. Create a new Node object with data "A".
        //    The reference (memory address) of this new object is assigned to 'head'.
        Node<String> A = new Node<>("A");

        System.out.println(A);
         head = A;

        System.out.println("\nAfter creation, printing the 'head' variable itself:");
        // 3. This prints the object's reference, not its content.
        System.out.println(head);

        System.out.println("\nTo see the content, we access the fields:");
        // 4. To see what's *inside* the node, we use the dot operator.
        System.out.println("The data (head.ele) is: " + head.ele);
        System.out.println("The next pointer (head.next) is: " + head.next);
    }
}