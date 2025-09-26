
// Driver class to run the program
public class P34_Inheritance_Multilevel_FolderDriver {

    public static void main(String[] args) {
        // Create an object of the lowest subclass (Folder)
        Folder myFolder = new Folder(
            // Arguments for the top-level ThisPC class
            "HP Pavilion",
            "Intel i5",
            8,
            256,
            64,
            // Arguments for the mtsfghiddle Drive class
            "C:",
            "NTFS",
            500.0,
            // Arguments for the Folder class itself
            "My Docs",
            "Private",
            "2024-06-01"
        );

        System.out.println("--- Displaying All Inherited Details ---\n");

        // Calling methods from all levels of the inheritance chain
        myFolder.displayThisPCInfo();
        System.out.println();
        myFolder.displayDriveInfo();
        System.out.println();
        myFolder.displayFolderInfo();
    }
}

// Level 1: The top-level parent class
class ThisPC {
    private String pcName;
    private String processor;
    private int ram;
    private int storage;
    private int systemType; // e.g., 64-bit

    public ThisPC(String pcName, String processor, int ram, int storage, int systemType) {
        this.pcName = pcName;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.systemType = systemType;
    }

    public void displayThisPCInfo() {
        System.out.println("PC Information:");
        System.out.println("Name: " + this.pcName + ", Processor: " + this.processor);
    }
}

// Level 2: This class inherits from ThisPC
class Drive extends ThisPC {
    private String driveName; // e.g., C:
    private String driveType; // e.g., NTFS
    private double totalCap; // in GB

    public Drive(
        // Parameters for the parent (ThisPC)
        String pcName, String processor, int ram, int storage, int systemType,
        // Parameters for this class (Drive)
        String driveName, String driveType, double totalCap
    ) {
        // Pass parent parameters up the chain using super()
        super(pcName, processor, ram, storage, systemType);
        this.driveName = driveName;
        this.driveType = driveType;
        this.totalCap = totalCap;
    }

    public void displayDriveInfo() {
        System.out.println("Drive Information:");
        System.out.println("Name: " + this.driveName + ", Type: " + this.driveType + ", Capacity: " + this.totalCap + " GB");
    }
}

// Level 3: This class inherits from Drive
class Folder extends Drive {
    private String folderName;
    private String folderType; // e.g., Private, Public
    private String dateCreated;

    public Folder(
        // Parameters for the grandparent (ThisPC)
        String pcName, String processor, int ram, int storage, int systemType,
        // Parameters for the parent (Drive)
        String driveName, String driveType, double totalCap,
        // Parameters for this class (Folder)
        String folderName, String folderType, String dateCreated
    ) {
        // Pass parameters up to the immediate parent (Drive) constructor
        super(pcName, processor, ram, storage, systemType, driveName, driveType, totalCap);
        this.folderName = folderName;
        this.folderType = folderType;
        this.dateCreated = dateCreated;
    }

    public void displayFolderInfo() {
        System.out.println("Folder Information:");
        System.out.println("Name: " + this.folderName + ", Type: " + this.folderType + ", Created: " + this.dateCreated);
    }
}