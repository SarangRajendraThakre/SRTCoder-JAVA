
public class P190_StringBuffer {

    public static void main(String[] args) {
        // Your code here

        // StringBuffer sb = new StringBuffer();
        // sb.append("Sarang");

        // // sb.delete(3, 4);
        // // System.out.println(sb);

        // sb.delete(0, 2);
        // System.out.println(sb);

        // Create a StringBuffer with a default capacity of 16
        StringBuffer sb = new StringBuffer();

        // Append a short string
        sb.append("Hi");

        // The length is 2, but the capacity is still 16
        System.out.println("Length: " + sb.length()); // Output: Length: 2
        System.out.println("Capacity: " + sb.capacity()); // Output: Capacity: 16

        // Trim the capacity to match the length
        sb.trimToSize();

        // The length is still 2, but the capacity is now also 2
        System.out.println("Length after trim: " + sb.length()); // Output: Length after trim: 2
        System.out.println("Capacity after trim: " + sb.capacity()); // Output: Capacity after trim: 2
    }
}