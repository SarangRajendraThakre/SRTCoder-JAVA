import java.util.Arrays;
import java.util.Comparator;

// A custom class for our example
class Student {
    String name;
    int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "{" + name + ", Roll: " + rollNo + "}";
    }
}

public class  A9_Arrays_Method_binarySearch_CustomSubArraySearch {
    public static void main(String[] args) {

        // 1. An array of Student objects
        Student[] students = {
            new Student("Ravi", 105),
            new Student("Priya", 102),
            new Student("Amit", 108),
            new Student("Sonia", 101),
            new Student("Vikram", 106)
        };

        // 2. Define a custom comparator to sort and search by roll number
        Comparator<Student> rollNoComparator = Comparator.comparingInt(s -> s.rollNo);

        // 3. IMPORTANT: Sort the array using the same comparator
        Arrays.sort(students, rollNoComparator);
        
        System.out.println("Sorted Array: " + Arrays.toString(students));
        System.out.println("-----------------------------------------------------------------");

        // 4. Define the search range: from index 1 to 4 (exclusive)
        // This sub-array is: [{Priya, Roll: 102}, {Ravi, Roll: 105}, {Vikram, Roll: 106}]
        int fromIndex = 1;
        int toIndex = 4;
        System.out.printf("Searching in range from index %d (inclusive) to %d (exclusive).\n\n", fromIndex, toIndex);
        
        // --- Search for a student with roll number 105 (who is in the range) ---
        // The 'key' can be a dummy object with the roll number we want.
        Student searchKey = new Student("dummy", 105);
        
        int result = Arrays.binarySearch(
            students,           // The array
            fromIndex,          // Start index
            toIndex,            // End index
            searchKey,          // The key to find
            rollNoComparator    // The logic to use for comparison
        );

        System.out.printf("Searching for a student with Roll No %d...\n", searchKey.rollNo);
        if (result >= 0) {
            System.out.println("Found: " + students[result] + " at original index " + result);
        } else {
            System.out.println("Student not found in the specified range.");
        }
    }
}