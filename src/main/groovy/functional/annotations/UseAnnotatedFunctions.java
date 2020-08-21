package functional.annotations;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class UseAnnotatedFunctions {
    private final AnnotatedFunctions mf = new AnnotatedFunctions();

    public void timings() {
        IntStream.range(1, 100)
                .forEach(i -> {
                    long before = System.nanoTime();
                    BigInteger val = mf.fib(new BigInteger(i + ""));
                    long after = System.nanoTime();
                    System.out.printf("%3d: %8s, fib(%2d) = %d%n", i, (after - before) / 1e9, i, val);
                });


        System.out.println(mf.add(3, 5));
        System.out.println(mf.add(3, 5));
        System.out.println(mf.add(3, 5));

        IntStream.range(1, 100)
                .forEach(i -> {
                    long before = System.nanoTime();
                    BigInteger val = mf.fact(new BigInteger(i + ""));
                    long after = System.nanoTime();
                    System.out.printf("%3d: %8s, fact(%2d) = %d%n", i, (after - before) / 1e9, i, val);
                });

        System.out.println("70000! has " +
                mf.factorial(new BigInteger(70_000 + "")).toString().length() +
                " digits");
    }

    public static void main(String[] args) {
        UseAnnotatedFunctions uf = new UseAnnotatedFunctions();
        uf.timings();
    }
}
