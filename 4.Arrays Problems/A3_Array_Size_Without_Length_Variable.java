public class A3_Array_Size_Without_Length_Variable {

    public static void main(String[] args) {
        int [] a = {10,20,30,40,50,60,70,80,90};
        int len = 0 ;
        for(int i : a)
        {
            len++;

        }
        System.out.println(len);
    }
}