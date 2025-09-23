
public class P104_finding_no_of_Element_Without_Length {

    public static void main(String[] args) {
        // Your code here

        int[] arr = {21,5,6,5,3,46,5,43,34,45,46,454,5,4,54};
        int cnt = 0;

        for(int ele : arr)
        {
            cnt++;
        }
        System.out.println(cnt);


        int cnt1=0;
        try {
            while (true) {
                
               
               int ele = arr[++cnt1];
               
            }
            
        } catch (Exception e) {
              System.out.println("out of bound ");
        }

        System.out.println(cnt1);



    }
}
