package Object_Sorting;

import java.util.Arrays;
import java.util.Comparator; 

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

    // @Override
    // public int compareTo(Employee emp) {
    //     return emp.empId - this.empId;
    // }

    // // ename asc
// @Override
// public int compareTo(Employee emp) {
//     // For ascending order, return this.ename.compareTo(emp.ename)
//     return this.ename.compareTo(emp.ename);
// }


// // salary asc
// @Override
// public int compareTo(Employee emp) {
//     // For ascending order, use Double.compare(this.salary, emp.salary)
//     return Double.compare(this.salary, emp.salary);
// }

// // salary desc
@Override
public int compareTo(Employee emp) {
    // For descending order, use Double.compare(emp.salary, this.salary)
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
        System.out.println("\n--- Employees After Sorting by empId (Ascending - Natural Order) ---");
        printEmployees(employeesList);


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
}