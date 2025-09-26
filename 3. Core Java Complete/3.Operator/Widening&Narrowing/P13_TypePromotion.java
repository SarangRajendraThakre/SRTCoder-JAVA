public class P13_TypePromotion {

    public static void main(String args[]){

        byte a = 10 ;
        byte b = 20;        // its range is 127 but 

        int result = a*b;         // here want happen is type promotion

        System.out.println(result);


    }
    
}
