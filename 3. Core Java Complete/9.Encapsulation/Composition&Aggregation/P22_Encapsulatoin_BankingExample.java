


import java.util.Scanner;

/**
 * The Account class holds data for a single bank account.
 * It does NOT extend Bank.
 */
class Account {
    // All fields are private to protect the data (encapsulation)6
    private String customerName;
    private String accountType;
    private String address;
    private int pin;
    private double balance;

    // Constructor to initialize the account details
    public Account(String customerName, String accountType, String address, int pin, double balance) {
        this.customerName = customerName;
        this.accountType = accountType;
        this.address = address;
        this.pin = pin;
        this.balance = balance;
        System.out.println("Account for " + this.customerName + " created successfully!");
    }

    // Public "getter" methods to access private data safely
    public double getBalance() {
        return this.balance;
    }

    public int getPin() {
        return this.pin;
    }
}

/**
 * The Bank class manages the bank's information and contains the account.
 */
class Bank {
    // Static fields belong to the class, not a specific bank instance
    private static final String BANK_NAME = "SBI";
    private static final String IFSC = "SBIN0123";

    // A Bank "has an" Account (Composition)
    private Account account;

    // Method to create and associate an account with this bank
    public void createAccount() {
        // In a real app, this data would come from user input or a database
        this.account = new Account("Ramesh", "Saving", "Pune", 123, 100000.0);
        System.out.println("Account created at " + BANK_NAME + " (IFSC: " + IFSC + ")");
    }

    // A method within Bank to securely check the balance
    public void checkBalance(int inputPin) {
        // Check if an account exists first
        if (this.account == null) {
            System.out.println("No account has been created yet.");
            return;
        }

        // The Bank validates the PIN against its account
        if (inputPin == this.account.getPin()) {
            System.out.println("PIN Accepted!");
            // Using printf for formatted output
            System.out.printf("Available Balance:", this.account.getBalance());
        } else {
            System.out.println("Invalid PIN. Please try again.");
        }
    }
}

/**
 * The Main class to run the program.
 */
public class P22_Encapsulatoin_BankingExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Create a Bank instance
        Bank sbi_branch = new Bank();
        
        // 2. The bank creates an account for a customer
        sbi_branch.createAccount();

        // 3. Prompt user for PIN
        System.out.print("\nWelcome! Please enter your PIN to check balance: ");
        int enteredPin = scanner.nextInt();
        
        // 4. The bank handles the balance check request
        sbi_branch.checkBalance(enteredPin);

        scanner.close(); // Good practice to close the scanner
    }
}