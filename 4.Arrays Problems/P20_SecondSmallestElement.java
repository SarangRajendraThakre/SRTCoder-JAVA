
public class P20_SecondSmallestElement {

    public static void main(String[] args) {
        int[] arr = { 23, 44, 34, -4, 56, 653, 75, 66, 5, 54, 54, 47, 75, 6, 5, 4, 44, 3, 76, 7756, 567, 87 };

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int ele : arr) {
            if (firstMin > ele) {
                secondMin = firstMin;
                firstMin = ele;
            } else if (secondMin > ele) {
                secondMin = ele;
            }
        }

        System.out.println("The first mininum ele is " + firstMin + " and second element is " + secondMin);

    }
}