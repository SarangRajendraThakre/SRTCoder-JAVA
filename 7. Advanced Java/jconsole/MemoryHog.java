package jconsole;

import java.util.ArrayList;
import java.util.List;

public class MemoryHog {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("MemoryHog application started. PID: " + ProcessHandle.current().pid());
        List<byte[]> memory = new ArrayList<>();
        long counter = 0;

        while (true) {
            // Allocate a small chunk of memory
            memory.add(new byte[1024 * 1024]); // Allocate 1MB
            counter++;

            if (counter % 10 == 0) {
                System.out.println("Allocated " + (counter) + " MB.");
            }

            // Simulate some CPU activity and give GC a chance
            if (counter % 50 == 0) {
                System.out.println("Triggering a small pause and potential GC...");
                Thread.sleep(100); // Pause for 100ms
            } else {
                Thread.sleep(10); // Small pause to not overwhelm
            }

            // Optional: Reduce memory intermittently to see GC effect more clearly
            if (counter % 100 == 0 && memory.size() > 50) {
                System.out.println("Releasing some memory (clearing half list)...");
                List<byte[]> temp = new ArrayList<>(memory.subList(memory.size() / 2, memory.size()));
                memory.clear();
                memory.addAll(temp); // Keep half
            }
        }
    }
}