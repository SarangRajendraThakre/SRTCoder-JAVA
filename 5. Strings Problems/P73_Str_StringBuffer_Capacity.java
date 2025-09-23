
public class P73_Str_StringBuffer_Capacity {

    public static void main(String[] args) {
         


        StringBuffer sb = new StringBuffer();
   
        //  (16 + 1 )*2  = 34 
        //  (16 * 2)+2   = 34
       // (34 * 2 +2) = 70 

       
     
        for(int i =0;i<35;i++)
        {
            sb.append(i);
        }

       
        
        System.out.println(sb.capacity());
        System.out.println(sb.length());



    }
}
