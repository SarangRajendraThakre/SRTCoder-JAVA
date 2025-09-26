

// Driver class to run the program
public class P37_Inheritance_Hierarchical_GoogleDriver {
    public static void main(String[] args) {
        // 1. Create a base Google account
        Google account = new Google("sarang", "sarang@gmail.com", "pass123", "Male", 9876543210L);

        // 2. Use the account to create a Google Classroom (Room)
        System.out.println("--- Setting up Google Classroom ---");
        Room classroom = new Room(account, "Core Java", "Mr. Ramesh");
        classroom.displayGoogleInfo(); // Inherited method
        classroom.displayRoomInfo();   // Own method
        System.out.println();

        // 3. Use the same account to set up Google Pay
        System.out.println("--- Setting up Google Pay ---");
        GooglePay gPay = new GooglePay(account, "sarang-gpay", 1234);
        
        // Add a bank account to Google Pay (Aggregation)
        gPay.addBank("State Bank of India", "SBIN0011", 987654321L);
        System.out.println();
        
        gPay.displayGoogleInfo(); // Inherited method
        gPay.displayGPayInfo();   // Own method
    }
}

// Level 1: The parent class
class Google {
    private String name;
    private String email;
    private String password;
    private String gender;
    private long contact;

    public Google(String name, String email, String password, String gender, long contact) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.contact = contact;
    }

    protected String getName() {
        return name;
    }

    protected String getEmail() {
        return email;
    }

    protected String getPassword() {
        return password;
    }

    protected String getGender() {
        return gender;
    }

    protected long getContact() {
        return contact;
    }

    public void displayGoogleInfo() {
        System.out.println("Google Account Holder: " + this.name + " (" + this.email + ")");
    }
}

// An independent class to be used by GooglePay
class Bank {
    private String bName;
    private String ifsc;
    private long accountNumber;

    public Bank(String bName, String ifsc, long accountNumber) {
        this.bName = bName;
        this.ifsc = ifsc;
        this.accountNumber = accountNumber;
    }

    public void displayBankInfo() {
        System.out.println("Bank: " + this.bName + " | IFSC: " + this.ifsc + " | Account: " + this.accountNumber);
    }
}

// Child class 1: Inherits from Google
class Room extends Google {
    private String roomName;
    private String subject;
    private String teacher;
    private String roomCode;
    private String link;

    public Room(Google googleAccount, String subject, String teacher) {
        // Call parent constructor with details from the base Google account
        super(googleAccount.getName(), googleAccount.getEmail(), googleAccount.getPassword(), googleAccount.getGender(), googleAccount.getContact());
        this.subject = subject;
        this.teacher = teacher;
        this.roomName = subject + " Room";
        this.roomCode = "RM" + (int)(Math.random() * 10000);
        this.link = "https://classroom.google.com/" + this.roomCode;
    }

    public void displayRoomInfo() {
        System.out.println("Classroom: " + this.roomName + " (Taught by: " + this.teacher + ")");
        System.out.println("Join Link: " + this.link);
    }
}

// Child class 2: Inherits from Google
class GooglePay extends Google {
    private String upiId;
    private int upiPin;
    // Aggregation: GooglePay "has-a" Bank
    private Bank bank;

    public GooglePay(Google googleAccount, String upiId, int upiPin) {
        // Call parent constructor with details from the base Google account
        super(googleAccount.getName(), googleAccount.getEmail(), googleAccount.getPassword(), googleAccount.getGender(), googleAccount.getContact());
        this.upiId = upiId;
        this.upiPin = upiPin;
    }
    // Method to associate a Bank object
    public void addBank(String bName, String ifsc, long accountNumber) {
        this.bank = new Bank(bName, ifsc, accountNumber);
        System.out.println("Bank account successfully added to Google Pay.");
    }

    public void displayGPayInfo() {
        System.out.println("Google Pay UPI ID: " + this.upiId);
        if (this.bank != null) {
            this.bank.displayBankInfo();
        } else {
            System.out.println("No bank account linked.");
        }
    }
}