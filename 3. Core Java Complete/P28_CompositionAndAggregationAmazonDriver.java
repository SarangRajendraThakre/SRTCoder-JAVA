import java.util.ArrayList;
import java.util.List;

// Main driver class to simulate the e-commerce flow
public class P28_CompositionAndAggregationAmazonDriver {

    public static void main(String[] args) {
        // 1. A customer arrives
        Customer customer = new Customer("Sarang", "Sarang@gmail.com", 9975558296L);
        customer.displayCustomer();

        // 2. Customer sets their address and payment method
        customer.addAddress("JM Road", "Pune", "MH", 412311);
        customer.addCard("Sarang", "Bank of India", "88155578910", "12/29", 123);
        System.out.println("\nAddress on file: " + customer.getAddress());

        // 3. Customer adds products to their cart
        System.out.println("\n--- Adding Products to Cart ---");
        customer.addProduct("Running Shoes", "Comfortable running shoes, size 10.", 2500.00);
        customer.addProduct("Laptop Sleeve", "Padded sleeve for 15-inch laptops.", 999.00);

        // 4. Display the contents of the cart
        System.out.println("\n--- Items in Cart ---");
        for (Product product : customer.getCart()) {
            product.displayProduct();
            System.out.println("-----");
        }

        // 5. Customer proceeds to checkout
        customer.checkout();
    }
}

// Represents a customer
class Customer {
    private String name;
    private String email;
    private long contact;

    // AGGREGATION: Customer "has-an" Address. The Address is an independent object.
    private Address address;

    // AGGREGATION: Customer "has-a" Card. The Card is an independent object.
    private Card card;

    // AGGREGATION: The cart "has" Products. The Products exist independently of the
    // cart.
    private List<Product> cart;

    public Customer(String name, String email, long contact) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        // The ArrayList itself is created here, so the Customer owns its own cart list.
        this.cart = new ArrayList<>();
    }

    public void addAddress(String locality, String city, String state, int pincode) {
        this.address = new Address(locality, city, state, pincode);
    }

    public void addCard(String name, String bankName, String cardNumber, String expDate, int cvv) {
        this.card = new Card(name, bankName, cardNumber, expDate, cvv);
    }

    public void addProduct(String name, String desc, double price) {
        Product product = new Product(name, desc, price);
        this.cart.add(product);
        System.out.println("'" + name + "' added to cart.");
    }

    public void checkout() {
        if (cart.isEmpty() || address == null || card == null) {
            System.out.println(
                    "\nCheckout failed. Please ensure you have items in your cart, an address, and a payment method on file.");
            return;
        }
        System.out.println("\n--- Proceeding to Payment ---");
        Payment payment = new Payment();
        Bill bill = payment.proceedPayment(this.cart, this.card);
        bill.displayBill();
    }

    // Getters
    public Address getAddress() {
        return this.address;
    }

    public List<Product> getCart() {
        return this.cart;
    }

    public void displayCustomer() {
        System.out.println("Customer: " + this.name + " (" + this.email + ")");
    }
}

// Represents a product
// Represents a product
class Product {
    private static int idCounter = 123;
    private String pid;
    private String name;
    private String desc;
    private double price;

    public Product(String name, String desc, double price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.pid = "AMZ" + idCounter++;
    }

    // GETTER: A public method to safely access the private 'name' field
    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void displayProduct() {
        System.out.println("Product ID: " + this.pid);
        System.out.println("Name: " + this.name);
        System.out.println("Description: " + this.desc);
        System.out.println("Price: ₹" + String.format("%,.2f", this.price));
    }
}

// Represents a payment card
class Card {
    private String name;
    private String bankName;
    private String cardNumber;
    private String expDate;
    private int cvv;

    public Card(String name, String bankName, String cardNumber, String expDate, int cvv) {
        this.name = name;
        this.bankName = bankName;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    public void displayCard() {
        // Mask the card number for security
        String maskedCardNumber = "************" + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("\nPayment Method:");
        System.out.println("Cardholder: " + this.name);
        System.out.println("Card: " + maskedCardNumber);
    }
}

// Represents a customer's address
class Address {
    private String locality;
    private String city;
    private String state;
    private int pincode;

    public Address(String locality, String city, String state, int pincode) {
        this.locality = locality;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return locality + ", " + city + ", " + state + " - " + pincode;
    }
}

// Handles the payment process
class Payment {
    public Bill proceedPayment(List<Product> cart, Card card) {
        double totalBill = 0;
        for (Product product : cart) {
            totalBill += product.getPrice();
        }
        card.displayCard();

        // COMPOSITION: A 'Bill' is created and owned by the payment process.
        // Its lifecycle is dependent on this process; a bill can't exist without a
        // payment.
        return new Bill(cart, totalBill);
    }
}

// Represents the final bill/invoice
class Bill {
    private static long invoiceCounter = 12314557814L;
    private long invoiceNumber;
    private double totalAmount;
    private List<Product> products;

    public Bill(List<Product> products, double totalAmount) {
        this.products = products;
        this.totalAmount = totalAmount;
        this.invoiceNumber = invoiceCounter++;
    }

    public void displayBill() {
        System.out.println("\n--- Payment Successful ---");
        System.out.println("Invoice #: " + this.invoiceNumber);
        System.out.println("\nItems Purchased:");
        for (Product p : products) {
            System.out.println("- " + p.getName() + " (₹" + String.format("%,.2f", p.getPrice()) + ")");
        }
        System.out.println("\nTotal Bill: ₹" + String.format("%,.2f", this.totalAmount));
    }
}