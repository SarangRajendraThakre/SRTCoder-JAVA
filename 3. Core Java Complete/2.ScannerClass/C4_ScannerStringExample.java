import java.util.Scanner;

public class C4_ScannerStringExample {
    public static void main(String[] args) {
        String text = "Java Python C++";

        // Scanner(String source)
        // Purpose:
        // Creates a Scanner that reads input from a String instead of a file or input
        // stream.
        // Useful for parsing text stored in memory.

        Scanner sc = new Scanner(text);

        while (sc.hasNext()) {
            System.out.println(sc.next());
        }

        sc.close();
    }
}
