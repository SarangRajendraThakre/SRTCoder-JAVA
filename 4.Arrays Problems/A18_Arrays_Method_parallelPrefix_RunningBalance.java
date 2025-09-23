import java.util.Arrays;

public class A18_Arrays_Method_parallelPrefix_RunningBalance {
    public static void main(String[] args) {
        // An array representing deposits (+) and withdrawals (-)
        int[] transactions = {500, -50, 200, -120, 300};
        
        System.out.println("Transactions: " + Arrays.toString(transactions));

        // Use parallelPrefix to calculate the cumulative sum
        Arrays.parallelPrefix(transactions, (balance, transaction) -> balance + transaction);

        System.out.println("Account balance after each transaction: " + Arrays.toString(transactions));
    }
}