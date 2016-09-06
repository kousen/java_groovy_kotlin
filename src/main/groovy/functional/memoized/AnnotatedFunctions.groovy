package functional.memoized

import groovy.transform.Memoized
import groovy.transform.TailRecursive

class AnnotatedFunctions {
    @Memoized
    BigInteger fib(BigInteger n) {
        if (n < 2) 1
        else fib(n - 1) + fib(n - 2)
    }

    @Memoized
    BigInteger fact(BigInteger n) {
        if (n < 2) 1
        else n * fact(n - 1)
    }

    @Memoized
    long add(long x, long y) {
        sleep(1000)
        x + y
    }

    @TailRecursive
    BigInteger factorial(BigInteger n, BigInteger acc = 1G) {
        n < 2 ? acc : factorial(n - 1G, n * acc)
    }
}
