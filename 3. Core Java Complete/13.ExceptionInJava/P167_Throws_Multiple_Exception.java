package ExceptionInJava;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class P167_Throws_Multiple_Exception {

    public static void main(String[] args) {
        System.out.println("Main method started.");
        try {
            // Because processData() declares multiple exceptions,
            // we must handle them here.
            processData(true, true);
        } catch (IOException e) {
            // This block HANDLES the IOException.
            System.err.println("Caught an I/O Error: " + e.getMessage());
        } catch (ParseException e) {
            // This block HANDLES the ParseException.
            System.err.println("Caught a Parsing Error: " + e.getMessage());
        }
        System.out.println("Main method finished.");
    }

    /**
     * This method DECLARES that it can throw two different checked exceptions.
     * It does not handle them itself.
     */
    public static void processData(boolean throwIO, boolean throwParse) 
                                throws IOException, ParseException {
        
        System.out.println("processData started.");

        if (throwIO) {
            // Throw the first possible exception.
            throw new IOException("Could not read the device.");
        }

        if (throwParse) {
            // Throw the second possible exception.
            throw new ParseException("Date format is incorrect.", 0);
        }
        
        System.out.println("processData finished.");
    }
}