package Recursion;

class Printing1To100 {

    public static void main(String[] args) {
        // Start printing from 1 up to 100
        printing1To100(1); 
    }

    public static void printing1To100(int num) {
        if (num > 100) {
            return; 
        }

        System.out.println(num);

        // Recursive step: Call the function for the next number
        printing1To100(num + 1); 
    }
}