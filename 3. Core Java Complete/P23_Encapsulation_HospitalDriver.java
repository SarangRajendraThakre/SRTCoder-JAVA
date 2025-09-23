import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// ---- DATA CLASSES ----

class Patient {
    private String pname;
    private String gender;
    private String[] illness;
    private String address;

    public Patient(String pname, String gender, String[] illness, String address) {
        this.pname = pname;
        this.gender = gender;
        this.illness = illness;
        this.address = address;
    }

    // Corrected Getters
    public String getPname() { return pname; }
    public String getGender() { return gender; }
    public String[] getIllness() { return illness; }
    public String getAddress() { return address; }
}

class Doctor {
    private String name;
    private String specialization;
    private String experience;

    public Doctor(String name, String specialization, String experience) {
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
    }
    
    // Getters
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public String getExperience() { return experience; }
}

// ---- MANAGEMENT CLASS ----

class Hospital {
    private String name;
    private String type;
    private String address;
    private long contact;
    private ArrayList<Doctor> doctorList;
    private ArrayList<Patient> patientList;

    public Hospital(String name, String type, String address, long contact) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.contact = contact;
        this.doctorList = new ArrayList<>(); // Initialize lists in the constructor
        this.patientList = new ArrayList<>();
    }
    
    // Methods to manage lists
    public void addDoctor(Doctor doctor) {
        this.doctorList.add(doctor);
    }

    public void addPatient(Patient patient) {
        this.patientList.add(patient);
    }
    
    // Getters
    public String getName() { return name; }
    public String getType() { return type; }
    public String getAddress() { return address; }
    public long getContact() { return contact; }
    public ArrayList<Doctor> getDoctorList() { return doctorList; }
    public ArrayList<Patient> getPatientList() { return patientList; }
}


// ---- DRIVER CLASS ----

public class P23_Encapsulation_HospitalDriver {

    // Create ONE scanner for the whole application
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Hospital hospital = new Hospital("Sassoon General Hospital", "Multispecialty", "Pune", 1234567890L);
        
        // Infinite loop for the menu
        while (true) {
            System.out.println("\n--- Hospital Menu ---");
            System.out.println("1. Display Hospital Details");
            System.out.println("2. Add Doctor");
            System.out.println("3. Add Patient");
            System.out.println("4. View All Patients");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline character
            
            switch (choice) {
                case 1:
                    displayHospital(hospital);
                    break;
                case 2:
                    addDoctor(hospital);
                    break;
                case 3:
                    addPatient(hospital);
                    break;
                case 4:
                    viewPatients(hospital);
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close(); // Close the scanner before exiting
                    System.exit(0); // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static void displayHospital(Hospital hospital) {
        System.out.println("\n--- Hospital Information ---");
        System.out.println("Name: " + hospital.getName());
        System.out.println("Type: " + hospital.getType());
        System.out.println("Address: " + hospital.getAddress());
        System.out.println("Contact: " + hospital.getContact());
        
        System.out.println("\n--- Doctors ---");
        if (hospital.getDoctorList().isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            for (Doctor doc : hospital.getDoctorList()) {
                System.out.printf("Dr. %s (Specialty: %s, Experience: %s years)\n", 
                                  doc.getName(), doc.getSpecialization(), doc.getExperience());
            }
        }
    }
    
    public static void addDoctor(Hospital hospital) {
        System.out.println("\n--- Add New Doctor ---");
        System.out.print("Enter Doctor's Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String spec = scanner.nextLine();
        System.out.print("Enter Years of Experience: ");
        String exp = scanner.nextLine();
        
        Doctor newDoctor = new Doctor(name, spec, exp);
        hospital.addDoctor(newDoctor);
        System.out.println("Doctor added successfully!");
    }
    
    public static void addPatient(Hospital hospital) {
        System.out.println("\n--- Add New Patient ---");
        System.out.print("Enter Patient's Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Illnesses (comma-separated, e.g., Fever,Cough): ");
        String[] illnesses = scanner.nextLine().split(",");
        
        Patient newPatient = new Patient(name, gender, illnesses, address);
        hospital.addPatient(newPatient);
        System.out.println("Patient added successfully!");
    }
    
    public static void viewPatients(Hospital hospital) {
        System.out.println("\n--- Patient List ---");
        ArrayList<Patient> patientList = hospital.getPatientList();
        
        if (patientList.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        
        for (Patient p : patientList) {
            System.out.println("--------------------");
            System.out.println("Name: " + p.getPname());
            System.out.println("Gender: " + p.getGender());
            System.out.println("Address: " + p.getAddress());
            // Correctly print the array of illnesses
            System.out.println("Illnesses: " + Arrays.toString(p.getIllness()));
        }
        System.out.println("--------------------");
    }
}