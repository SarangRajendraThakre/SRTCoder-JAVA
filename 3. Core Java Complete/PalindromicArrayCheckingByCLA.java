public class PalindromicArrayCheckingByCLA {

    public static void main(String[] args) {
        // Check if any command-line arguments were provided
        if (args.length == 0) {
            System.out.println("Please provide at least one string as a command-line argument.");
            return; // Exit the program if no arguments are given
        }

        System.out.println("--- Palindrome Check Results (Using StringBuilder.reverse()) ---");
        // Iterate through each command-line argument
        for (int i = 0; i < args.length; i++) {
            String inputString = args[i]; 
            System.out.println("\nChecking: \"" + inputString + "\"");

            if (isPalindromicStringUsingReverse(inputString)) {
                System.out.println("Result: YES, it is a palindrome!");
            } else {
                System.out.println("Result: NO, it is NOT a palindrome.");
            }
        }
        System.out.println("--------------------------------------------------");
    }


    public static boolean isPalindromicStringUsingReverse(String str) {
    
        StringBuilder stringBuilder = new StringBuilder(str);
        String reversedString = stringBuilder.reverse().toString();

        return str.equals(reversedString);
    }
}