package ReadWriteLock;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWDictionary {
   private final Map<String, String> map = new TreeMap<>();
   private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
   private final Lock readLock = rwLock.readLock();
   private final Lock writeLock = rwLock.writeLock();

   // A read operation, protected by the read lock
   public String get(String key) {
     readLock.lock();
     try {
       return map.get(key);
     } finally {
       readLock.unlock();
     }
   }

   // A write operation, protected by the exclusive write lock
   public String put(String key, String value) {
     writeLock.lock();
     try {
       return map.put(key, value);
     } finally {
       writeLock.unlock();
     }
   }
}