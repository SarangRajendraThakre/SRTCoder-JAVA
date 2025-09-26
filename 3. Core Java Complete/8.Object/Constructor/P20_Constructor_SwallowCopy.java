


class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department [name=" + name + "]";
    }
}


// Main class with a copy constructor
class Employee {
    private int id;
    private Department department; // Reference to another object

    // Standard constructor
    public Employee(int id, Department department) {
        this.id = id;
        this.department = department;
    }

    // Copy constructor for a SHALLOW copy
    public Employee(Employee otherEmployee) {
        this.id = otherEmployee.id;
        // This copies the reference, not the actual department object.
        this.department = otherEmployee.department;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", department=" + department + "]";
    }
}


// Main class to demonstrate the shallow copy
public class  P20_Constructor_SwallowCopy { 
    public static void main(String[] args) {
        // 1. Create an original employee object
        Department hr = new Department("Human Resources");
        Employee originalEmployee = new Employee(101, hr);

        // 2. Create a copy using the copy constructor
        Employee copiedEmployee = new Employee(originalEmployee);

        System.out.println("--- Initial State ---");
        System.out.println("Original: " + originalEmployee);
        System.out.println("Copied:   " + copiedEmployee);
        System.out.println();

        // 3. Modify the department name using the COPIED employee
        System.out.println("--- Modifying department via copied object... ---");
        copiedEmployee.getDepartment().setName("Admin");
        System.out.println();

        // 4. The change is reflected in BOTH objects because they share the same department object
        System.out.println("--- Final State ---");
        System.out.println("Original: " + originalEmployee);
        System.out.println("Copied:   " + copiedEmployee);
    }
}