public class P56_ {
    public static void main(String[] args) {
        int num=123;
        int revop=reverseNumber(num,0);
        System.out.println(revop);
    }

    public static int reverseNumber(int num, int rev) {
        if(num==0) return rev;
        int rem =num%10;
          rev = rev * 10+rem;
        //    num /= 10;
   return reverseNumber(num/10, rev);
    }
}
