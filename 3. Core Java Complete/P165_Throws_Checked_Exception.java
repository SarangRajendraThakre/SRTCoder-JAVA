
import java.io.FileReader;
import java.util.HashMap;
import java.util.Set;
import java.io.FileNotFoundException;

public class  P165_Throws_Checked_Exception {

    public static void main(String[] args) {
        // Because readFile() is declared with 'throws', we MUST handle it here.
        try {
            readFile("my_file.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Error: The file could not be found.");
            // e.printStackTrace();
        }
    }

   
    public static void readFile(String fileName) throws FileNotFoundException {
        System.out.println("Attempting to open: " + fileName);
        // This line causes the compiler error if 'throws' is removed.
        FileReader reader = new FileReader(fileName);
        System.out.println("File opened successfully.");
    }
     

    HashMap s = new HashMap<>();
}
