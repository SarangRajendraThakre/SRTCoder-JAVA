package StreamAPI;

import java.util.*;
import java.util.function.Consumer;

public class P3_ConsumerDemoP {

    public void runConsumerExamples() {

        List<String> list = Arrays.asList("Sarang", "yadnesh", "Rajendra", "Vidya");

        Consumer<String> names = n -> System.out.println("Name : " + n);

        Consumer<String> length = n -> System.out.println("Length : " + n.length());

        System.out.println("-----------------accept()-------------------");

        names.accept("Jai Shani Ganesh");

        list.forEach(n -> names.accept(n));

        System.out.println("---------length------------");
        list.forEach(n -> length.accept(n));

        length.accept("Sarang");

        System.out.println("-----------------andThen()-------------------");
        Consumer<String> combine = names.andThen(length);
        combine.accept("Sarang");

        list.forEach(n -> combine.accept(n));
        System.out.println();

        System.out.println("-----------------using the consumer in stream-------------------");

        list.stream()
                .map(String::toUpperCase)
                .forEach(names);

    }

    public static void main(String[] args) {
        P3_ConsumerDemoP demo = new P3_ConsumerDemoP();
        demo.runConsumerExamples();
    }
}
