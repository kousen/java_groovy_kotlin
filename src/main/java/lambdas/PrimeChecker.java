package lambdas;

import java.util.stream.IntStream;

public class PrimeChecker {

    public boolean isPrimeJava7(int x) {
        if (x < 2) throw new IllegalArgumentException("x must be >= 2");
        if (x == 2) return true;
        int limit = (int) Math.sqrt(x) + 1;

        for (int i = 2; i <= limit; i++ ) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrime(int x) {
        if (x < 2) throw new IllegalArgumentException("x must be >= 2");
        int limit = (int) Math.sqrt(x) + 1;

        return x == 2 || IntStream.rangeClosed(2, limit)
                .noneMatch(n -> x % n == 0);
    }
}
