package sorting

import spock.lang.Specification

class SortingDemoGroovySpec extends Specification {
    SortingDemoGroovy demo = new SortingDemoGroovy()

    private boolean checkAlpha(List list) {
        list.inject('') { prev, curr ->
            assert prev <= curr
            curr
        }
    }

    private boolean checkLength(List list) {
        list.inject { String prev, String curr ->
            assert prev.size() <= curr.size()
            curr
        }
    }

    def "DefaultSort"() {
        expect:
        checkAlpha(demo.defaultSort())
    }

    def "LengthSortWithTwoArgClosure"() {
        expect:
        checkLength(demo.lengthSortWithTwoArgClosure())
    }

    def "LengthSortWithOneArgClosure"() {
        expect:
        checkLength(demo.lengthSortWithOneArgClosure())
    }

    def "LengthSortThenAlphaSort"() {
        when:
        List sorted = demo.lengthSortThenAlphaSort()

        then:
        sorted.inject { String prev, String curr ->
            assert prev.size() <= curr.size()
            if (prev.size() == curr.size()) {
                assert prev <= curr
            }
            curr
        }
    }
}
