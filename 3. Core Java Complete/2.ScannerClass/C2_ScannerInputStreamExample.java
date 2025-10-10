import java.util.Scanner;

public class C2_ScannerInputStreamExample {
    public static void main(String[] args) {

        // Scanner(InputStream source)
        // Purpose:
        // Creates a Scanner that reads input from an InputStream, such as keyboard
        // input (System.in) or any other input stream.

        Scanner sc = new Scanner(System.in); // InputStream is System.in

        System.out.print("Enter your name: ");
        String name = sc.nextLine(); // reads a line

        System.out.print("Enter your age: ");
        int age = sc.nextInt(); // reads an integer

        System.out.println("Name: " + name + ", Age: " + age);

        sc.close(); // always close the scanner
    }
}
