import java.util.Scanner;

// The main public class. The file must be named Flipkart.java
public class P16_Flipkart {

    // Main method to start the program execution
    public static void main(String[] args) {
        Product prod = new Product("Duster", 100.0);
        P16_Flipkart flipkartApp = new P16_Flipkart();
        flipkartApp.checkout(prod);
    }

    // Method to handle the checkout process
    public void checkout(Product prod) {
        Payment payment = null;

        System.out.println("Select a payment option:");
        System.out.println("1. PhonePe\n2. Google Pay\n3. Paytm\n4. Cash on Delivery");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        // Using a switch statement to handle user's choice
        switch (option) {
            case 1:
                payment = new PhonePe(prod);
                payment.checkPaymentOption(payment);
                break;
            case 2:
                payment = new GooglePay(prod);
                payment.checkPaymentOption(payment);
                break;
            case 3:
                payment = new Paytm(prod);
                payment.checkPaymentOption(payment);
                break;
            case 4:
                System.out.println("Keep your cash ready!");
                break;
            default:
                System.out.println("Invalid option selected.");
                break;
        }
        scanner.close();
    }
}

// ---- Supporting Classes (cannot be public in this file) ----

class Product {
    String pid = "FLRT123";
    String pname;
    double price;

    public Product(String pname, double price) {
        super(); // Added automatically!
        this.pname = pname;
        this.price = price;
    }

    public void displayProduct() {
        System.out.println("Product ID: " + pid);
        System.out.println("Product Name: " + pname);
        System.out.println("Price: $" + price);
    }
}

class User {
    String username = "Sarang Thakre";
    String emailId = "Sarang@gmail.com";
    long contact = 9975558296L;

    public void displayUser() {
        System.out.println("Username: " + username);
        System.out.println("Email: " + emailId);
        System.out.println("Contact: " + contact);
    }
}

// Abstract parent class for all payment types
abstract class Payment extends User {
    Product prod;

    // This method uses 'instanceof' and downcasting to call the right method
    public void checkPaymentOption(Payment payment) {
        if (payment instanceof PhonePe) {
            System.out.println("Redirecting to PhonePe...");
            PhonePe obj = (PhonePe) payment; // Downcasting
            obj.paymentOption();
        } else if (payment instanceof GooglePay) {
            System.out.println("Redirecting to Google Pay...");
            GooglePay obj = (GooglePay) payment; // Downcasting
            obj.paymentOption();
        } else if (payment instanceof Paytm) {
            System.out.println("Redirecting to Paytm...");
            Paytm obj = (Paytm) payment; // Downcasting
            obj.paymentOption();
        }
    }

    // Abstract method that all subclasses must implement
    public abstract void paymentOption();
}

// Concrete implementation for PhonePe
class PhonePe extends Payment {
    public PhonePe(Product prod) {
        this.prod = prod;
    }

    @Override
    public void paymentOption() {
        System.out.println("---------------------------");
        displayUser();
        System.out.println("User has selected PhonePe for:");
        prod.displayProduct();
        System.out.println("---------------------------");
    }
}

// Concrete implementation for GooglePay
class GooglePay extends Payment {
    public GooglePay(Product prod) {
        this.prod = prod;
    }

    @Override
    public void paymentOption() {
        System.out.println("---------------------------");
        displayUser();
        System.out.println("User has selected Google Pay for:");
        prod.displayProduct();
        System.out.println("---------------------------");
    }
}

// Concrete implementation for Paytm
class Paytm extends Payment {
    public Paytm(Product prod) {
        this.prod = prod;
    }

    @Override
    public void paymentOption() {
        System.out.println("---------------------------");
        displayUser();
        System.out.println("User has selected Paytm for:");
        prod.displayProduct();
        System.out.println("---------------------------");
    }
}