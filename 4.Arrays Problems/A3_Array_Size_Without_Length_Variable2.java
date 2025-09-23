

public class A3_Array_Size_Without_Length_Variable2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int leng = 0;
        
        for (int i = 0; ; i++) {
            try
            {
                leng++;
            } 
            catch (ArrayIndexOutOfBoundsException e)
            {
                break;
            }
        }
        
        System.out.println(); 
        System.out.println("Length of array : " + leng);
    }
}