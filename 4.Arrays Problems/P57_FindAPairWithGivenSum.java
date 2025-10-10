public class P57_FindAPairWithGivenSum {

    public static void main(String[] args) {
        int[] arr = { 10, 20, 40, -10, 10 };
        int target = 30;

        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Pair found: (" + arr[i] + ", " + arr[j] + ")");
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No pair with sum " + target + " found.");
        }
    }
}
