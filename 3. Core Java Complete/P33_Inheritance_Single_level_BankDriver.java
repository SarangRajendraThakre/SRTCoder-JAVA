
// Driver class to run the program
public class P33_Inheritance_Single_level_BankDriver {

    public static void main(String[] args) {
        // Create an object of the subclass (Customer)
        Customer customer = new Customer(
            // Arguments for the parent Bank class
            "Bank of India", 
            "Pune", 
            "Main Branch", 
            "India",
            // Arguments for the Customer class itself
            "Sarang", 
            "Wardha", 
            "Saving", 
            100000000.00
        );

        System.out.println("--- Displaying Details ---");
        
        // Calling a method from the parent class (Bank)
        customer.displayBankDetails();

        System.out.println(); // For spacing

        // Calling a method from the child class (Customer)
        customer.displayCustomerDetails();
    }
}

// The parent or superclass
class Bank {
    // Attributes of a Bank
    private String name;
    private String address;
    private String branch;
    private String country;

    // Constructor for Bank
    public Bank(String name, String address, String branch, String country) {
        this.name = name;
        this.address = address;
        this.branch = branch;
        this.country = country;
    }

    // Method to display bank details
    public void displayBankDetails() {
        System.out.println("Bank Information:");
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Branch: " + this.branch);
        System.out.println("Country: " + this.country);
    }
}

// The child or subclass
// Customer "is-a" specialized entity related to a Bank.
class Customer extends Bank {
    // Attributes specific to a Customer
    private String customerName;
    private String customerAddress;
    private String accountType;
    private double amount;

    // Constructor for Customer
    public Customer(
        // Parameters for the Bank constructor
        String bankName, String bankAddress, String branch, String country,
        // Parameters for the Customer itself
        String customerName, String customerAddress, String accountType, double amount
    ) {
        // 'super()' passes arguments to the parent (Bank) constructor.
        // This must be the first line.
        super(bankName, bankAddress, branch, country);

        // Initialize fields specific to the Customer
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.accountType = accountType;
        this.amount = amount;
    }

    // Method to display customer-specific details
    public void displayCustomerDetails() {
        System.out.println("Customer Information:");
        System.out.println("Name: " + this.customerName);
        System.out.println("Address: " + this.customerAddress);
        System.out.println("Account Type: " + this.accountType);
        System.out.println("Balance: ₹" + String.format("%,.2f", this.amount));
    }
}