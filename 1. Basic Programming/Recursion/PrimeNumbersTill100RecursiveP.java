package Recursion;

public class PrimeNumbersTill100RecursiveP {

    public static boolean isPrimeRecursive(int divisor, int num) {
        if (num <= 1)
            return false;

        if (num == 2)
            return true;

        if (num % divisor == 0)
            return false;

        if (divisor * divisor > num)
            return true;

        return isPrimeRecursive(++divisor, num);

    }


    public static void printPrimesRecursive(int current , int limit)
    {
        if(current > limit) return ;

        if(isPrimeRecursive(current, limit))
        {
            System.out.print(current+" ");
        }
        printPrimesRecursive(++current, limit);
    }


    public static void main(String[] args) {
        System.out.println("Prime numbers up to 100:");
        printPrimesRecursive(2, 100);
        System.out.println();
    }
}