public class P178_ContainerWithMostWater {

    public static void main(String[] args) {
        int[] arr = {2, 6, 3, 4, 6, 2, 3, 6, 9, 9, 2, 2, 22};
        maximumWater(arr);
    }

    public static void maximumWater(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int area = Math.min(height[left], height[right]) * width;
            max = Math.max(max, area);

            // move the pointer with the smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("Maximum water area: " + max);
    }
}
