package StreamAPI.LambdaFunction;

public class P4_lambda_ {
    public static void main(String[] args) {
        Converter<String, Integer> stringToInt = s -> Integer.parseInt(s);
        Integer result = stringToInt.convert("3454");
        System.out.println(result);
    }

}

interface Converter<T, R> {

    R convert(T t);
}
