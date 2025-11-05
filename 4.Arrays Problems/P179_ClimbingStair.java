public class P179_ClimbingStair {

    public static void main(String[] args) {
        int top = 10;
        System.out.println("Number of ways: " + howManyWays(top));
    }

    public static int howManyWays(int top) {
        if (top == 1) return 1;
        if (top == 2) return 2;

        int one = 1;  // ways to reach step 1
        int two = 2;  // ways to reach step 2
        int total = 0;

        for (int i = 3; i <= top; i++) {
            total = one + two;
            one = two;
            two = total;
        }

        return total;
    }
}
