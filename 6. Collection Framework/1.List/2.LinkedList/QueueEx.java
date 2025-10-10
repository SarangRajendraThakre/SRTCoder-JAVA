import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
    public static void main(String[] args) {
        // Create a Queue of Integers using LinkedList
        Queue<Integer> list = new LinkedList<>();

        // Add numbers from 10 to 100 with step 10
        for (int i = 10; i <= 100; i += 10) {
            list.add(i);   // add() always returns true, so no need to print it
        }

        // Print the queue
        System.out.println("Queue elements: " + list);

        // Demonstrating queue operations
        System.out.println("Head of queue (peek): " + list.peek());  // shows first element
        System.out.println("Removed from queue (poll): " + list.poll()); // removes first element
        System.out.println("Queue after removal: " + list);
    }
}