package lambdas

class PrimeCheckerGroovy {

    boolean isPrime(int x) {
        if (x < 2) throw new IllegalArgumentException("x must be >= 2")

        int limit = (int) Math.sqrt(x) + 1
        x == 2 || !(2..limit).find { n -> x % n == 0 }
    }
}
