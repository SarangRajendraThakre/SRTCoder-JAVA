package TypeCasting;

public class IntNarrowing {
    


        public static void main(String[] args) {
            int i = 8000;  // Original int value
    
            char c = (char) i;     // Narrowing to char
            short s = (short) i;   // Narrowing to short
            byte b = (byte) i;     // Narrowing to byte
    
            // Printing results
            System.out.println("Original int: " + i);
            System.out.println("Char: " + c); // Unicode character of 800
            System.out.println("Short: " + s); // No overflow (800 is within short range)
            System.out.println("Byte: " + b);  // Overflow (800 is out of byte range)
        }
    
    
    
}
