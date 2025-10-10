import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + salary + ")";
    }
}

public class TreeSetCustomDemo {
    public static void main(String[] args) {
        // Comparator to order by id
        Comparator<Employee> byId = Comparator.comparingInt(e -> e.id);

        TreeSet<Employee> employees = new TreeSet<>(byId);

        // add()
        employees.add(new Employee(101, "Alice", 50000));
        employees.add(new Employee(105, "Bob", 60000));
        employees.add(new Employee(103, "Charlie", 55000));
        employees.add(new Employee(102, "David", 70000));

        System.out.println("Original TreeSet: " + employees);

        // addAll()
        List<Employee> newList = Arrays.asList(
                new Employee(106, "Eva", 65000),
                new Employee(104, "Frank", 48000)
        );
        employees.addAll(newList);
        System.out.println("After addAll: " + employees);

        // ceiling()
        System.out.println("Ceiling of id=103: " +
                employees.ceiling(new Employee(103, "X", 0)));

        // floor()
        System.out.println("Floor of id=103: " +
                employees.floor(new Employee(103, "X", 0)));

        // higher()
        System.out.println("Higher than id=103: " +
                employees.higher(new Employee(103, "X", 0)));

        // lower()
        System.out.println("Lower than id=103: " +
                employees.lower(new Employee(103, "X", 0)));

        // first() and last()
        System.out.println("First: " + employees.first());
        System.out.println("Last: " + employees.last());

        // headSet
        System.out.println("headSet(<104): " +
                employees.headSet(new Employee(104, "X", 0)));
        System.out.println("headSet(<=104): " +
                employees.headSet(new Employee(104, "X", 0), true));

        // tailSet
        System.out.println("tailSet(>=103): " +
                employees.tailSet(new Employee(103, "X", 0)));
        System.out.println("tailSet(>103): " +
                employees.tailSet(new Employee(103, "X", 0), false));

        // subSet
        System.out.println("subSet(102..105): " +
                employees.subSet(new Employee(102, "X", 0),
                        true,
                        new Employee(105, "X", 0),
                        true));

        // contains
        System.out.println("Contains id=101? " +
                employees.contains(new Employee(101, "X", 0)));

        // size
        System.out.println("Size: " + employees.size());

        // iterator
        System.out.print("Ascending Iterator: ");
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " | ");
        }
        System.out.println();

        // descendingIterator
        System.out.print("Descending Iterator: ");
        Iterator<Employee> dit = employees.descendingIterator();
        while (dit.hasNext()) {
            System.out.print(dit.next() + " | ");
        }
        System.out.println();

        // descendingSet
        System.out.println("Descending Set View: " + employees.descendingSet());

        // pollFirst and pollLast
        System.out.println("pollFirst(): " + employees.pollFirst());
        System.out.println("pollLast(): " + employees.pollLast());
        System.out.println("After pollFirst & pollLast: " + employees);

        // clone
        TreeSet<Employee> cloned = (TreeSet<Employee>) employees.clone();
        System.out.println("Cloned TreeSet: " + cloned);

        // clear
        employees.clear();
        System.out.println("After clear: " + employees);

        // isEmpty
        System.out.println("Is empty? " + employees.isEmpty());
    }
}
