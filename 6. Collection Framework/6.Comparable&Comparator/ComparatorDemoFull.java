import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Employee {
        String name;
        int age;
        double salary;
        String department;

        Employee(String name, int age, double salary, String department) {
                this.name = name;
                this.age = age;
                this.salary = salary;
                this.department = department;
        }

        public String getName() {
                return name;
        }

        public int getAge() {
                return age;
        }

        public double getSalary() {
                return salary;
        }

        public String getDepartment() {
                return department;
        }

        @Override
        public String toString() {
                return name + " | " + age + " | " + salary + " | " + department;
        }
}

public class ComparatorDemoFull {
        public static void main(String[] args) {

                List<Employee> employees = Arrays.asList(
                                new Employee("Alice", 30, 70000, "HR"),
                                new Employee("Bob", 25, 50000, null),
                                new Employee("David", 40, 80000, "Finance"),
                                new Employee("Charlie", 30, 60000, "IT"),
                                new Employee(null, 35, 55000, "HR"), // name null
                                new Employee("Eve", 25, 50000, "IT")

                );

                System.out.println("1. Comparing by name (null-safe, natural order):");
                employees.stream()
                                .sorted(Comparator.comparing(
                                                Employee::getName,
                                                Comparator.nullsLast(Comparator.naturalOrder())))
                                .forEach(System.out::println);

                System.out.println("\n2. Comparing by age using comparingInt:");
                employees.stream()
                                .sorted(Comparator.comparingInt(Employee::getAge))
                                .forEach(System.out::println);

                System.out.println("\n3. Comparing by salary using comparingDouble, reversed:");
                employees.stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                .forEach(System.out::println);

                System.out.println("\n4. Comparing by department (nulls first) then name (nulls last):");
                employees.stream()
                                .sorted(
                                                Comparator.comparing(
                                                                Employee::getDepartment,
                                                                Comparator.nullsFirst(Comparator.naturalOrder()))
                                                                .thenComparing(
                                                                                Employee::getName,
                                                                                Comparator.nullsLast(Comparator
                                                                                                .naturalOrder())))
                                .forEach(System.out::println);

                System.out.println("\n5. Custom comparator: age descending using comparing with Comparator:");
                employees.stream()
                                .sorted(Comparator.comparing(Employee::getAge, Comparator.reverseOrder()))
                                .forEach(System.out::println);

                System.out.println("\n6. Combining thenComparingInt and thenComparingDouble:");
                employees.stream()
                                .sorted(
                                                Comparator.comparingInt(Employee::getAge)
                                                                .thenComparingDouble(Employee::getSalary))
                                .forEach(System.out::println);

                System.out.println("\n7. Natural order on Comparable objects (works for Strings):");
                try {
                        List<String> names = Arrays.asList("Bob", "Alice", "Charlie");
                        names.stream()
                                        .sorted(Comparator.naturalOrder())
                                        .forEach(System.out::println);
                } catch (Exception e) {
                        System.out.println("Fails for non-Comparable objects: " + e);
                }

                System.out.println("\n8. Reverse order on Comparable objects:");
                List<String> names = Arrays.asList("Bob", "Alice", "Charlie");
                names.stream()
                                .sorted(Comparator.reverseOrder())
                                .forEach(System.out::println);

                System.out.println("\n9. Chaining multiple thenComparing with primitives and null-safe keys:");
                employees.stream()
                                .sorted(
                                                Comparator.comparing(Employee::getDepartment,
                                                                Comparator.nullsFirst(Comparator.naturalOrder()))
                                                                .thenComparingInt(Employee::getAge)
                                                                .thenComparingDouble(Employee::getSalary)
                                                                .thenComparing(Employee::getName,
                                                                                Comparator.nullsLast(Comparator
                                                                                                .naturalOrder())))
                                .forEach(System.out::println);

                System.out.println("\n10. Comparator.equals demonstration (tricky interview):");
                Comparator<Employee> c1 = Comparator.comparingInt(Employee::getAge);
                Comparator<Employee> c2 = Comparator.comparingInt(Employee::getAge);
                System.out.println("c1.equals(c2)? " + c1.equals(c2)); // usually false

                // System.out.println("\n11. What is NOT allowed (tricky interview):");
                // try {
                // employees.stream()
                // .sorted(Comparator.naturalOrder()) // NPE if Employee is not Comparable
                // .forEach(System.out::println);
                // } catch (Exception e) {
                // System.out.println("Fails: Employee must implement Comparable to use
                // naturalOrder(): " + e);
                // }

                System.out.println("\n12. Null-safe primitive sorting (int/double) is always safe:");
                employees.stream()
                                .sorted(Comparator.comparingInt(Employee::getAge)
                                                .thenComparingDouble(Employee::getSalary))
                                .forEach(System.out::println);

                System.out.println("\n--- Demo Complete: All Comparator methods covered safely ---");
        }
}



// https://chatgpt.com/c/68d8c77c-7844-8328-9877-66ccda11c216