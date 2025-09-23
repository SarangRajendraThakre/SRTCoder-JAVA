package TypeCasting;

public class CharNarrowing {


   
        public static void main(String[] args) {
            char c = 255;  // Large Unicode value
    
            int i = (int) c;       // No issue
            short s = (short) c;   // Overflow if > 32767
            byte b = (byte) c;     // Overflow if > 127
    
            System.out.println("Original char: " + c);
            System.out.println("Int: " + i);
            System.out.println("Short: " + s);
            System.out.println("Byte: " + b);
        }
    
    
    
}
