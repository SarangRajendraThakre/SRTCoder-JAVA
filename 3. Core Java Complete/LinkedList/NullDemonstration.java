public class NullDemonstration {

    // The Node class is defined inside for this example
    private static class Node<E> {
        E ele;
        Node<E> next;

        public Node(E ele) {
            this.ele = ele;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // 1. We declare the 'head' variable but DON'T create a new Node.
        //    So, its value is null.
        Node<String> head = null;

        System.out.println("The variable 'head' is currently: " + head);
        System.out.println("Now, let's try to access head.ele...");

        // 2. This is where the error will happen.
        try {
            // This line will throw a NullPointerException
            System.out.println(head.ele);
        } catch (NullPointerException e) {
            System.out.println("\n--- CRASH! ---");
            System.out.println("Caught the expected error: NullPointerException.");
            System.out.println("This proves that when 'head' is null, it has no '.ele' or '.next' fields to access.");
        }
    }
}