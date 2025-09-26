package StreamAPI.LambdaFunction;

public class P3_lambda_ {
    public static void main(String[] args) {

        // Pass Task object to Thread
        // Thread t1 = new Thread(()-> {
        // System.out.println("hello");
        // });

        // lambda expression is anonymous function
        // (without access modifier ,without return type,no method name )

        // functional Interface reference can hold lambda expression

        MathOperation sumOperaton = (a, b) -> a + b;

        int result = sumOperaton.operate(3, 4);

        System.out.println(result);

    }

}

interface MathOperation {
    int operate(int a, int b);
}
