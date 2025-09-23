
public class P144_Maximum_Candies {

    public static void main(String[] args) {
        // Your code here

        int costPerCandy = 2;
        int rupees = 20;
        int wrapperExchange = 3;

        System.out.println(maximumCandies(costPerCandy, rupees, wrapperExchange));

    }

    public static int maximumCandies(int costPerCandy, int rupees, int wrapperExchange) {

        int totalCandies = rupees / costPerCandy;

        int wrappers = totalCandies;

        while (wrappers >= wrapperExchange) {

            int newCandies = wrappers / 3;
            int remainingWrappers = wrappers % 3;
            wrappers = remainingWrappers + newCandies;
            totalCandies += newCandies;

        }
        return totalCandies;

    }
}
