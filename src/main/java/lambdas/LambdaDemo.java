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

        // Use a simple expression lambda for Consumer<String> that prints each value
        // strings.forEach( /* lambda */);

        // Use the full block form of the lambda
        // strings.forEach( /* block lambda */ );

        // Use a method reference to print each value
        // strings.forEach( /* method reference for println */ );

        // Assign lambda to variable
        // Consumer<String> printer = // lambda or method reference
        // strings.forEach(printer);
    }
}
