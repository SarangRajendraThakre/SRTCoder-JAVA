package AbstractDemo;

public class LogicalOperatorRange {

    public static void main(String[] args) {
        

        char ch = 'a';

        System.out.println(((ch >='A'&& ch <='Z')?(ch+" it is a Uppercase alphabet"):(ch+" it is a Lowercase alphabet")  ));
    }
    
}