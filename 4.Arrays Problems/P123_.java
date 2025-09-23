
public class P123_ {

    public static void main(String[] args) {
        // Your code here

        int[] arr = new int[10];

        fib(10);


    }
    public static void fib(int no)
    {
        int a = 0 ;
        int b = 1;
        int fib =0;
        while ( no  > fib ) {
                 System.out.println(a);
          fib = a+b;
        a = b ;
        b= fib;
   

        }
    

       

        
    }
}
