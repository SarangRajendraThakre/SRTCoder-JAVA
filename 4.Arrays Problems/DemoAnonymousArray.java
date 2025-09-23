public class DemoAnonymousArray {

    public static int sumArrayElements(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("--- Demo Anonymous Array ---");

        int sum1 = sumArrayElements(new int[] { 10, 20, 30 });
        System.out.println("Sum of elements using anonymous array (1,2,3): " + sum1);

        int sum2 = 0;
        for (int value : new int[] { 5, 10, 15 }) {
            sum2 += value;
        }
        System.out.println("Sum of elements using anonymous array (5,10,15): " + sum2);

        String[] colors = new String[] { "Red", "Green", "Blue" };
        System.out.println("Anonymous String array elements: " + java.util.Arrays.toString(colors));
        System.out.println("Length of anonymous String array: " + colors.length);
    }
}