package streams

import spock.lang.Specification

class LazyStreamsSpec extends Specification {
    LazyStreams lz = new LazyStreams()
    LazyStreamsGroovy lzg = new LazyStreamsGroovy()

    def "FirstEvenDivBy3"() {
        expect:
        204 == lz.firstEvenDivBy3()
        204 == lzg.firstEvenDivBy3()
    }

    def "FirstEvenDivBy3Verbose"() {
        when:
        println 'Java:'
        int x = lz.firstEvenDivBy3Verbose()

        then:
        x == 204

        when:
        println 'Groovy:'
        x = lzg.firstEvenDivBy3Verbose()

        then:
        x == 204
    }

    def 'FirstEvenDivBy3UsingStreams'() {
        expect:
        204 == lzg.firstEvenDivBy3UsingStreams()
    }
}
