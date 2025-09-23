interface Operator<T> {
    T apply(T a, T b);
}

 enum Enum implements Operator<Integer> {
    ADD {
        @Override
        public Integer apply(Integer a, Integer b) {
            return a + b;
        }
    },
    SUBSTRACT {
        @Override
        public Integer apply(Integer a, Integer b) {
            return a - b;
        }
    }; // A semicolon is required here since the enum has a method
}

public class Enum2 {
    public static void main(String[] args) {
        System.out.println(Enum.SUBSTRACT.apply(10, 4));
        System.out.println(Enum.ADD.apply(10, 4));
    }
}