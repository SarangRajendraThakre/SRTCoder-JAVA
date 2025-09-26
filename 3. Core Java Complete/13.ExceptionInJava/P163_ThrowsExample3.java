package ExceptionInJava;


import java.io.*;

public class P163_ThrowsExample3 {
    // 'throws Exception' is required because FileWriter can throw a checked IOException.
    public static void main(String[] args) throws Exception {
        // This line attempts to create a new file named "abc.txt".
        FileWriter file = new FileWriter("abc.txt");
        // For a complete program, you would typically close the writer.
        // file.close(); 
    }
}