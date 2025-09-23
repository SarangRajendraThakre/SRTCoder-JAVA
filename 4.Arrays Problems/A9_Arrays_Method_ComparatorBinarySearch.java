import java.util.Arrays;
import java.util.Comparator;

public class A9_Arrays_Method_ComparatorBinarySearch {
    public static void main(String[] args) {

        // --- Setup ---
        Student[] students = {
            new Student(105, "Rohan"),
            new Student(101, "Amit"),
            new Student(103, "Priya")
        };

        // --- Define Custom Sorting Logic ---
        // We create a Comparator that compares Students based on their name.
        // A lambda expression is a clean, modern way to do this.
        Comparator<Student> nameComparator = Comparator.comparing(Student::getName);

        // --- The Golden Rule: Sort using the Comparator ---
        System.out.println("Original array: " + Arrays.toString(students));
        Arrays.sort(students, nameComparator);
        System.out.println("Sorted by name: " + Arrays.toString(students));
        System.out.println("----------------------------------------");


        // --- Search using the SAME Comparator ---
        // The key object only needs the relevant field for the comparator to work.
        // Here, the comparator only cares about the name "Rohan".
        Student keyToFind = new Student(0, "Rohan");

        System.out.println("Searching for a student with name: \"" + keyToFind.getName() + "\"");

        // Call the binarySearch with the array, key, and custom comparator
        int foundIndex = Arrays.binarySearch(students, keyToFind, nameComparator);

        if (foundIndex >= 0) {
            System.out.println("Success! Found a match at index: " + foundIndex);
            System.out.println("The matching object is: " + students[foundIndex]);
        } else {
            System.out.println("Failure! The student was not found.");
            System.out.println("The method returned: " + foundIndex);
        }
        
    }
}

// Student class with id and name fields, constructor, getters, and toString
class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}