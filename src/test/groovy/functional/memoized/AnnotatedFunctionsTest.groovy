package functional.memoized

import spock.lang.Specification

class AnnotatedFunctionsTest extends Specification {
    AnnotatedFunctions af = new AnnotatedFunctions()

    def "fibonacci"() {
        expect:
        fibn == af.fib(n)

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
        factn == af.fact(n)

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
        factn == af.factorial(n)

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
    def "sumUp with tail recursion"() {
        expect:
        5050 == af.sumUp(100)
        500_000_500_000 == af.sumUp(1_000_000)
    }

    // Example from GroovyDocs on @TailRecursive
    def 'sizeOfList'() {
        expect:
        10_000 == af.sizeOfList(1..10000)
    }
}
