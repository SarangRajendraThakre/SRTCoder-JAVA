
enum Operation {
    ADD, SUBSTRACT, MULTIPLY, DIVIDE;

    public <T extends Number> double apply(T a, T b) {
        switch (this) {
            case ADD:
            return a.doubleValue()+b.doubleValue();

            case SUBSTRACT:

            return a.doubleValue() - b.doubleValue();
        
            case MULTIPLY:
             return a.doubleValue() * b.doubleValue();

            default:
            throw new AssertionError("Unknown operation"+this);
              
        }
    }
}


public class Enum1 {

     public static void main(String[] args) {
        System.out.println(Operation.ADD.apply(10, 20));
     }
}