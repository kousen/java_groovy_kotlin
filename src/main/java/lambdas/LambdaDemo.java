package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("Convert2MethodRef")
public class LambdaDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("this", "is", "a",
                "list", "of", "strings");

        // Anonymous inner class impl of Consumer<String>
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // lambda expression for Consumer<String>
        strings.forEach(s -> System.out.println(s));

        // Full block lambda
        strings.forEach((String s) -> {
            System.out.println(s);
        });

        // Method reference
        strings.forEach(System.out::println);

        // Assign to variable
        Consumer<String> printer = System.out::println;
        strings.forEach(printer);
    }
}
