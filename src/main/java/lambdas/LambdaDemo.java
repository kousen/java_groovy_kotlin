package lambdas;

import java.util.List;
import java.util.function.Consumer;

//@SuppressWarnings("Convert2MethodRef")
public class LambdaDemo {
    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        List<String> strings = List.of("this", "is", "a", "list", "of", "strings");

        // Anonymous inner class impl of Consumer<String>
        strings.forEach(new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println("The string is " + s);
            }
        });

        // Use a simple expression lambda for Consumer<String> that prints each value
        strings.forEach(s -> System.out.println("The string is " + s));

        // Use the full block form of the lambda
        //noinspection CodeBlock2Expr
        strings.forEach(s -> {
            System.out.println("The string is " + s);
        });

        // Use a method reference to print each value
        // strings.forEach( /* method reference for println */ );

        // Assign lambda to variable
        // Consumer<String> printer = // lambda or method reference
        // strings.forEach(printer);
    }
}
