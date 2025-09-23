// Main class to run the program
public class P25_Encapsulation_Composition_LaptopDriver {

    public static void main(String[] args) {
        // Create a new Laptop object
        // The constructor of Laptop will also create the Processor and GraphicCard objects
        Laptop laptop = new Laptop("Lenovo", "Black", 55000.00, "Coding Laptop");

        // Display all the details of the laptop and its components
        System.out.println("--- Laptop Specifications ---");
        laptop.displayAllDetails();
    }
}

// Represents the Laptop
class Laptop {
    // --- Attributes of Laptop ---
    private String brand;
    private String color;
    private double price;
    private String model;

    // --- Component Objects (Composition) ---
    // A Laptop "has-a" Processor and a GraphicCard
    private Processor processor;
    private GraphicCard graphicCard;

    // --- Constructor for Laptop ---
    public Laptop(String brand, String color, double price, String model) {
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.model = model;

        // Initialize the component parts inside the Laptop
        // Values are taken from your notes
        this.processor = new Processor("Intel", "i9", "13th Gen", "24-core");
        this.graphicCard = new GraphicCard("Nvidia", "RTX 4090", "24 GB");
    }

    // --- Methods ---
    // A single method to display all details neatly
    public void displayAllDetails() {
        System.out.println("Brand: " + this.brand);
        System.out.println("Model: " + this.model);
        System.out.println("Color: " + this.color);
        System.out.println("Price: ₹" + String.format("%,.2f", this.price));
        
        // Display details of the components
        this.processor.displayDetails();
        this.graphicCard.displayDetails();
    }
}

// Represents the Processor component
class Processor {
    // --- Attributes of Processor ---
    private String brand;
    private String series;
    private String generation;
    private String core;

    // --- Constructor for Processor ---
    public Processor(String brand, String series, String generation, String core) {
        this.brand = brand;
        this.series = series;
        this.generation = generation;
        this.core = core;
    }
    
    // --- Methods ---
    public void displayDetails() {
        System.out.println("Processor: " + this.brand + " " + this.series + " " + this.generation + " (" + this.core + ")");
    }
}

// Represents the Graphic Card component
class GraphicCard {
    // --- Attributes of GraphicCard ---
    private String brand;
    private String model;
    private String memory;
    
    // --- Constructor for GraphicCard ---
    public GraphicCard(String brand, String model, String memory) {
        this.brand = brand;
        this.model = model;
        this.memory = memory;
    }
    
    // --- Methods ---
    public void displayDetails() {
        System.out.println("Graphics Card: " + this.brand + " " + this.model + " with " + this.memory + " VRAM");
    }
}