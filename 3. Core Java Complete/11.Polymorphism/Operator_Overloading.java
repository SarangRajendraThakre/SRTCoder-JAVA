public class Operator_Overloading {

    public static void main(String[] args) {

        String a = "Hello";
        String b = "World";
        String c = a + b; // Operator overloading in action
        System.out.println(c);
    }

}

///In this case, the + operator's behavior is overloaded by the Java compiler to perform string concatenation instead of addition.


// Why Not All Operator Overloading?
// The designers of Java believed that allowing custom operator overloading would make code harder to read and understand. 
// For instance, if an operator like * could be redefined to perform a completely different operation (like list concatenation),
//  it would break developer expectations and lead to non-intuitive code. Java prioritizes clarity over flexibility in this area.
