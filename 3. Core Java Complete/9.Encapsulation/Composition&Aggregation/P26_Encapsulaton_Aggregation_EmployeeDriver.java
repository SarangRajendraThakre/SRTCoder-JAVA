/**
 * The Address class is the "part". 
 * It can exist independently.
 */
class Address {
    String city;
    String state;
    String pincode;

    public Address(String city, String state, String pincode) {
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    // A method to display address details
    public void displayAddress() {
        System.out.println("City: " + city + ", State: " + state + ", Pincode: " + pincode);
    }
}

/**
 * The Employee class is the "whole". 
 * It "has an" Address.
 */
class Employee {
    int empId;
    String name;
    Address address; // Aggregation: Employee has an Address

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
        // Notice the Address is NOT created here
    }

    // This is the "helper method" your notes mention.
    // It links an existing Address object to this employee.
    public void addAddress(Address address) {
        this.address = address;
    }

    public void displayEmployeeDetails() {
        System.out.println("--- Employee Details ---");
        System.out.println("ID: " + empId + ", Name: " + name);
        if (address != null) {
            System.out.print("Address: ");
            address.displayAddress(); // Calls method on the "part" object
        } else {
            System.out.println("Address: Not provided.");
        }
    }
}


public class P26_Encapsulaton_Aggregation_EmployeeDriver {
    public static void main(String[] args) {
        // 1. Create Address objects. They exist on their own.
        Address address1 = new Address("Wardha", "Maharashtra", "442001");
        Address address2 = new Address("Nagpur", "Maharashtra", "440001");

        // 2. Create Employee objects.
        Employee emp1 = new Employee(101, "Aarav");
        Employee emp2 = new Employee(102, "Diya");

        // 3. Use the helper method to associate an address with an employee.
        emp1.addAddress(address1);
        emp2.addAddress(address2);

        // Display details
        emp1.displayEmployeeDetails();
        System.out.println();
        emp2.displayEmployeeDetails();
    }
}