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

    // ✅ Comparable: only ONE natural ordering (by rollNo here)
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.rollNo, other.rollNo);
    }

    @Override
    public String toString() {
        return rollNo + " - " + name + " - " + age;
    }
}

public class P3_ComparableVsComparatorDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(103, "Sarang", 22));
        students.add(new Student(101, "Raj", 21));
        students.add(new Student(102, "Priya", 23));

        // ✅ Using Comparable (always sorts by rollNo, fixed)
        Collections.sort(students);
        System.out.println("Sorted by rollNo (Comparable):");
        students.forEach(System.out::println);

        // ✅ Using Comparator (sort by name)
        students.sort(Comparator.comparing(s -> s.name));
        System.out.println("\nSorted by name (Comparator):");
        students.forEach(System.out::println);

        // ✅ Using Comparator (sort by age)
        students.sort(Comparator.comparingInt(s -> s.age));
        System.out.println("\nSorted by age (Comparator):");
        students.forEach(System.out::println);

        // ✅ Using Comparator (sort by age then name)
        students.sort(
            Comparator.comparingInt((Student s) -> s.age)
                      .thenComparing(s -> s.name)
        );
        System.out.println("\nSorted by age then name (Comparator):");
        students.forEach(System.out::println);
    }
}
