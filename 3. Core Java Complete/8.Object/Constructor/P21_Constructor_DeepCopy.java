// File: P21_Constructor_DeepCopy.java

class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public Department(Department other) {
        this.name = other.name;
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

class Employee {
    private int id;
    private Department department;

    public Employee(int id, Department department) {
        this.id = id;
        this.department = department;
    }

    public Employee(Employee otherEmployee) {
        this.id = otherEmployee.id;
        this.department = new Department(otherEmployee.department);
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", department=" + department + "]";
    }
}

// NOTE: This line is clean and has no invalid characters.
public class P21_Constructor_DeepCopy {
    public static void main(String[] args) {
        Department hr = new Department("Human Resources");
        Employee originalEmployee = new Employee(101, hr);
        Employee copiedEmployee = new Employee(originalEmployee);

        System.out.println("--- Initial State ---");
        System.out.println("Original: " + originalEmployee);
        System.out.println("Copied:   " + copiedEmployee);
        System.out.println();

        System.out.println("--- Modifying department via copied object... ---");
        copiedEmployee.getDepartment().setName("Admin");
        System.out.println();

        System.out.println("--- Final State (Deep Copy) ---");
        System.out.println("Original: " + originalEmployee);
        System.out.println("Copied:   " + copiedEmployee);
    }
}