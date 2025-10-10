import java.util.*;

class Student implements Comparable<Student> {
    int rollNo;
    String name;
    int age;

    Student(int rollNo, String name, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
    }

    // Comparable: Natural order = by rollNo
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.rollNo, other.rollNo);
    }

    @Override
    public String toString() {
        return rollNo + " - " + name + " - " + age;
    }
}

public class ComparatorLambdaDemo {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student(103, "Sarang", 22),
            new Student(101, "Raj", 21),
            new Student(102, "Priya", 23)
        );

        // ✅ Comparable (by rollNo)
        Collections.sort(students);
        System.out.println("Sorted by rollNo (Comparable):");
        students.forEach(System.out::println);

        // ✅ Comparator using Lambda (by name)
        students.sort((s1, s2) -> s1.name.compareTo(s2.name));
        System.out.println("\nSorted by name (Lambda):");
        students.forEach(System.out::println);

        // ✅ Comparator using Method Reference (by age)
        students.sort(Comparator.comparingInt(s -> s.age));
        System.out.println("\nSorted by age (Method Reference):");
        students.forEach(System.out::println);

        // ✅ Comparator using Chaining (by age then name)
        students.sort(Comparator.comparingInt((Student s) -> s.age)
                                .thenComparing(s -> s.name));
        System.out.println("\nSorted by age then name (Chaining):");
        students.forEach(System.out::println);
    }
}
