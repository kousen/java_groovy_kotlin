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
}
