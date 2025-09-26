package ExceptionInJava;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.concurrent.*;

public class P104_AllCheckedExceptionsFinalDemo {

    public static void main(String[] args) {
        System.out.println("--- Final Demonstration of All Checked Exceptions ---");

        // I/O Exceptions
        handleIOException();
        handleFileNotFoundException();
        handleEOFException();
        
        // SQL Exceptions
        handleSQLException();
        
        // Concurrency Exceptions
        handleInterruptedException();
        handleTimeoutException();
        
        // Reflection & Class Loading Exceptions
        handleClassNotFoundException();
        handleNoSuchMethodException();
        handleNoSuchFieldException();
        handleInstantiationException();
        handleIllegalAccessException();
        
        // Miscellaneous
        handleCloneNotSupportedException(); // This is now corrected

        System.out.println("\n--- All demos have concluded. ---");
    }

    // --- I/O EXCEPTIONS ---

    public static void handleIOException() {
        System.out.println("\n1. Demo: IOException");
        try (Reader reader = new UnreadableReader()) {
            reader.read();
        } catch (IOException e) {
            System.err.println("CAUGHT: " + e.getMessage());
        }
    }

    public static void handleFileNotFoundException() {
        System.out.println("\n2. Demo: FileNotFoundException");
        try {
            new FileReader("this_file_does_not_exist.txt");
        } catch (FileNotFoundException e) {
            System.err.println("CAUGHT: The system cannot find the file specified.");
        }
    }
    
    public static void handleEOFException() {
        System.out.println("\n3. Demo: EOFException");
        try (DataInputStream dis = new DataInputStream(new ByteArrayInputStream(new byte[0]))) {
            dis.readInt();
        } catch (EOFException e) {
            System.err.println("CAUGHT: Reached end of file unexpectedly.");
        } catch (IOException e) {
            System.err.println("Caught a general IO Exception: " + e.getMessage());
        }
    }

    // --- DATABASE (SQL) EXCEPTIONS ---

    public static void handleSQLException() {
        System.out.println("\n4. Demo: SQLException");
        try {
            DriverManager.getConnection("jdbc:mysql://localhost/fakedb", "user", "pass");
        } catch (SQLException e) {
            System.err.println("CAUGHT: Could not connect to the database. " + e.getMessage());
        }
    }

    // --- CONCURRENCY AND THREADING EXCEPTIONS ---

    public static void handleInterruptedException() {
        System.out.println("\n5. Demo: InterruptedException");
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.err.println("CAUGHT (in thread): Sleep was interrupted!");
            }
        });
        t.start();
        t.interrupt();
    }

    public static void handleTimeoutException() {
        System.out.println("\n6. Demo: TimeoutException");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000);
            return "Done";
        });

        try {
            future.get(100, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            System.err.println("CAUGHT: The operation timed out before completion.");
        } catch (Exception e) {
            System.err.println("Caught another exception: " + e.getClass().getSimpleName());
        }
        executor.shutdownNow();
    }

    // --- REFLECTION AND CLASS LOADING EXCEPTIONS ---

    public static void handleClassNotFoundException() {
        System.out.println("\n7. Demo: ClassNotFoundException");
        try {
            Class.forName("com.nonexistent.MyFakeClass");
        } catch (ClassNotFoundException e) {
            System.err.println("CAUGHT: The specified class definition was not found.");
        }
    }
    
    public static void handleNoSuchMethodException() {
        System.out.println("\n8. Demo: NoSuchMethodException");
        try {
            String.class.getMethod("aMethodThatDoesNotExist");
        } catch (NoSuchMethodException e) {
            System.err.println("CAUGHT: The requested method does not exist.");
        }
    }
    
    public static void handleNoSuchFieldException() {
        System.out.println("\n9. Demo: NoSuchFieldException");
        try {
            String.class.getField("aFieldThatDoesNotExist");
        } catch (NoSuchFieldException e) {
            System.err.println("CAUGHT: The requested field does not exist.");
        }
    }

    public static void handleInstantiationException() {
        System.out.println("\n10. Demo: InstantiationException");
        try {
            Constructor<Runnable> constructor = Runnable.class.getConstructor();
            constructor.newInstance();
        } catch (Exception e) {
            System.err.println("CAUGHT: " + e.getClass().getSimpleName() + " - Cannot create an instance of an interface/abstract class.");
        }
    }

    public static void handleIllegalAccessException() {
        System.out.println("\n11. Demo: IllegalAccessException");
        try {
            Field field = String.class.getDeclaredField("value");
            field.get("hello");
        } catch (Exception e) {
            System.err.println("CAUGHT: " + e.getClass().getSimpleName() + " - Cannot access a private member.");
        }
    }
    
    // --- MISCELLANEOUS (CORRECTED) ---
    
    public static void handleCloneNotSupportedException() {
        System.out.println("\n12. Demo: CloneNotSupportedException");
        NonCloneableObject obj = new NonCloneableObject();
        try {
            // This call is now valid for the compiler, but will fail at runtime.
            obj.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("CAUGHT: This object's class does not implement the Cloneable interface.");
        }
    }
}

// --- HELPER CLASSES ---

/** Helper class for IOException demo */
class UnreadableReader extends Reader {
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        throw new IOException("This reader is intentionally broken.");
    }
    @Override
    public void close() throws IOException {}
}

/** Helper class for the corrected CloneNotSupportedException demo */
class NonCloneableObject {
    // We override clone() to make it public, satisfying the compiler.
    @Override
    public Object clone() throws CloneNotSupportedException {
        // The call to super.clone() will fail at runtime because this class
        // does not implement the marker interface 'Cloneable'.
        return super.clone();
    }
}