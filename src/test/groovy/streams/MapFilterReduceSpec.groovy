package streams

import spock.lang.Specification

class MapFilterReduceSpec extends Specification {
    MapFilterReduce demo = new MapFilterReduce()

    def "SumAllLengths"() {
        expect:
        20 == demo.sumAllLengths()
    }

    def "SumEvenLengthStrings"() {
        expect:
        12 == demo.sumEvenLengthStrings()
    }

    def "SumOddLengthStrings"() {
        expect:
        8 == demo.sumOddLengthStrings()
    }
    boolean isEven(int n) {
        n % 2 == 0
    }

    def "SumStringsWithPredicate"() {
        expect:
        12 == demo.sumStrings(this.&isEven)
        12 == demo.sumStrings(this::isEven)
        8 == demo.sumStrings { it % 2 != 0 }
        8 == demo.sumStrings( n -> n % 2 != 0)
        12 == demo.sumStrings(MapFilterReduce.EVENS)
        8 == demo.sumStrings(MapFilterReduce.ODDS)
    }
}
