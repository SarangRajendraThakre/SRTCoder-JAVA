package TypeCasting;

public class ShortNarrowing {
    public static void main(String[] args) {
        short s = 300; // Large value

        byte b = (byte) s; // Overflow
        char c = (char) s; // Unicode interpretation

        System.out.println("Original short: " + s);
        System.out.println("Byte: " + b);
        System.out.println("Char: " + c);
    }
}
