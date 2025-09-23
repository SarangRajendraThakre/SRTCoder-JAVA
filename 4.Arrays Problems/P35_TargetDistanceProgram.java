import java.util.Arrays;

public class P35_TargetDistanceProgram {

    public static void main(String[] args) {
        
        int n = 3 ;
        int q = 4 ;

        int [] distance = {50 , 55 , 60};
        int [] targetDistance = {60 , 50, 50 , 65};

        int [] op = solve(n , q , distance , targetDistance);
        System.out.println(Arrays.toString(op));
    }

    private static int[] solve(int n , int q , int[] distance , int[] targetDistance )
    {
        int[] op = new int[q];
        int index = 0 ;

        for(int i : targetDistance)
        {
            int sum = 0;

            for(int j : distance)
            {
                int ans = i-j;
                sum += ans < 0 ? ans*-1 : ans;
            }
            op[index++] = sum;
        }

        return op;
    }
}





