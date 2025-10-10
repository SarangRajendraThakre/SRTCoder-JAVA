import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class HashMapVsWeakHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        // --- HashMap demo ---
        Map<String, String> hashMap = new HashMap<>();
        String hashKey = new String("hashKey");
        hashMap.put(hashKey, "HashMapValue");

        System.out.println("HashMap before nulling key: " + hashMap);
        hashKey = null; // Remove strong reference

        System.gc();
        Thread.sleep(1000); // Wait a bit for GC

        System.out.println("HashMap after GC: " + hashMap);
        System.out.println("HashMap size: " + hashMap.size());

        // --- WeakHashMap demo ---
        Map<String, String> weakMap = new WeakHashMap<>();
        String weakKey = new String("weakKey");
        weakMap.put(weakKey, "WeakMapValue");

        System.out.println("\nWeakHashMap before nulling key: " + weakMap);
        weakKey = null; // Remove strong reference

        System.gc();
        Thread.sleep(1000); // Wait a bit for GC

        System.out.println("WeakHashMap after GC: " + weakMap);
        System.out.println("WeakHashMap size: " + weakMap.size());
    }
}
