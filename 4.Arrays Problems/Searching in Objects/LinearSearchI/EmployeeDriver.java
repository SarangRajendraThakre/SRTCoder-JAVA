
import java.util.Arrays;

class Employee implements Comparable<Employee> {
    int empId;
    String ename;
    String depart;
    double salary;

    public Employee(int empId, String ename, String depart, double salary) {
        super();
        this.empId = empId;
        this.ename = ename;
        this.depart = depart;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee[empId=" + empId + ", ename=" + ename + ", depart=" + depart + ", salary=" + salary + "]";
    }

    @Override
    public int compareTo(Employee emp) {
        return Double.compare(emp.salary, this.salary);
    }
}

public class EmployeeDriver {

    public static void main(String[] args) {

        Employee[] employeesList = new Employee[4];
        employeesList[0] = new Employee(12343, "Sarang Thakre", "HR", 5000);
        employeesList[1] = new Employee(1236, "Rajendra Thakre", "HR", 500);
        employeesList[2] = new Employee(143235, "Vidya Thakre", "HR", 56500);
        employeesList[3] = new Employee(1237, "Yadnesh Thakre", "HR", 500000);

        System.out.println("--- Employees Before Any Sorting ---");
        printEmployees(employeesList);

        Arrays.sort(employeesList);
        System.out.println("\n--- Employees After Sorting by Salary (Descending - Natural Order) ---");
        printEmployees(employeesList);

        System.out.println("\n--- Performing Linear Searches ---");

        int searchId = 143235;
        System.out.println("\nSearching for Employee with empId: " + searchId);
        Employee foundEmployeeById = linearSearchById(employeesList, searchId);
        if (foundEmployeeById != null) {
            System.out.println("Found: " + foundEmployeeById);
        } else {
            System.out.println("Employee with empId " + searchId + " not found.");
        }

        String searchName = "Sarang Thakre";
        System.out.println("\nSearching for Employee with ename: " + searchName);
        Employee foundEmployeeByName = linearSearchByName(employeesList, searchName);
        if (foundEmployeeByName != null) {
            System.out.println("Found: " + foundEmployeeByName);
        } else {
            System.out.println("Employee with ename '" + searchName + "' not found.");
        }

        int nonExistentId = 99999;
        System.out.println("\nSearching for Employee with empId: " + nonExistentId);
        Employee notFoundEmployee = linearSearchById(employeesList, nonExistentId);
        if (notFoundEmployee != null) {
            System.out.println("Found: " + notFoundEmployee);
        } else {
            System.out.println("Employee with empId " + nonExistentId + " not found.");
        }
    }

    public static void printEmployees(Employee[] employees) {
        if (employees == null) {
            System.out.println("Employee list is null.");
            return;
        }
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static Employee linearSearchById(Employee[] employees, int empId) {
        if (employees == null) {
            return null;
        }
        for (Employee employee : employees) {
            if (employee.empId == empId) {
                return employee;
            }
        }
        return null;
    }

    public static Employee linearSearchByName(Employee[] employees, String ename) {
        if (employees == null) {
            return null;
        }
        for (Employee employee : employees) {
            if (employee.ename.equals(ename)) {
                return employee;
            }
        }
        return null;
    }
}