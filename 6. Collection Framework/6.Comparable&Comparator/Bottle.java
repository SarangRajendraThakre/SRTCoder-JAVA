import java.util.Objects;

public class Bottle implements Comparable<Bottle> {

    private final String brand;
    private final int capacity;
    private final String material;

    public Bottle(String brand, int capacity, String material) {
        this.brand = brand;
        this.capacity = capacity;
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Bottle{" +
                "brand='" + brand + '\'' +
                ", capacity=" + capacity + "ml" +
                ", material='" + material + '\'' +
                '}';
    }

    @Override
    public int compareTo(Bottle other) {

        int capacityComparison = Integer.compare(this.capacity, other.capacity);

        if (capacityComparison != 0) {
            return capacityComparison;
        }

        return this.brand.compareTo(other.brand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Bottle bottle = (Bottle) o;
        return capacity == bottle.capacity &&
                Objects.equals(brand, bottle.brand) &&
                Objects.equals(material, bottle.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, capacity, material);
    }
}