package lambdas

import spock.lang.Specification
import spock.lang.Unroll

class PrimeCheckerSpec extends Specification {
    PrimeChecker pc = new PrimeChecker()
    PrimeCheckerGroovy pcg = new PrimeCheckerGroovy()

    @Unroll
    def "#x is prime"() {
        expect:
        pc.isPrime(x)
        pc.isPrimeJava7(x)
        pcg.isPrime(x)

        where:
        x << [2, 3, 5, 7, 11, 13, 17, 19]
    }

    @Unroll
    def "#x is not prime"() {
        expect:
        !pc.isPrime(x)
        !pcg.isPrime(x)

        where:
        x << [4, 6, 8, 9, 10, 12, 14, 15, 16, 18]
    }

    @Unroll
    def '#x throws IllegalArgumentException'() {
        when:
        pc.isPrime(x)

        then:
        thrown(IllegalArgumentException)

        where:
        x << (-2..1)
    }
}
