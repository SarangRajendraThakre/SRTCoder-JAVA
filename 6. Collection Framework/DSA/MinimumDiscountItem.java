import java.util.*;

public class MinimumDiscountItem {



    public static void main(String[] args) {
        

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int minDiscount = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for(int i =0  ;i<n;i++)
        {
            String[] input = sc.nextLine().split(",");
            String name  = input[0].trim();
            int price   = Integer.parseInt(input[1].trim());
            int discount  = Integer.parseInt(input[2].trim());

             int discountAmount = (price * discount) /100;

             if(discountAmount < minDiscount)
             {
                minDiscount = discountAmount;
                list.clear();
                list.add(name);

             }
             else if(discountAmount == minDiscount)
             {
                list.add(name);

             }
        }
        for(String item : list)
        {
            System.out.println(item);
        }

        sc.close();



    }


}