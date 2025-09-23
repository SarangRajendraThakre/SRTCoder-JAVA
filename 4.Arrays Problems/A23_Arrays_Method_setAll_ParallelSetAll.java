
import java.util.Arrays;
import java.text.NumberFormat;
import java.util.Locale;

public class A23_Arrays_Method_setAll_ParallelSetAll {
    public static void main(String[] args) {

        double[] futureValues = new double[10_000];
        double principal = 1000.0; // ₹1,000 initial investment
        double rate = 0.05; // 5% annual rate

        System.out.println("Calculating future values for 10,000 periods...");

        // The generator function calculates compound interest for each year 'i'.
        // This can be run in parallel because each year's calculation is independent.
        Arrays.parallelSetAll(futureValues, year -> principal * Math.pow(1 + rate, year));

        System.out.println("Calculation complete.");
        
        // Let's print a few sample values to see the result
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("en-IN"));

        System.out.println("Value after 0 years: " + currencyFormatter.format(futureValues[0]));
        System.out.println("Value after 10 years: " + currencyFormatter.format(futureValues[10]));
        System.out.println("Value after 50 years: " + currencyFormatter.format(futureValues[50]));
    }
}