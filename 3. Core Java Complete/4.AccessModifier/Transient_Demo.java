import java.io.*; // Need for all I/O classes

import java.io.Serializable;
// Note: import java.io.* is implicitly required for the driver, 
// and java.io.Serializable is explicitly required here.

class BankDetails implements Serializable {
    String name;
    char gender;
    String pin;

    // Fields marked as 'transient' will NOT be serialized.
    // They will be restored to their default values (null for objects, 0 for
    // primitives)
    transient Long adhar;
    transient String panCard;

    // Constructor
    BankDetails(String name, char gender, String pin, Long adhar, String panCard) {
        this.name = name;
        this.gender = gender;
        this.pin = pin;
        this.adhar = adhar;
        this.panCard = panCard;
    }

    // toString() method to print the object state
    @Override
    public String toString() {
        return "name: " + name + ", gender: " + gender + ", pin: " + pin +
                ", adhar: " + adhar + ", pan: " + panCard;
    }
}

public class Transient_Demo {
    public static void main(String[] args) {
        // 1. Create the original object
        BankDetails obj = new BankDetails("ramesh", 'M', "123", 123456789120L, "ABCDE1234F");
        System.out.println("--- Original Object State ---");
        System.out.println(obj); // Prints initial values

        String fileName = "bank.ser";

        // // // start seril process
        // try {
        //     // Serialization: Writing the object to a file
        //     ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        //     oos.writeObject(obj);
        //     oos.close(); // Close the output stream
        //     System.out.println("\nseri process completed");
        // } catch (Exception e) {
        //     System.out.println("Exception handled (Serialization)");
        // }

        // // // de-ser
        try {
            // Deserialization: Reading the object from a file
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            BankDetails dese = (BankDetails) ois.readObject();
            ois.close(); // Close the input stream

            System.out.println("\n--- Deserialized Object State ---");
            System.out.println(dese); // Prints the deserialized object
            System.out.println("de - seri process completed");
        } catch (Exception e) {
            System.out.println("Exception handled (Deserialization)");
        }


    }
}