package TypeCasting;

public class LongNarrowing {

        public static void main(String[] args) {
            long l = 100000;  // Original long value
    
            int i = (int) l;       // Narrowing to int
            char c = (char) l;     // Narrowing to char
            short s = (short) l;   // Narrowing to short
            byte b = (byte) l;     // Narrowing to byte
    
            // Printing results
            System.out.println("Original long: " + l);
            System.out.println("Int: " + i);
            System.out.println("Char: " + c); // May show an unknown character if out of ASCII range
            System.out.println("Short: " + s); // Possible overflow if l > 32767
            System.out.println("Byte: " + b);  // Possible overflow if l > 127 or < -128
        }
     
    
}
