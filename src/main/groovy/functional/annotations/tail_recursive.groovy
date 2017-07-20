package functional.annotations

import groovy.transform.TailRecursive

import static java.math.BigInteger.ONE

@TailRecursive
def fact(n, acc = ONE) {
    n < 2 ? acc : fact(n - ONE, n * acc)
}

def result = fact(70000)
assert "$result".size() == 308_760