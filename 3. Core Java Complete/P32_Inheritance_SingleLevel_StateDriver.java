


// Driver class to run the program
public class P32_Inheritance_SingleLevel_StateDriver {

    public static void main(String[] args) {
        // Create an object of the subclass (State)
        // This object will have properties from both State and its parent, Country.
        State state = new State(
            // Arguments for the Country superclass
            "India", 
            "Hindi", 
            1400000000L, 
            "Narendra Modi", 
            "Rupee", 
            3287263.0, 
            28,
            // Arguments for the State class itself
            "Maharashtra", 
            "Marathi", 
            "Mumbai", 
            "Eknath Shinde", 
            12345678L, 
            307713.0, 
            36
        );

        System.out.println("--- Displaying Details ---");
        // Calling a method from the parent class (Country)
        state.displayCountryDetails();
        
        System.out.println(); // For spacing
        
        // Calling a method from the child class (State)
        state.displayStateDetails();
    }
}

// The parent or superclass
class Country {
    // --- Attributes of Country ---
    private String name;
    private String language;
    private long population;
    private String primeMinister;
    private String currency;
    private double area; // Area in sq km
    private int numberOfStates;

    // --- Constructor for Country ---
    public Country(String name, String language, long population, String primeMinister, String currency, double area, int numberOfStates) {
        this.name = name;
        this.language = language;
        this.population = population;
        this.primeMinister = primeMinister;
        this.currency = currency;
        this.area = area;
        this.numberOfStates = numberOfStates;
    }

    // --- Method to display Country details ---
    public void displayCountryDetails() {
        System.out.println("Country Information:");
        System.out.println("Name: " + this.name);
        System.out.println("Official Language: " + this.language);
        System.out.println("Population: " + this.population);
        System.out.println("Prime Minister: " + this.primeMinister);
        System.out.println("Currency: " + this.currency);
    }
}

// The child or subclass
// "State" extends "Country", inheriting all its fields and methods.
class State extends Country {
    // --- Attributes specific to State ---
    // No need to redeclare fields like name or population from Country
    private String stateName;
    private String stateLanguage;
    private String capital;
    private String chiefMinister;
    private long statePopulation;
    private double stateArea;
    private int numberOfDistricts;

    // --- Constructor for State ---
    public State(
        // Parameters for the Country constructor
        String countryName, String countryLanguage, long countryPopulation, String pm, String currency, double countryArea, int numStates,
        // Parameters for the State itself
        String stateName, String stateLanguage, String capital, String cm, long statePopulation, double stateArea, int numDistricts
    ) {
        // The 'super()' call passes arguments up to the parent (Country) constructor.
        // This is the first thing that must be done in a child class constructor.
        super(countryName, countryLanguage, countryPopulation, pm, currency, countryArea, numStates);
        
        // Initialize the fields specific to the State class
        this.stateName = stateName;
        this.stateLanguage = stateLanguage;
        this.capital = capital;
        this.chiefMinister = cm;
        this.statePopulation = statePopulation;
        this.stateArea = stateArea;
        this.numberOfDistricts = numDistricts;
    }

    // --- Method to display State-specific details ---
    public void displayStateDetails() {
        System.out.println("State Information:");
        System.out.println("Name: " + this.stateName);
        System.out.println("Capital: " + this.capital);
        System.out.println("Chief Minister: " + this.chiefMinister);
        System.out.println("Language: " + this.stateLanguage);
        System.out.println("Population: " + this.statePopulation);
    }
}