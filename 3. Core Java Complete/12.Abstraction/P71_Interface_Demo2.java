
// Define the interface
interface vehicle {
    void vehicleType();
    void seatingCapacity();
    void topSpeed();
    void fuelType();
}

// Implement the interface for a Car
class car implements vehicle {
    @Override
    public void vehicleType() {
        System.out.println("This is swift dzire");
    }

    @Override
    public void seatingCapacity() {
        System.out.println("4 people can seatt");
    }

    @Override
    public void topSpeed() {
        System.out.println("The speed is 100km/hr");
    }

    @Override
    public void fuelType() {
        System.out.println("The Diesel is required");
    }
}

// Implement the interface for a Bike
class bike implements vehicle {
    @Override
    public void vehicleType() {
        System.out.println("it is Blue Dream yuga");
    }

    @Override
    public void seatingCapacity() {
        System.out.println("2 peoples can seatt");
    }

    @Override
    public void topSpeed() {
        System.out.println("The speed is 60km/hr");
    }

    @Override
    public void fuelType() {
        System.out.println("It requires petrol");
    }
}

// Main class to run the code
public class P71_Interface_Demo2 {
    public static void main(String[] args) {
        // Create a car object using the vehicle interface
        vehicle v = new car();
        v.vehicleType();
        v.seatingCapacity();
        v.topSpeed();
        v.fuelType();

        // Create a bike object using the vehicle interface
        vehicle v1 = new bike();
        v1.vehicleType();
        v1.seatingCapacity();
        v1.topSpeed();
        v1.fuelType();
    }
}