

// Driver class to run the program
public class P35_Inheritance_Multilevel_ProfessorDriver {

    public static void main(String[] args) {
        // Create an object of the lowest subclass, Professor
        Professor prof = new Professor(
            // University details
            "Global University", "Pune", "Private", 12,
            // Faculty details
            "Engineering", "Dr. Smith", 6, "Block B",
            // Professor details
            "Dr. Soham", "Computer Science", 15, "A-203"
        );

        System.out.println("--- Displaying All Inherited Details ---\n");
        
        // Calling methods from each level of the inheritance chain
        prof.displayUniversity();
        System.out.println();
        prof.displayFaculty();
        System.out.println();
        prof.displayProfessor();
    }
}

// Level 1: The top-level base class
class University {
    private String uniName;
    private String location;
    private String type;
    private int ranking;

    public University(String uniName, String location, String type, int ranking) {
        this.uniName = uniName;
        this.location = location;
        this.type = type;
        this.ranking = ranking;
    }

    public void displayUniversity() {
        System.out.println("University Information:");
        System.out.println("Name: " + this.uniName + ", Location: " + this.location);
    }
}

// Level 2: Inherits from University
class Faculty extends University {
    private String facultyName; // e.g., Engineering, Arts
    private String dean;
    private int departments;
    private String building;

    public Faculty(
        // Parameters for University
        String uniName, String location, String type, int ranking,
        // Parameters for Faculty
        String facultyName, String dean, int departments, String building
    ) {
        super(uniName, location, type, ranking); // Call parent constructor
        this.facultyName = facultyName;
        this.dean = dean;
        this.departments = departments;
        this.building = building;
    }

    public void displayFaculty() {
        System.out.println("Faculty Information:");
        System.out.println("Name: " + this.facultyName + ", Dean: " + this.dean);
    }
}

// Level 3: Inherits from Faculty
class Professor extends Faculty {
    private String profName;
    private String specialization;
    private int experience;
    private String officeRoom;

    public Professor(
        // Parameters for University
        String uniName, String location, String type, int ranking,
        // Parameters for Faculty
        String facultyName, String dean, int departments, String building,
        // Parameters for Professor
        String profName, String specialization, int experience, String officeRoom
    ) {
        super(uniName, location, type, ranking, facultyName, dean, departments, building); // Call parent constructor
        this.profName = profName;
        this.specialization = specialization;
        this.experience = experience;
        this.officeRoom = officeRoom;
    }

    public void displayProfessor() {
        System.out.println("Professor Information:");
        System.out.println("Name: " + this.profName + ", Specialization: " + this.specialization);
        System.out.println("Experience: " + this.experience + " years, Office: " + this.officeRoom);
    }
}