


// Driver class to run the program
public class P36_Inheritance_Hierarchical_MsOfficeDriver {

    public static void main(String[] args) {
        // --- Create independent File objects first ---
        File pptFile = new File("Meeting Deck", "pptx", 5.2, "22-June-2025");
        File excelFile = new File("Sales Report", "xlsx", 1.8, "20-July-2025");

        // --- Create application objects, passing in the File objects (Aggregation) ---
        PowerPoint ppt = new PowerPoint("sarang@example.com", "sarang", "pass123", pptFile, 25, "Fade In");

        Excel excel = new Excel(
                "sarang@abc.com", "Shama", "pass456",
                excelFile, "Q2 Sales", "Sales Data"
        );

        // --- Create another child object from the same parent ---
        Outlook outlook = new Outlook(
                "sarang@example.com", "sarang", "pass123",
                "sarang@my-company.com", "My Company Inc."
        );

        // --- Demonstrate Hierarchical Inheritance ---
        System.out.println("--- PowerPoint Details ---");
        ppt.displayAppInfo(); // Inherited method
        ppt.displayPowerPoint(); // Own method
        System.out.println();

        System.out.println("--- Excel Details ---");
        excel.displayAppInfo(); // Inherited method
        excel.displayExcel();   // Own method
        System.out.println();
        
        System.out.println("--- Outlook Details ---");
        outlook.displayAppInfo(); // Inherited method
        outlook.displayOutlook(); // Own method
    }
}

// Level 1: The parent class
class MSOffice {
    private String email;
    private String username;
    private String password;

    public MSOffice(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public void displayAppInfo() {
        System.out.println("MS Office Account: " + this.username + " (" + this.email + ")");
    }
}

// Represents a file, to be used by other classes
class File {
    private String fileName;
    private String fileType;
    private double fileSize; // in MB
    private String createdDate;

    public File(String fileName, String fileType, double fileSize, String createdDate) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.createdDate = createdDate;
    }

    public void displayFile() {
        System.out.println("File: " + this.fileName + "." + this.fileType + " (" + this.fileSize + " MB)");
    }
}

// Child class 1: Inherits from MSOffice
class PowerPoint extends MSOffice {
    // Aggregation: PowerPoint "has-a" File
    private File file;
    private int slides;
    private String animation;

    public PowerPoint(String email, String username, String password, File file, int slides, String animation) {
        super(email, username, password); // Call parent constructor
        this.file = file;
        this.slides = slides;
        this.animation = animation;
    }

    public void displayPowerPoint() {
        this.file.displayFile();
        System.out.println("Slides: " + this.slides + ", Animation: " + this.animation);
    }
}

// Child class 2: Inherits from MSOffice
class Excel extends MSOffice {
    // Aggregation: Excel "has-a" File
    private File file;
    private String sheet;
    private String title;

    public Excel(String email, String username, String password, File file, String sheet, String title) {
        super(email, username, password); // Call parent constructor
        this.file = file;
        this.sheet = sheet;
        this.title = title;
    }

    public void displayExcel() {
        this.file.displayFile();
        System.out.println("Sheet: " + this.sheet + ", Title: " + this.title);
    }
}

// Child class 3: Inherits from MSOffice
class Outlook extends MSOffice {
    private String mailId;
    private String company;

    public Outlook(String email, String username, String password, String mailId, String company) {
        super(email, username, password); // Call parent constructor
        this.mailId = mailId;
        this.company = company;
    }

    public void displayOutlook() {
        System.out.println("Outlook Mail ID: " + this.mailId + " (" + this.company + ")");
    }
}