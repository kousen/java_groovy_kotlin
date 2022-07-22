package functional.annotations

import spock.lang.Specification

class AnnotatedFunctionsTest extends Specification {
    AnnotatedFunctions af = new AnnotatedFunctions()

    def "fibonacci"() {
        expect:
        fibn == af.fib(n as BigInteger)

        where:
        n  || fibn
        1  || 1
        2  || 1
        3  || 2
        4  || 3
        5  || 5
        6  || 8
        7  || 13
        8  || 21
        9  || 34
        10 || 55
    }

    def "factorial with memoize"() {
        expect:
        factn == af.fact(n as BigInteger)

        where:
        n || factn
        0 || 1
        1 || 1
        2 || 2
        3 || 3 * 2
        4 || 4 * 3 * 2
        5 || 5 * 4 * 3 * 2
        6 || 6 * 5 * 4 * 3 * 2
        7 || 7 * 6 * 5 * 4 * 3 * 2
        8 || 8 * 7 * 6 * 5 * 4 * 3 * 2
    }

    def "factorial with tail recursion"() {
        expect:
        factn == af.factorial(n as BigInteger)

        where:
        n || factn
        0 || 1
        1 || 1
        2 || 2
        3 || 3 * 2
        4 || 4 * 3 * 2
        5 || 5 * 4 * 3 * 2
        6 || 6 * 5 * 4 * 3 * 2
        7 || 7 * 6 * 5 * 4 * 3 * 2
        8 || 8 * 7 * 6 * 5 * 4 * 3 * 2
    }

    def "greatest common denominator"() {
        expect:
        24 == af.gcd(48, 72)
        14 == af.gcd(182, 154)
    }

    // Example from GroovyDocs on @TailRecursive
    def "sum up to a given number with tail recursion"() {
        expect:
        5050L == af.sumUp(100)
        500_000_500_000 == af.sumUp(1_000_000)
    }

    // Example from GroovyDocs on @TailRecursive
    def 'sizeOfList'() {
        expect:
        10_000L == af.sizeOfList(1..10000)
    }
}
