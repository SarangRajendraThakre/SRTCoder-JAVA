import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * A comprehensive demonstration of all static and default methods available
 * in the java.util.Comparator interface, commonly used with Stream sorting.
 */
public class Comparator_StreamApi {

    // --- 1. Demo Class ---
    static class Employee implements Comparable<Employee> {
        String name;
        int age;
        double salary;
        String department; // Can be null for null-handling demos

        public Employee(String name, int age, double salary, String department) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public double getSalary() { return salary; }
        public String getDepartment() { return department; }

        @Override
        public int compareTo(Employee other) {
            // Implements natural ordering based on name
            return this.name.compareTo(other.name);
        }

        @Override
        public String toString() {
            return String.format("%-10s (Age: %2d, Dept: %-10s, Salary: $%.0f)", 
                name, age, department != null ? department : "N/A", salary);
        }
    }

    // --- 2. Main Demonstration Method ---
    public static void main(String[] args) {
        // Sample Data: Includes null objects and objects with null fields for edge cases
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, 70000.0, "HR"),
            new Employee("Charlie", 25, 55000.0, "IT"),
            new Employee("Bob", 40, 95000.0, "Sales"),
            new Employee("Eve", 30, 80000.0, "HR"),
            new Employee("David", 22, 50000.0, null), // Null department
            null, // Null object in the list
            new Employee("Fiona", 40, 100000.0, "Sales")
        );

        System.out.println("--- Comparator Method Demonstrations ---");
        
        // --- SECTION A: Key Extraction Methods (The 'comparing...' family) ---
        
        System.out.println("\n[A1] comparing(Function) - Natural Ordering on Key (String):");
        // Sort by Name (String is Comparable). This is the most common use case.
        Comparator<Employee> byName = Comparator.comparing(Employee::getName);
        printSorted(employees.stream().filter(Objects::nonNull), byName);

        // Tricky Interview Note: This uses Integer's compareTo, which involves boxing.
        System.out.println("\n[A2] comparingInt(ToIntFunction) - Primitive Key Efficiency (Age):");
        // Sort by Age (int). Efficient: avoids boxing/unboxing the 'age' primitive.
        Comparator<Employee> byAge = Comparator.comparingInt(Employee::getAge);
        printSorted(employees.stream().filter(Objects::nonNull), byAge);

        System.out.println("\n[A3] comparingDouble(ToDoubleFunction) - Primitive Key Efficiency (Salary):");
        // Sort by Salary (double). Efficient: avoids boxing/unboxing the 'salary' primitive.
        Comparator<Employee> bySalary = Comparator.comparingDouble(Employee::getSalary);
        printSorted(employees.stream().filter(Objects::nonNull), bySalary);
        
        System.out.println("\n[A4] comparing(Function, Comparator) - Custom Comparator for Key:");
        // Sort by Department using a custom, case-insensitive comparator for the key (String).
        Comparator<Employee> byDeptCustom = Comparator.comparing(
            Employee::getDepartment, 
            String.CASE_INSENSITIVE_ORDER.reversed() // Custom comparator for the String key
        );
        printSorted(employees.stream().filter(Objects::nonNull), byDeptCustom);


        // --- SECTION B: Natural Order Methods ---

        System.out.println("\n[B1] naturalOrder() - Requires Class to implement Comparable:");
        // Uses the compareTo method implemented in the Employee class (sorts by name).
        Comparator<Employee> natural = Comparator.naturalOrder();
        printSorted(employees.stream().filter(Objects::nonNull), natural);

        System.out.println("\n[B2] reverseOrder() - Reverse of Natural Order:");
        // Uses the reverse of the compareTo method (sorts by name descending).
        Comparator<Employee> reverseNatural = Comparator.reverseOrder();
        printSorted(employees.stream().filter(Objects::nonNull), reverseNatural);
        
        
        // --- SECTION C: Null Handling Methods (Critical Interview Case) ---

        System.out.println("\n[C1] nullsFirst(Comparator) - Null Objects are First:");
        // Tricky Case: Handles null *Employee objects* in the list, then sorts non-nulls by Age.
        Comparator<Employee> nullsFirstAge = Comparator.nullsFirst(byAge);
        printSorted(employees.stream(), nullsFirstAge); // Note: We don't filter out nulls here

        System.out.println("\n[C2] nullsLast(Comparator) - Null Objects are Last:");
        // Tricky Case: Handles null *Employee objects* in the list, then sorts non-nulls by Name.
        Comparator<Employee> nullsLast = Comparator.nullsLast(byName);
        printSorted(employees.stream(), nullsLast); // Note: We don't filter out nulls here


        // --- SECTION D: Chaining Methods (The 'thenComparing...' family) ---

        System.out.println("\n[D1] thenComparingInt(ToIntFunction) + reversed() - Multi-level Sort:");
        // 1. Sort by Age (Ascending)
        // 2. Then by Salary (Descending, using reversed())
        Comparator<Employee> complexSort = Comparator
            .comparingInt(Employee::getAge) // Primary sort: Age ASC
            .thenComparingDouble(Employee::getSalary).reversed(); // Secondary sort: Salary DESC
        
        List<Employee> nonNullEmployees = employees.stream().filter(Objects::nonNull).collect(Collectors.toList());
        printSorted(nonNullEmployees.stream(), complexSort);


        System.out.println("\n[D2] thenComparing(Function) - Secondary Sort on Comparable Key:");
        // 1. Sort by Department (ASC)
        // 2. Then by Name (ASC)
        Comparator<Employee> deptThenName = Comparator
            .comparing(Employee::getDepartment, Comparator.nullsLast(Comparator.naturalOrder())) // Handle null department fields
            .thenComparing(Employee::getName);
            
        printSorted(nonNullEmployees.stream(), deptThenName);
        

        System.out.println("\n[D3] thenComparing(Comparator) - Secondary Sort using another Comparator:");
        // 1. Sort by Name (ASC, using comparing(Function))
        // 2. Then by the Age Comparator defined in [A2]
        Comparator<Employee> nameThenAge = byName.thenComparing(byAge);
        printSorted(nonNullEmployees.stream(), nameThenAge);
        
        
        // --- SECTION E: equals(Object) Demo ---
        
        // Tricky Interview Case: When are two Comparators equal? 
        // Typically, Comparators are only equal if they are the exact same instance 
        // or if they are from a known class (like Collections.reverseOrder()) that overrides equals.
        // The default implementation simply checks reference equality (==).
        System.out.println("\n[E] equals(Object) - Checking Equality (Reference Check by default):");
        Comparator<Employee> byName_copy = Comparator.comparing(Employee::getName);
        System.out.println("byName == byName_copy: " + (byName == byName_copy)); // false, different objects
        System.out.println("byName.equals(byName_copy): " + byName.equals(byName_copy)); // false, default implementation uses ==
        System.out.println("Comparator.naturalOrder().equals(natural): " + Comparator.naturalOrder().equals(natural)); // true (often returns a singleton instance)
    }

    /**
     * Helper method to print the sorted list.
     */
    private static void printSorted(java.util.stream.Stream<Employee> stream, Comparator<Employee> comparator) {
        stream
            .sorted(comparator)
            .forEach(e -> System.out.println("  " + e));
    }
}
