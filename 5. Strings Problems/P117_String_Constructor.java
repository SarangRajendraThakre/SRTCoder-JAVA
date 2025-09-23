
//   public String(byte[] arr , int start , int count)
public class P117_String_Constructor {

    public static void main(String[] args) {

       
 
        // A byte array containing "part1_part2_part3"
        byte[] fullData = {112, 97, 114, 116, 49, 95, 112, 97, 114, 116, 50, 95, 112, 97, 114, 116, 51};

        // We want to extract only "part2"
        int offset = 6;
        int length = 5;

        // The constructor decodes the bytes from index 6 to 10
        String part2 = new String(fullData, offset, length);

        System.out.println("The extracted string is: " + part2);
    

    }
}
