import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class IdentityHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        // --- IdentityHashMap demo ---
        System.out.println("=== IdentityHashMap Demo ===");
        Map<String, String> identityMap = new IdentityHashMap<>();

        String key1 = new String("hello");
        String key2 = new String("hello"); // same content, different object

        identityMap.put(key1, "World1");
        identityMap.put(key2, "World2"); // treated as different key

        System.out.println("IdentityHashMap size: " + identityMap.size());
        System.out.println(identityMap);

        // --- WeakHashMap demo ---
        System.out.println("\n=== WeakHashMap Demo ===");
        Map<String, String> weakMap = new WeakHashMap<>();

        String weakKey1 = new String("key1");
        String weakKey2 = new String("key2");

        weakMap.put(weakKey1, "Value1");
        weakMap.put(weakKey2, "Value2");

        System.out.println("Before GC: " + weakMap);

        // Remove strong references
        weakKey1 = null;
        weakKey2 = null;

        // Suggest JVM to run Garbage Collector
        System.gc();
        Thread.sleep(1000); // wait a bit for GC

        System.out.println("After GC: " + weakMap);
    }
}
