public class P1_SumOfArray {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 5};

        int sum  = 0;

        for (int num : numbers) {
            sum += num;
        }
        System.out.println("The sum of all elements is: " + sum);
    }
}
